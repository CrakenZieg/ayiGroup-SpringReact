import React from 'react';
import { useAuth } from '../../contexts/AuthContext';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import ApiService from '../../service/ApiService';
import { redirect } from 'react-router-dom';


export default function Login() {

    const { user, loginUser, logoutUser } = useAuth();

    function login(e){
        e.preventDefault();
        let response = ApiService.login({
            username: e.target.username.value,
            password: e.target.password.value,
        })
        if(response.substring(0) === "E") {
            redirect("/error", {state:{message:response}});
        } else {
            loginUser();
            redirect("/index");
        }
    }

  return (    
        user!==""?
        <>
            <h3>Ya estás autenticado como: {user}</h3>
            <p>¿No sos vos? <a>Haz click aquí para cerrar sesión.</a></p>
            <Link onclick={logoutUser} to={"/"}>Link externo a la receta</Link>
            <Link to={"/index"}>Volver</Link>
        </>
        :
        <>
            <Form onSubmit={e=>{login(e)}}>
                <Form.Group className="mb-3" controlId="username">
                    <Form.Label>Usuario</Form.Label>
                    <Form.Control type="text" name="username" placeholder="Usuario" />                    
                </Form.Group>

                <Form.Group className="mb-3" controlId="password">
                    <Form.Label>Contraseña</Form.Label>
                    <Form.Control type="password" name="password" placeholder="Contraseña" />
                </Form.Group>
                <Button  variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </>
    
  )
}
