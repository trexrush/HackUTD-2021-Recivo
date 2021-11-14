import * as React from 'react'
import Box from '@mui/material/Box'
import { Button } from '@mui/material'
import BottomNavigation from '@mui/material/BottomNavigation'
import BottomNavigationAction from '@mui/material/BottomNavigationAction'

export default function SimpleBottomNavigation() {
  const [value, setValue] = React.useState(0);

  return (
    <>
    <Box sx={{ width: 500 }}>
      <BottomNavigation
        showLabels
        className="navbar"
        value={value}
        onChange={(_event, newValue) => {
          setValue(newValue);
        }}
      >
        {/* <Button color="secondary" variant="contained" href="/">  */}
            {/* <div>Home</div> */}
            <BottomNavigationAction label="Home" href="/" />
        {/* </Button> */}
        {/* <Button href="/reciept"> */}
            {/* <div>Reciept</div> */}
            <BottomNavigationAction label="Reciept" href="/reciept"/>
        {/* </Button> */}
        {/* <Button href="/dashboard"> */}
            {/* <div>Expenses</div> */}
            <BottomNavigationAction label="Expenses" href="/dashboard" />
        {/* </Button> */}
      </BottomNavigation>
      </Box>
    </>
  );
}