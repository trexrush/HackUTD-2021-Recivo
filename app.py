from flask import Flask, render_template, request, redirect, jsonify, Response, json
import pytesseract
import re
from PIL import Image

app = Flask(__name__)

@app.route('/')
def index():
    return ('<p>Try /api/v1/endpoint next time.</p>')

# route that receives a POST request containing an image
@app.route('/api/v1/add', methods=['POST'])
def endpoint():
    # get the image from the request
    receipt = request.files['image']
    # save the image to disk
    receipt.save(f'images/{receipt.filename}')
    text = pytesseract.image_to_string(f'images/{receipt.filename}')
    text_arr = text.split('\n')
    # get only dollar amounts from text_arr
    dollar_arr = [x for x in text_arr if re.match(r'\$\d+\.\d{2}', x)]
    dollar_arr.remove(dollar_arr[7])
    # get only the words with no numbers in them from text_arr
    words_arr = [x for x in text_arr if not re.match(r'\d+', x)]
    words_arr = words_arr[5:28]
    print(dollar_arr)
    for i in words_arr:
        if i == " " or i == "" or i == "  " or i == None:
            words_arr.remove(i)
            if i.find('Total') == 1:
                i = 'Total'
    words_arr.remove(words_arr[5])
    words_arr.remove(words_arr[5])     
    words_arr.remove(words_arr[6])  
    words_arr.remove(words_arr[6])  
    words_arr.remove(words_arr[6])  


    date = words_arr[0]
    words_arr.pop(0)
    words_arr.remove('Subtotal')
    
        
    print(words_arr)
    # if duplicate items in words_arr, then append the quantity to the item


    items = {}
    print(len(dollar_arr))
    print(len(words_arr))
    # puts the items and prices into a dictionary
    for i in range(len(words_arr)):
        items[words_arr[i]] = dollar_arr[i]
    print(items)
    total = items.pop('Total \u2014')
    actual = {'total': total, 'date': date, 'items': items}
    return request.post(json.dumps(actual), mimetype='application/json')




