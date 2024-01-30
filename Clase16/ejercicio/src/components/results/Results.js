import React from 'react';
import { Link } from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

export default function Results({idMeal,strMeal,strArea,strMealThumb,strInstructions,strSource}) {

  return (
    <div>
        <h4>Id: {idMeal}</h4>
        <h1>{strMeal}</h1>
        <small>{strArea} cuisine</small>
        <Container>
            <Row>
                <Col>
                    <img src={strMealThumb} alt={`Foto de ${strMeal}`}/>
                </Col>
                <Col>
                    <p>
                        {strInstructions}
                    </p>
                    <br></br>
                    <Link to={strSource}>Link externo a la receta</Link>
                </Col>
            </Row>
        </Container>
    </div>
  )
}
