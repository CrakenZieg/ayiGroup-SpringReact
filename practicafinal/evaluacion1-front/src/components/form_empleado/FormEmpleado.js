import React, { useEffect, useState } from 'react';
import { ApiService } from '../../service/ApiService';
import { useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, Row } from 'react-bootstrap';

export default function FormEmpleado() {

    const [empleado, setEmpleado] = useState({});

    const navigate = useNavigate()

    const { id } = useParams();

    useEffect(() => {
        if(id != null){
            ApiService.one(id,localStorage.getItem("token"))
            .then((response)=>{
                setEmpleado(response.data);
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/index");
            })
        } else {
            setEmpleado({
                nombre: "",
                apellido:"",
                cargo:"",
                sucursal:"",
                antiguedad:0
            })
        }        
    },[])

    function submit(e){
        e.preventDefault(); 
        setEmpleado({        
            nombre: e.target.nombre.value,
            apellido: e.target.apellido.value,
            cargo: e.target.cargo.value,
            sucursal: e.target.sucursal.value,
            antiguedad: e.target.antiguedad.value                
        })       
        if(id != null){
            setEmpleado({      
                    id: id,          
                    ...empleado
            })
            ApiService.update(empleado,localStorage.getItem("token"))
            .then(()=>{
                navigate("/index");
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/error");
            })
        } else {            
            ApiService.create(empleado,localStorage.getItem("token"))
            .then(()=>{
                navigate("/index");
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/error");
            })
        }
    }

  return (
    <Container>
        <Row>
            {id?<h2>Modificar empleado</h2>:<h2>Agregar empleado</h2>}
            <Form onSubmit={e => { submit(e) }}>
            {id &&  
                <Form.Group className="mb-3" controlId="id">
                    <Form.Label>Legajo</Form.Label>
                    <Form.Control type="number" value={id} name="id" disabled readOnly/>
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
            <Button variant="success" type="submit">
                Enviar
            </Button>
            </Form>
        </Row>
    </Container>
  )
}
