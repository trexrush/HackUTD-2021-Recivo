import type { NextPage } from 'next'
import Navbar from '../components/Navbar'
import axios from 'axios'
import { Box } from '@mui/system'
import TextField from '@mui/material/TextField';
import { Button } from '@mui/material';

const Home: NextPage = () => {
  return (
    <>
      <div className="flexcolumn container">
        {/* logo */}
        <div className="title">Spence</div>
        <div className="login_box flexcolumn">
          <TextField id="outlined-basic" label="Username" variant="outlined" />
          <TextField id="outlined-basic" label="Password" variant="outlined" />
          <Button variant="outlined">Login</Button>
        </div>
      </div>
      <Navbar/>
    </>
  )
}

/* SEND */

// localhost:port/api/user/new

// WE SEND
// {
//   "userId": 1,
//   "username": "john",
//   "email": "john@example.com",
//   "password": "pass",
//   "total": 10,
//   "receipts": null
// }

// WE RECIEVE
// {
//   "username": "john",
//   "email": "john@example.com",
//   "password": "pass",
//   "total": 0
// }

/* LOGIN */

// localhost:port/api/user/login

// WE SEND
// {
//   "username": "john",
//   "password": "pass"
// }

// WE RECIEVE

// {
//   "userId": 1,
//   "username": "john",
//   "email": "john@example.com",
//   "password": "pass",
//   "total": 10,
//   "receipts": [
//       {
//           "receiptId": 1,
//           "total": 21,
//           "date": "13-01-2021",
//           "items": [
//               {
//                   "itemId": 1,
//                   "price": 12,
//                   "name": “Pizza”,
//                   "taxable": false
//               },
//               {
//                   "itemId": 2,
//                   "price": 9,
//                   "name": “Breadsticks”,
//                   "taxable": false
//               }
//           ]
//       }
//   ]
// }



// balls 69

export default Home
