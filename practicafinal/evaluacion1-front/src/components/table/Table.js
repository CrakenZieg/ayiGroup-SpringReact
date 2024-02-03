import React, { useState } from 'react';
import Row from 'react-bootstrap/Row';
import Table from 'react-bootstrap/Table';
import { ApiService } from '../../service/ApiService';
import { useNavigate } from 'react-router-dom';
import { Button } from 'react-bootstrap';
import { PencilSquare, Trash } from 'react-bootstrap-icons';


export default function Table(titulo) {

    const [data, setData] = useState(null);
    let navigate = useNavigate();

    useEffect(() => {
        ApiService.all()
            .then((response) => {
                setData(response.data);
            }).catch((error) => {
                console.log("Error: " + error);
                navigate('/error');
            })
    }, [])

    function eliminar(id) {
        ApiService.delete(id)
            .then(() => {
                navigate("/");
            }).catch((error) => {
                console.log("Error: " + error);
                navigate("/error");
            });
    }

    const dataEntries = data.map((empleado) => {
        <tr key={empleado.id}>
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
        </tr>
    });

    return (
        <>
            <Row>
                <h2>{titulo}</h2>
                <hr />
            </Row>
            {data.length == 0 ?
                <Row>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>Legajo</th>
                                <th>Nombre</th>
                                <th>Cargo</th>
                                <th>Sucursal</th>
                                <th>Antigüedad</th>
                                <th>Acciones</th>
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
