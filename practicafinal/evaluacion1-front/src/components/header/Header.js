import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { NavLink, redirect } from 'react-router-dom';

export default function Header() {

    const { user, loginUser, logoutUser } = useAuth();

    function logout(e){
        e.preventDefault();
        logoutUser();
        redirect("/");
    }

  return (
    <>
        <Navbar bg="dark" data-bs-theme="dark">
            <Container>
                {
                user!=="" &&                
                <Nav className="me-auto" >
                    <Nav.Link as={NavLink} to="/index" className={({isActive})=>isActive ? "":"text-white"}>
                        Inicio
                    </Nav.Link>
                    <Nav.Link as={NavLink} to="/index#empleado" className={({isActive})=>isActive ? "":"text-white"}>
                        Tabla de empleados
                    </Nav.Link>
                    <Nav.Link as={NavLink} to="/formulario_empleado" className={({isActive})=>isActive ? "":"text-white"}>
                        Formulario de empleados
                    </Nav.Link>
                    <Nav.Link as={NavLink} onclick={e=>logout(e)} className={text-danger}>
                        <i class="bi bi-box-arrow-right"></i> Logout
                    </Nav.Link>
                </Nav>
                }
            </Container>
        </Navbar>
    </>
  )
}
