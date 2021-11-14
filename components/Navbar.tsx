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
            <BottomNavigationAction label="Home" href="/" />
            <BottomNavigationAction label="Reciept" href="/reciept"/>
            <BottomNavigationAction label="Expenses" href="/dashboard" />
      </BottomNavigation>
      </Box>
    </>
  );
}