import React from 'react';
import { Empleado } from './../../service/EmpleadoModel';
import { ApiService } from '../../service/ApiService';
import { useNavigate } from 'react-router-dom';
import { Button, Container, Form, Row } from 'react-bootstrap';

export default function FormEmpleado() {

    const[empleado, setEmpleado] = useState(new Empleado());

    const navigate = useNavigate()

    const { id } = useParams();

    if(id != null){
        ApiService.one(id)
        .then((response)=>{
            setEmpleado(response);
        }).catch((error)=>{
            console.log("Error: "+error);
            navigate("/index");
        })
    }

    function submit(){
        if(id != null){
            ApiService.update(id)
            .then((response)=>{
                setEmpleado(response);
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/index");
            })
        } else {
            ApiService.create()
            .then((response)=>{
                setEmpleado(response);
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/index");
            })
        }
    }

  return (
    <Container>
        <Row>
            {id?<h2>Modificar empleado</h2>:<h2>Agregar empleado</h2>}
            <Form>
            {id &&  
                <Form.Group className="mb-3" controlId="id">
                    <Form.Label>Legajo</Form.Label>
                    <Form.Control type="number" value={empleado.id} name="id" disabled readOnly/>
                </Form.Group>
            }
            <Form.Group className="mb-3" controlId="nombre">
                <Form.Label>Nombre</Form.Label>
                <Form.Control type="text" value={empleado.nombre} name="nombre" placeholder="Carlos" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="apellido">
                <Form.Label>Example textarea</Form.Label>
                <Form.Control type="text" value={empleado.apellido} name="apellido" placeholder="Perez"/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="cargo">
                <Form.Label>Nombre</Form.Label>
                <Form.Control type="text" value={empleado.cargo} name="cargo" placeholder="Carlos" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="sucursal">
                <Form.Label>Example textarea</Form.Label>
                <Form.Control type="text" value={empleado.sucursal} name="sucursal" placeholder="Perez"/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="antiguedad">
                <Form.Label>Legajo</Form.Label>
                <Form.Control type="number" value={empleado.antiguedad} name="antiguedad" min={0}/>
            </Form.Group>
            <Button></Button>
            </Form>
        </Row>
    </Container>
  )
}
