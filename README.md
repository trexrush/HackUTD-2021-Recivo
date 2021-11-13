
# HackUTD-SAJE
Project for the HackUTD Hackathon


## To run: 
1. Install python >= 3
2. `pip install` all the packages in `requirements.txt` (as of now, just `pip install flask`)
3. In terminal, set env variable `FLASK_APP = app.py`
4. In terminal, `flask run`

## What now? 
Make a **POST** request to `localhost:5000/api/v1/add` with your image. If it worked, you'll get `{'message': 'Image received. Check /images/receipt.jpg for your receipt.'}`. No error handling as of yet, but I should probably add that pretty soon.
