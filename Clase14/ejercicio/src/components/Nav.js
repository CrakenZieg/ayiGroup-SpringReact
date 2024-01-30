import React from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';

export default function Nav(props) {
    return (
        <>
        <Navbar className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">
                    <Image
                        alt=""
                        src="../logo.svg"
                        width="30"
                        height="30"
                        className="d-inline-block align-top"
                    />
                    {props.titulo}
                </Navbar.Brand>
            </Container>
        </Navbar>
        </>
    )
}
