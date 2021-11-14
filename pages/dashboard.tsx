import type { NextPage } from 'next'
import Navbar from '../components/Navbar'
import { monthdata, login } from '../components/sampledata'

import {
  XYPlot,
  XAxis,
  YAxis,
  VerticalGridLines,
  HorizontalGridLines,
  VerticalBarSeries
} from 'react-vis';
// import { Paper, TableContainer, Table, TableHead, TableRow, TableCell, TableBody } from '@mui/material';


const data = [
                    {x: 'Jan', y: monthdata.data.january},
                    {x: 'Feb', y: monthdata.data.february},
                    {x: 'Mar', y: monthdata.data.march},
                    {x: 'Apr', y: monthdata.data.april},
                    {x: 'May', y: monthdata.data.may},
                    {x: 'Jun', y: monthdata.data.june},
                    {x: 'Jul', y: monthdata.data.july},
                    {x: 'Aug', y: monthdata.data.august},
                    {x: 'Sep', y: monthdata.data.september},
                    {x: 'Oct', y: monthdata.data.october},  
                    {x: 'Nov', y: monthdata.data.november},
                    {x: 'Dec', y: monthdata.data.december},
                  ];

const Expenses: NextPage = () => {
  // api call

  return (
    <>
        <div className="flexcolumn container">
          <div>{login.username}'s Expenses</div>
          <div>Total : ${login.total}</div>
          {/* <div>(Monthly Rundown Selection) [QUERY]</div> */}
          {/* data.map() */}
          <div>
            <XYPlot xType="ordinal" width={400} height={300} xDistance={100}>
              <VerticalGridLines />
              <HorizontalGridLines />
              <XAxis />
              <YAxis />
              <VerticalBarSeries className="vertical-bar-series-example" data={data} />
            </XYPlot>
          </div>
        </div>
        <Navbar/>

    </>
  )
}

export default Expenses