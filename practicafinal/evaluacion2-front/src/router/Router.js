import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from '../components/login/Login';
import Main from '../components/main/Main';
import FormCliente from '../components/form_cliente/FormCliente';
import FormProducto from '../components/form_producto/FormProducto';
import Error from '../components/error/Error';
import Header from '../components/header/Header';
import Footer from '../components/footer/Footer';

export default function Router() {
  return (
    <>
        <BrowserRouter>
            <Header/>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/index" element={<Main />} />
                <Route path="/formulario_cliente/:id" element={<FormCliente />} />
                <Route path="/formulario_cliente" element={<FormCliente />} />
                <Route path="/formulario_producto/:id" element={<FormProducto />} />
                <Route path="/formulario_producto" element={<FormProducto />} />
                <Route path="/error" element={<Error />} />
                <Route path="*" element={<Error />} />
            </Routes>
            <Footer/>
        </BrowserRouter>
    </>
  )
}
