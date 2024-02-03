import React from 'react';
import { useAuth } from '../../contexts/AuthContext';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { ApiService } from '../../service/ApiService';
import { Link, useNavigate } from 'react-router-dom';
import { Container } from 'react-bootstrap';


export default function Login() {

    const { user, loginUser, logoutUser } = useAuth();

    let navigate = useNavigate();

    function login(e) {
        e.preventDefault();
        let username = e.target.username.value;
        ApiService.login({
            username: username,
            password: e.target.password.value,
        }).then((response) => {
            loginUser(username, response.data.token);
            navigate("/index");
        }).catch((error) => {
            console.log("Error: " + error);
            navigate("/error");
        });
    }

    return (
        !user ?
            <Container>
                <Form onSubmit={e => { login(e) }}>
                    <Form.Group className="mb-3" controlId="username">
                        <Form.Label>Usuario</Form.Label>
                        <Form.Control type="text" name="username" placeholder="Usuario" />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="password">
                        <Form.Label>Contraseña</Form.Label>
                        <Form.Control type="password" name="password" placeholder="Contraseña" />
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
            :
            <Container>
                <h3>Ya estás autenticado como: {user}</h3>
                <p>¿No sos vos? <Link onClick={logoutUser} to={"/"}>Haz click aquí para cerrar sesión.</Link></p>
                <Link to={"/index"}>Volver</Link>
            </Container>
    )
}
