import { useEffect } from 'react'
import type { NextPage } from 'next'
import Navbar from '../components/Navbar'
import axios from 'axios'
import 'react-dropzone-uploader/dist/styles.css'
import Dropzone from 'react-dropzone-uploader'

const ImageAudioVideo = () => {
  return (
    <Dropzone
      getUploadParams={getUploadParams}
      onChangeStatus={handleChangeStatus}
      onSubmit={handleSubmit}
      accept="image/*"
      inputContent={(files, extra) => (extra.reject ? 'Image, audio and video files only' : 'Drag Files')}
      styles={{
        dropzoneReject: { borderColor: 'red', backgroundColor: '#DAA' },
        inputLabel: (files, extra) => (extra.reject ? { color: 'red' } : {}),
      }}
    />
  )
}



// localhost:5000/api/v1/add
const Reciepts: NextPage = () => {
  return (
    <>
      <Navbar/>
      <ImageAudioVideo />
      <div>Reciepts</div>
    </>
  )
}



export default Reciepts