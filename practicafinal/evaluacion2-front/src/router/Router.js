import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from '../components/login/Login';
import Main from '../components/main/Main';
import FormCliente from '../components/form_cliente/FormCliente';
import FormProducto from '../components/form_producto/FormProducto';

export default function Router() {
  return (
    <>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/index" element={<Main />} />
                <Route path="/cliente" element={<FormCliente />} />
                <Route path="/producto" element={<FormProducto />} />
                <Route path="/error" element={<Error />} />
                <Route path="*" element={<Error message={"Error: ruta desconocida"}/>} />
            </Routes>
        </BrowserRouter>
    </>
  )
}
