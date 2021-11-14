let monthdata = {
    data: {
        january: 3,
        february: 6,
        march: 24,
        april: 17,
        may: 18,
        june: 5,
        july: 7,
        august: 53,
        september: 1,
        october: 35,
        november: 9,
        december: 11,
    }
}

let login = {
  "userId": 1,
  "username": "john",
  "email": "john@example.com",
  "password": "pass",
  "total": 10,
  "receipts": [
      {
          "receiptId": 1,
          "total": 21,
          "date": "13-01-2021",
          "items": [
              {
                  "itemId": 1,
                  "price": 12,
                  "name": 'Pizza',
                  "taxable": false
              },
              {
                  "itemId": 2,
                  "price": 9,
                  "name": 'Breadsticks',
                  "taxable": false
              }
          ]
      }
  ]
}

export { monthdata, login }