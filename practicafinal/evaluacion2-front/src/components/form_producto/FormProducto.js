import React, { useEffect, useState } from 'react';
import { ApiProductosService } from '../../service/ApiProductosService';
import { productoWithEanArray, eanLastNumber, productoWithEanString } from '../../service/util/ProductosFormUtils'
import { useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, Row, Col } from 'react-bootstrap';

export default function FormProducto() {

    const productoInit = {
        ean: [],
        nombre:"",
        descripcion:"",
        tipo:"",
        marca:"",
        precio:0,
        stock:0
    };

    const [producto, setProducto] = useState({});
    const [ean, setEan] = useState([0,0,0,0,0,0,0,0,0,0,0,0,0]);

    const navigate = useNavigate()

    const { id } = useParams();

    useEffect(() => {
        if(id != null){
            ApiProductosService.one(id,localStorage.getItem("token"))
            .then((response)=>{
                setProducto(productoWithEanArray(response.data));
                setEan(response.data.ean.split("").map((e)=>{return Number.parseInt(e)}))
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
            ApiProductosService.update(productoWithEanString(producto),localStorage.getItem("token"))
            .then(()=>{
                navigate("/index");
            }).catch((error)=>{
                console.log("Error: "+error);
                navigate("/error");
            })
        } else {            
            ApiProductosService.create(productoWithEanString(producto),localStorage.getItem("token"))
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

    function formEanChange(e,index){
        console.log(ean);
        let mod = ean.slice();
        mod.splice(index,1,Number.parseInt(e.target.value))
        mod.splice(mod.length-1,1,eanLastNumber(mod))
        console.log(mod)
        setEan(mod)        
        setProducto({
            ...producto,
            ean: ean
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
                <Form.Label>Ean-13</Form.Label>
                <Row className='d-flex flex-row'>
                    <Col>
                        <Form.Control type="number" value={ean[0]} name="ean[0]" min={0} max={9} onChange={(e)=>formEanChange(e,0)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[1]} name="ean[1]" min={0} max={9} onChange={(e)=>formEanChange(e,1)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[2]} name="ean[2]" min={0} max={9} onChange={(e)=>formEanChange(e,2)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[3]} name="ean[3]" min={0} max={9} onChange={(e)=>formEanChange(e,3)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[4]} name="ean[4]" min={0} max={9} onChange={(e)=>formEanChange(e,4)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[5]} name="ean[5]" min={0} max={9} onChange={(e)=>formEanChange(e,5)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[6]} name="ean[6]" min={0} max={9} onChange={(e)=>formEanChange(e,6)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[7]} name="ean[7]" min={0} max={9} onChange={(e)=>formEanChange(e,7)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[8]} name="ean[8]" min={0} max={9} onChange={(e)=>formEanChange(e,8)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[9]} name="ean[9]" min={0} max={9} onChange={(e)=>formEanChange(e,9)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[10]} name="ean[10]" min={0} max={9} onChange={(e)=>formEanChange(e,10)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[11]} name="ean[11]" min={0} max={9} onChange={(e)=>formEanChange(e,11)} required/>
                    </Col>
                    <Col>
                        <Form.Control type="number" value={ean[12]} name="ean[12]" disabled/>
                    </Col>
                </Row>
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
