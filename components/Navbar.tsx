import * as React from 'react'
import Box from '@mui/material/Box'
import { Button } from '@mui/material'
import BottomNavigation from '@mui/material/BottomNavigation'
import BottomNavigationAction from '@mui/material/BottomNavigationAction'

export default function SimpleBottomNavigation() {
  return (
    <>
      <BottomNavigation showLabels>
        <Button href="/"> 
            <div>Home</div>
            {/* <BottomNavigationAction label="Home" /> */}
        </Button>
        <Button href="/reciept">
            <div>Reciept</div>
            {/* <BottomNavigationAction label="Reciept" /> */}
        </Button>
        <Button href="/dashboard">
            <div>Expenses</div>
            {/* <BottomNavigationAction label="Expenses" /> */}
        </Button>
      </BottomNavigation>
    </>
  );
}