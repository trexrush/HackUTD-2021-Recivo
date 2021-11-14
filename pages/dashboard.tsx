import type { NextPage } from 'next'
import Navbar from '../components/Navbar'

import {
  XYPlot,
  XAxis,
  YAxis,
  VerticalGridLines,
  HorizontalGridLines,
  VerticalBarSeries,
  VerticalBarSeriesCanvas,
  LabelSeries
} from 'react-vis';

const greenData = [
                    {x: 'Jan', y: 101},
                    {x: 'Feb', y: 53},
                    {x: 'Mar', y: 934},
                    {x: 'Apr', y: 100},
                    {x: 'May', y: 300},
                    {x: 'Jun', y: 700},
                    {x: 'Jul', y: 12},
                    {x: 'Aug', y: 310},
                    {x: 'Sep', y: 783},
                    {x: 'Oct', y: 821},
                    {x: 'Nov', y: 134},
                    {x: 'Dec', y: 665},
                  ];

const labelData = greenData.map((d, idx) => ({
  x: d.x,
  y: greenData[idx].y
}));

const Expenses: NextPage = () => {
  // api call

  return (
    <>
        <Navbar/>
        <div className="flexcolumn container">
          <div>[USER.NAME]'s Expenses</div>
          <div>Total : $[USER.TOTAL]</div>
          <div>(Monthly Rundown Selection) [QUERY]</div>
          <div>Tax Discount (2021) : $[QUERY]</div>
          <div>
            <XYPlot xType="ordinal" width={400} height={300} xDistance={100}>
              <VerticalGridLines />
              <HorizontalGridLines />
              <XAxis />
              {/* <YAxis /> */}
              <VerticalBarSeries className="vertical-bar-series-example" data={greenData} />
            </XYPlot>
          </div>
        </div>

    </>
  )
}

export default Expenses