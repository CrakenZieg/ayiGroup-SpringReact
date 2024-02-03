import React, { useState, useEffect } from 'react';
import Row from 'react-bootstrap/Row';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { Plus, PencilSquare, Trash } from 'react-bootstrap-icons';
import { ApiProductosService } from '../../service/ApiProductosService';
import { useNavigate, Link } from 'react-router-dom';

export default function TableProductos() {

    const [data, setData] = useState([]);

    let navigate = useNavigate();

    useEffect(() => {
        ApiProductosService.all(localStorage.getItem("token"))
            .then((response) => {
                setData(response.data);
            }).catch((error) => {
                console.log("Error: " + error);
                navigate('/error');
            })
    }, [])

    function eliminar(id) {
        ApiProductosService.delete(id,localStorage.getItem("token"))
            .then(() => {
                setData(data.filter((producto)=>{return producto.id!==id;}))
            }).catch((error) => {
                console.log("Error: " + error);
                navigate("/error");
            });
    }

    const dataEntries = data.map((producto) => {
        return (<tr key={producto.id}>
            <td>{producto.id}</td>
            <td>{producto.ean}</td>
            <td>{producto.nombre}</td>
            <td>{producto.descripcion}</td>
            <td>{producto.tipo}</td>
            <td>{producto.marca}</td>
            <td>{producto.precio}</td>
            <td>{producto.stock}</td>
            <td>
                <Button variant="warning" onClick={() => { navigate(`/formulario_empleado/${empleado.id}`) }} ><PencilSquare /></Button>
            </td>
            <td>
                <Button variant="danger" onClick={() => { eliminar(empleado.id); }} ><Trash /></Button>
            </td>
        </tr>)
    });

  return (
    <>
            <Row>
                <h2>{titulo}</h2>
                <hr />
            </Row>
            {data.length !== 0 ?
                <Row>
                    <Table striped bordered hover id="productos">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Código EAN</th>
                                <th>Nombre</th>
                                <th>Descripción</th>
                                <th>Tipo</th>
                                <th>Marca</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            {dataEntries}
                        </tbody>
                    </Table>
                </Row>
                :
                <Row>
                    <h3>Sin datos que mostrar</h3>
                </Row>
            }
            <Row className="mt-5">
                <Link to="/formulario_producto"><Button variant="success"><Plus/> Agregar producto</Button></Link>
            </Row>
        </>
  )
}