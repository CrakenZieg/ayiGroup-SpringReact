import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import { Button } from 'react-bootstrap';
import { Plus } from 'react-bootstrap-icons';
import { Link } from 'react-router-dom';
import TableEmpleados from '../table_empleados/TableEmpleados';

export default function Main() {

  return (
    <Container>
            <TableEmpleados titulo={"Empleados"}/>
        <hr/>
        <Row>
            <Button variant="success"><Link to="/formulario_empleado"><Plus/> Agregar</Link></Button>
        </Row>
    </Container>
  )
}
