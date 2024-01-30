import React from 'react';
import { useState, useEffect } from 'react';
import Service from '../../service/FetchService';
import Results from '../results/Results';

export default function WithFetch() {

    const  [data, setData] = useState({});

    useEffect(()=>{
        Service.getOne()
            .then((response)=>{setData(response.meals[0]);})
            .catch((error) => { console.log(error) });
    },[])

  return (
    <Results {...data}/>
  )
}
