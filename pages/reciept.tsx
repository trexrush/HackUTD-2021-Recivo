import { useEffect } from 'react'
import type { NextPage } from 'next'
import Navbar from '../components/Navbar'
import axios from 'axios'



// localhost:5000/api/v1/add
const Reciepts: NextPage = () => {
  // postImage = useEffect = () => {
  //   let formData = new FormData();
  //   let imagefile = document.querySelector('#file');
  //   formData.append("image", imagefile.files[0]);
  //   axios.post('upload_file', formData, {
  //     headers: {
  //       'Content-Type': 'multipart/form-data'
  //     }
  // }
  // }
  return (
    <>
      <Navbar/>
      <div>Reciepts</div>
    </>
  )
}



export default Reciepts