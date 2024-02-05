import React, { useEffect, useState } from 'react';
import { ApiProductosService } from '../../service/ApiProductosService';
import { useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, Row } from 'react-bootstrap';

export default function FormProducto() {

    const productoInit = {
        ean: "",
        nombre:"",
        descripcion:"",
        tipo:"",
        marca:"",
        precio:0,
        stock:0
    };

    const [producto, setProducto] = useState({});

    const navigate = useNavigate()

    const { id } = useParams();

    useEffect(() => {
        if(id != null){
            ApiProductosService.one(id,localStorage.getItem("token"))
            .then((response)=>{
                setProducto(response.data);                               
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/index");
            })
        } else {
            setProducto(productoInit);
        }           
    },[])
    
    function submit(e){
        e.preventDefault();              
        if(id != null){
            setProducto({      
                    id: id,          
                    ...producto
            })
            ApiProductosService.update(producto,localStorage.getItem("token"))
            .then(()=>{
                navigate("/index");
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/error");
            })
        } else {            
            ApiProductosService.create(producto,localStorage.getItem("token"))
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
        setProducto({
            ...producto,
            [name]: value
        });
    }

  return (
    <Container className="mt-3">
        <Row>
            {id?<h2>Modificar producto</h2>:<h2>Agregar producto</h2>}
            <Form onSubmit={e => { submit(e) }} className="mt-3">
            {id &&  
                <Form.Group className="mb-3" controlId="id">
                    <Form.Label>id</Form.Label>
                    <Form.Control type="number" value={id} name="id" disabled readOnly/>
                </Form.Group>
            }
            <Form.Group className="mb-3" controlId="ean">
                <Form.Label>Código EAN</Form.Label>
                <Form.Control type="text" value={producto.ean} name="ean" onChange={(e)=>formChange(e)} maxLength={25} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="nombre">
                <Form.Label>Nombre</Form.Label>
                <Form.Control type="text" value={producto.nombre} name="nombre" onChange={(e)=>formChange(e)} maxLength={25} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="descripcion">
                <Form.Label>Descripción</Form.Label>
                <Form.Control as="textarea" rows={3} value={producto.descripcion} name="descripcion" onChange={(e)=>formChange(e)} maxLength={100} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="tipo">
                <Form.Label>Tipo</Form.Label>
                <Form.Control type="text" value={producto.tipo} name="tipo" onChange={(e)=>formChange(e)} maxLength={15} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="marca">
                <Form.Label>Marca</Form.Label>
                <Form.Control type="text" value={producto.marca} name="marca" onChange={(e)=>formChange(e)} maxLength={20}  required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="precio">
                <Form.Label>Precio</Form.Label>
                <Form.Control type="number" value={producto.precio} name="precio" min={0} max={999} onChange={(e)=>formChange(e)} required/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="stock">
                <Form.Label>Stock</Form.Label>
                <Form.Control type="number" value={producto.stock} name="stock" min={0} onChange={(e)=>formChange(e)} required/>
            </Form.Group>
            <Button variant="success" type="submit">
                Enviar
            </Button>
            </Form>
        </Row>
    </Container>
  )
}
