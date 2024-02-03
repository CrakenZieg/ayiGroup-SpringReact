import React, { useState, useEffect } from 'react';
import Row from 'react-bootstrap/Row';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { Plus, PencilSquare, Trash } from 'react-bootstrap-icons';
import { ApiClientesService } from '../../service/ApiClientesService';
import { useNavigate, Link } from 'react-router-dom';

export default function TableClientes({titulo}) {

    const [data, setData] = useState([]);

    let navigate = useNavigate();

    useEffect(() => {
        ApiClientesService.all(localStorage.getItem("token"))
            .then((response) => {
                setData(response.data);
            }).catch((error) => {
                console.log("Error: " + error);
                navigate('/error');
            })
    }, [])

    function eliminar(id) {
        ApiClientesService.delete(id,localStorage.getItem("token"))
            .then(() => {
                setData(data.filter((cliente)=>{return cliente.id!==id;}))
            }).catch((error) => {
                console.log("Error: " + error);
                navigate("/error");
            });
    }

    const dataEntries = data.map((cliente) => {
        return (<tr key={cliente.id}>
            <td>{cliente.id}</td>
            <td>{cliente.apellido}, {cliente.nombre}</td>
            <td>{cliente.ingreso}</td>
            <td>{cliente.domicilio}</td>
            <td>{cliente.telefono}</td>
            <td>
                <Button variant="warning" onClick={() => { navigate(`/formulario_cliente/${cliente.id}`) }} ><PencilSquare /></Button>
            </td>
            <td>
                <Button variant="danger" onClick={() => { eliminar(cliente.id); }} ><Trash /></Button>
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
                                <th>Nombre</th>
                                <th>Ingreso</th>
                                <th>Domicilio</th>
                                <th>Telefono</th>                                
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
            <Row className="mb-3">
                <Link to="/formulario_cliente"><Button variant="success"><Plus/> Agregar cliente</Button></Link>
            </Row>
        </>
  )
}