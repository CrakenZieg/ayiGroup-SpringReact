import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { NavLink } from 'react-router-dom';
import WithFetch from '../components/withfetch/WithFetch';
import WithAxios from '../components/withaxios/WithAxios';
import Main from '../components/main/Main';

export default function Router() {
    return (
        <>
            <BrowserRouter>
                <Navbar bg="dark" data-bs-theme="dark">
                    <Container>
                        <Nav className="me-auto" >
                            <Nav.Link as={NavLink} to="/" className={({isActive})=>isActive ? "":"text-white"}>
                                Inicio
                            </Nav.Link>
                            <Nav.Link as={NavLink} to="/fetch" className={({isActive})=>isActive ? "":"text-white"}>
                                Fetch
                            </Nav.Link>
                            <Nav.Link as={NavLink} to="/axios" className={({isActive})=>isActive ? "":"text-white"}>
                                Axios
                            </Nav.Link>
                        </Nav>
                    </Container>
                </Navbar>
                <section>
                    <Routes>
                        <Route path="/" element={<Main />} />
                        <Route path="/fetch" element={<WithFetch />} />
                        <Route path="/axios" element={<WithAxios />} />
                        <Route path="*" element={<Main />} />
                    </Routes>
                </section>
            </BrowserRouter>
        </>
    )
}
