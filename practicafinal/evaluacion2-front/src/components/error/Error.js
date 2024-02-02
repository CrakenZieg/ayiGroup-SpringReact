import React from 'react'

export default function Error(message) {

    let msg = message? message : "";

  return (
    <>
        <h1>Error: </h1>
        <p>{msg}</p>
    </>
  )
}
