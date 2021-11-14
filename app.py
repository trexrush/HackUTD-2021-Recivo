from flask import Flask, render_template, request, redirect, jsonify
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
    # get only the words with no numbers in them from text_arr
    words_arr = [x for x in text_arr if not re.match(r'\d+', x)]
    words_arr = words_arr[5:28]
    for i in words_arr:
        if i == " " or i == "" or i == "  " or i == None:
            print(words_arr.remove(i))
            if i.find('Total') == 1:
                i = 'Total'
    words_arr.remove(words_arr[5])
    words_arr.remove(words_arr[5])     
    words_arr.remove(words_arr[6])  
    words_arr.remove(words_arr[6])  
    words_arr.remove(words_arr[6])  

    date = words_arr[0]

    total = 0
    for i in dollar_arr:
        total += float(i[1:])
    total = sum([float(x.replace('$', '')) for x in dollar_arr])
    dollar_arr = [float(x.replace('$', '')) for x in dollar_arr]

    items = {}
    for i in words_arr[1:]:
        for j in dollar_arr:
            items[i] = float(j)


    return jsonify({'total': total, 'date': date, 'items': items})



