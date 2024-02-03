import React, { useEffect, useState } from 'react';
import { ApiClientesService } from '../../service/ApiClientesService';
import { useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, Row } from 'react-bootstrap';

export default function FormCliente() {

    const clienteInit = {
        nombre:"",
        apellido:"",
        ingreso: "",
        domicilio:"",
        telefono:""
    };

    const [cliente, setCliente] = useState({});

    const navigate = useNavigate()

    const { id } = useParams();

    useEffect(() => {
        if(id != null){
            ApiClientesService.one(id,localStorage.getItem("token"))
            .then((response)=>{
                setCliente(response.data);
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/index");
            })
        } else {
            setCliente(clienteInit);
        }     
    },[])

    function submit(e){
        e.preventDefault();              
        if(id != null){
            setCliente({      
                    id: id,          
                    ...cliente
            })
            ApiClientesService.update(cliente,localStorage.getItem("token"))
            .then(()=>{
                navigate("/index");
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/error");
            })
        } else {            
            ApiClientesService.create(cliente,localStorage.getItem("token"))
            .then(()=>{
                navigate("/index");
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/error");
            })
        }
    }

    function formChange(e){
        const {name,value} = e.target;
        setCliente({
            ...cliente,
            [name]: value
        });
    }

  return (
    <Container className="mt-3">
        <Row>
            {id?<h2>Modificar cliente</h2>:<h2>Agregar cliente</h2>}
            <Form onSubmit={e => { submit(e) }} className="mt-3">
            {id &&  
                <Form.Group className="mb-3" controlId="id">
                    <Form.Label>Id</Form.Label>
                    <Form.Control type="number" value={id} name="id" disabled readOnly/>
                </Form.Group>
            }
            <Form.Group className="mb-3" controlId="nombre">
                <Form.Label>Nombre</Form.Label>
                <Form.Control type="text" value={cliente.nombre} name="nombre" onChange={(e)=>formChange(e)} maxLength={25} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="apellido">
                <Form.Label>Apellido</Form.Label>
                <Form.Control type="text" value={cliente.apellido} name="apellido" onChange={(e)=>formChange(e)} maxLength={25} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="domicilio">
                <Form.Label>Domicilio</Form.Label>
                <Form.Control type="text" value={cliente.domicilio} name="domicilio" onChange={(e)=>formChange(e)} maxLength={25} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="telefono">
                <Form.Label>Teléfono</Form.Label>
                <Form.Control type="tel" value={cliente.telefono} name="telefono" onChange={(e)=>formChange(e)} maxLength={15} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="ingreso">
                <Form.Label>Ingreso</Form.Label>
                <Form.Control type="date" value={cliente.ingreso} name="ingreso" onChange={(e)=>formChange(e)} required/>
            </Form.Group>
            <Button variant="success" type="submit">
                Enviar
            </Button>
            </Form>
        </Row>
    </Container>
  )
}
