import React, { useEffect, useState } from 'react';
import Service from '../service/APIService';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Image from 'react-bootstrap/Image';

export default function Main() {

    const [trago, setTrago] = useState({});

    useEffect(
        () => {
            Service.getTrago()
                .then((response) => { setTrago(response.drinks[0]); })
        }, []);

    return (
        <>
        <Container>
            <Row>
                <Col></Col>
                <Col>
                    <Image src={trago.strDrinkThumb} alt="" />
                </Col>
                <Col>
                    <h1>{trago.strDrink}</h1>
                    <p>{(trago.strInstructionsES != null) ? trago.strInstructionsES : trago.strInstructions}</p>
                </Col>
                <Col></Col>
            </Row>
        </Container>
        </>
    )
}
