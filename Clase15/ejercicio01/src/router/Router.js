import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { NavLink } from 'react-router-dom';
import { Inicio } from '../components/Inicio';
import { Ej01 } from '../components/Ej01';
import { Ej02 } from '../components/Ej02';
import { Ej03 } from '../components/Ej03';
import { Ej04 } from '../components/Ej04';

export default function Router() {
    return (
        <>
            <BrowserRouter>
                <Navbar bg="dark" data-bs-theme="dark">
                    <Container>
                        <Navbar>
                            <Nav.Link as={NavLink} to="/" className={({isActive})=>isActive ? "":"text-white"}>                                
                                Inicio
                            </Nav.Link>
                        </Navbar>
                        <Nav className="me-auto">
                            <Nav.Link as={NavLink} to="/ej01">
                                Ej01
                            </Nav.Link>
                            <Nav.Link as={NavLink} to="/ej02">Ej02</Nav.Link>
                            <Nav.Link as={NavLink} to="/ej03">Ej03</Nav.Link>
                            <Nav.Link as={NavLink} to="/ej04">Ej04</Nav.Link>
                        </Nav>
                    </Container>
                </Navbar>
                <section>
                    <Routes>
                        <Route path="/" element={<Inicio />} />
                        <Route path="/ej01" element={<Ej01 />} />
                        <Route path="/ej02" element={<Ej02 />} />
                        <Route path="/ej03" element={<Ej03 />} />
                        <Route path="/ej04" element={<Ej04 />} />
                        <Route path="*" element={<Inicio />} />
                    </Routes>
                </section>
            </BrowserRouter>
        </>
    )
}
