import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { NavLink, redirect } from 'react-router-dom';
import { BoxArrowRight } from 'react-bootstrap-icons';

export default function Header() {

    const { user, logoutUser } = useAuth();

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
                    <Nav.Link as={NavLink} to="/index#clientes" className={({isActive})=>isActive ? "":"text-white"}>
                        Tabla de clientes
                    </Nav.Link>
                    <Nav.Link as={NavLink} to="/formulario_cliente" className={({isActive})=>isActive ? "":"text-white"}>
                        Formulario de clientes
                    </Nav.Link>
                    <Nav.Link as={NavLink} to="/index#productos" className={({isActive})=>isActive ? "":"text-white"}>
                        Tabla de productos
                    </Nav.Link>
                    <Nav.Link as={NavLink} to="/formulario_producto" className={({isActive})=>isActive ? "":"text-white"}>
                        Formulario de productos
                    </Nav.Link>
                    <Nav.Link as={NavLink} onclick={e=>logout(e)} className={"text-danger"}>
                        Logout <BoxArrowRight/>
                    </Nav.Link>
                </Nav>
                }                
                <hr/>
            </Container>
        </Navbar>
    </>
  )
}