import React from 'react';
import Container from 'react-bootstrap/Container';
import TableProductos  from '../table_productos/TableProductos';
import TableClientes  from '../table_clientes/TableClientes';

export default function Main() {
  return (
    <Container className="mt-3">       
        <TableProductos titulo={"Productos"}/>
        <TableClientes titulo={"Clientes"}/>
    </Container>
  )
}
