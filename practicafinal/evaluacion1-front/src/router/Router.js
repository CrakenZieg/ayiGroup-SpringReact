import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from '../components/login/Login';
import Main from '../components/main/Main';
import FormEmpleado from '../components/form_empleado/FormEmpleado';
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
                <Route path="/formulario_empleado/:id" element={<FormEmpleado />} />
                <Route path="/formulario_empleado" element={<FormEmpleado />} />
                <Route path="/error" element={<Error />} />
                <Route path="*" element={<Error />} />
            </Routes>
            <Footer/>
        </BrowserRouter>
    </>
  )
}