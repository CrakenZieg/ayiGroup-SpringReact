import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Nav from './Nav';

export default function Header(props) {
    return (
        <>
        <header className="App-header">     
            <Nav titulo={props.titulo}/>
            <Container>
                <Row>
                    <Col></Col>
                    <Col>
                        <h1>{props.titulo}</h1>
                        <p>{props.subtitulo}</p>
                    </Col>
                    <Col></Col>
                </Row>
            </Container>
        </header>
        </>
    )
}
