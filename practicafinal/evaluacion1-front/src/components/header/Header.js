import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { NavLink, useNavigate } from 'react-router-dom';
import { useAuth } from '../../contexts/AuthContext';
import { BoxArrowRight } from 'react-bootstrap-icons';

export default function Header() {

    const { user, logoutUser } = useAuth();
    
    let navigate = useNavigate();

    function logout(e){
        e.preventDefault();
        logoutUser();
        navigate("/");
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
                    <Nav.Link onClick={e=>logout(e)} className={"text-danger"}>
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
