import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import { Button } from 'react-bootstrap';
import { Plus } from 'react-bootstrap-icons';
import { Link } from 'react-router-dom';
import TableEmpleados from '../table_empleados/TableEmpleados';

export default function Main() {

    return (
        <Container className="mt-3">
            <TableEmpleados titulo={"Empleados"} className="mb-5" />
            <hr />
            <Row>
                <Link to="/formulario_empleado"><Button variant="success"><Plus /> Agregar</Button></Link>
            </Row>
        </Container>
    )
}
