import React, { useState, useEffect } from 'react';
import Row from 'react-bootstrap/Row';
import Table from 'react-bootstrap/Table';
import { ApiService } from '../../service/ApiService';
import { useNavigate } from 'react-router-dom';
import { Button } from 'react-bootstrap';
import { PencilSquare, Trash } from 'react-bootstrap-icons';


export default function TableEmpleados({titulo}) {

    const [data, setData] = useState([]);

    let navigate = useNavigate();

    useEffect(() => {
        ApiService.all(localStorage.getItem("token"))
            .then((response) => {
                setData(response.data);
            }).catch((error) => {
                console.log("Error: " + error);
                navigate('/error');
            })
    }, [])

    function eliminar(id) {
        ApiService.delete(id,localStorage.getItem("token"))
            .then(() => {
                setData(data.filter((empleado)=>{return empleado.id!==id;}))
            }).catch((error) => {
                console.log("Error: " + error);
                navigate("/error");
            });
    }

    const dataEntries = data.map((empleado) => {
        return (<tr key={empleado.id}>
            <td>{empleado.id}</td>
            <td>{empleado.apellido}, {empleado.nombre}</td>
            <td>{empleado.cargo}</td>
            <td>{empleado.sucursal}</td>
            <td>{empleado.antiguedad}</td>
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
                    <Table striped bordered hover id="empleados">
                        <thead>
                            <tr>
                                <th>Legajo</th>
                                <th>Nombre</th>
                                <th>Cargo</th>
                                <th>Sucursal</th>
                                <th>Antigüedad</th>
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
                    <h2>{titulo}</h2>
                    <h3>Sin datos que mostrar</h3>
                </Row>
            }
        </>
    )
}
