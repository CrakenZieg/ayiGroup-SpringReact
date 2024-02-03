import React from 'react';
import TableProductos  from '../table_productos/TableProductos';
import TableClientes  from '../table_clientes/TableClientes';

export default function Main() {
  return (
    <>
        <div>Main</div>
        <hr/>
        <TableProductos/>
        <hr/>
        <TableClientes/>
    </>
  )
}
