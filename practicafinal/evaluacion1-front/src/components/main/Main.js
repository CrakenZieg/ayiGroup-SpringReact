import React from 'react';
import Table from '../table/Table';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import { Button } from 'react-bootstrap';
import { Plus } from 'react-bootstrap-icons';

export default function Main() {

  return (
    <Container>
            <Table titulo="Empleados"/>
        <hr/>
        <Row>
            <Button variant="success"><Link to="/formulario_empleado"><Plus/> Agregar</Link></Button>
        </Row>
    </Container>
  )
}
