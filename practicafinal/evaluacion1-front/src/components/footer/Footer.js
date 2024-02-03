import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';


export default function Footer() {
  return (
    <Container fluid>
        <hr/>
        <Row>
            <Col className="text-center py-3">
                Footer
            </Col>
        </Row>
    </Container>
  )
}
