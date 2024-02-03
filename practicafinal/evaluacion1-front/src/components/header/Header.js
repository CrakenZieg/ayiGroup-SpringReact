import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Image from 'react-bootstrap/Image';
import { NavLink, useNavigate } from 'react-router-dom';
import { useAuth } from '../../contexts/AuthContext';
import { BoxArrowRight } from 'react-bootstrap-icons';

export default function Header() {

    const { user, logoutUser } = useAuth();

    let navigate = useNavigate();

    function logout(e) {
        e.preventDefault();
        logoutUser();
        navigate("/");
    }

    return (
        <>
            <Navbar bg="dark" data-bs-theme="dark" className='position-sticky'>
                <Container>
                    <Row className="d-flex w-100 justify-content-between">
                        <Navbar.Brand className='w-25'>
                            <Image src="/AYI_LogoProp.png" alt="Logo" width={150} />
                        </Navbar.Brand>
                        {
                            user !== "" &&
                            <Nav className="w-auto d-flex align-items-end">                                
                                <Nav.Link as={NavLink} to="/index" className={({ isActive }) => isActive ? "" : "text-white"}>
                                    Inicio
                                </Nav.Link>
                                <Nav.Link as={NavLink} to="/index#empleados" className={({ isActive }) => isActive ? "" : "text-white"}>
                                    Tabla de empleados
                                </Nav.Link>
                                <Nav.Link as={NavLink} to="/formulario_empleado" className={({ isActive }) => isActive ? "" : "text-white"}>
                                    Formulario de empleados
                                </Nav.Link>
                                <Nav.Link onClick={e => logout(e)} className={"text-danger"}>
                                    Logout <BoxArrowRight />
                                </Nav.Link>
                            </Nav>                                
                        }
                    </Row>
                </Container>
            </Navbar>
        </>
    )
}
