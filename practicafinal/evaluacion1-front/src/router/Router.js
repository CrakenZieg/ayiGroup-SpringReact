import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from '../components/login/Login';
import Main from '../components/main/Main';
import FormEmpleado from '../components/form_empleado';

export default function Router() {
  return (
    <>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/index" element={<Main />} />
                <Route path="/formulario_empleado" element={<FormEmpleado />} />
                <Route path="/error" element={<Error />} />
                <Route path="*" element={<Error message={"Error: ruta desconocida"}/>} />
            </Routes>
        </BrowserRouter>
    </>
  )
}