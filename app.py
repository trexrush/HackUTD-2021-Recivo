from flask import Flask, render_template, request, redirect, jsonify

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
    # return a response
    return jsonify({'message': 'Image received. Check /images/receipt.jpg for your receipt.'})
