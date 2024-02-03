import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Image from 'react-bootstrap/Image';

export default function Footer() {
  return (
    <Container fluid className='mt-4 footer-logo'>
        <hr/>
        <Row>
            <Col className="text-center pt-3 pb-4">
                <Image src="/AYI_LogoProp.png" alt="Logo" width={100} />
            </Col>
        </Row>
    </Container>
  )
}
