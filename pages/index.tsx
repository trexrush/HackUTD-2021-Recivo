import type { NextPage } from 'next'
import Navbar from '../components/Navbar'
import axios from 'axios'
import { Box } from '@mui/system'
import TextField from '@mui/material/TextField';
import { Button } from '@mui/material';

const Home: NextPage = () => {
  return (
    <>
      <div className="flexcolumn">
        {/* logo */}
        <div className="title">Welcome to our planner!</div>
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

// balls 69

export default Home
