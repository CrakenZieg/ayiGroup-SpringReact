import React from 'react'
import { useState, useEffect } from 'react';
import Service from '../../service/AxiosService';
import Results from '../results/Results';


export default function WithAxios() {

    const  [data, setData] = useState({});

    useEffect(()=>{
        Service.getOne()
            .then((response)=>{
                setData(response.meals[0]);
            })
            .catch((error) => { console.log(error) });
    },[])

  return (
    <Results {...data}/>
  )
}
