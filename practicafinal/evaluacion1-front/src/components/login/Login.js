import React from 'react';
import { useAuth } from '../../contexts/AuthContext';
import { ApiService } from '../../service/ApiService';
import { Link, useNavigate } from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';


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
        (!user) ?
            (<Container>
                <Row>
                    <Col className="d-flex justify-content-md-center">
                        <Card className="mt-3 w-50">
                            <Card.Body>
                                <h2>Login</h2>
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
                                        Enviar
                                    </Button>
                                </Form>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container>)
            :
            (<Container>
                <Row>
                    <Col className="d-flex justify-content-md-center">
                        <Card className="mt-3 w-50">
                            <Card.Body>
                                <h3>Ya estás autenticado como: {user}</h3>
                                <p>¿No sos vos? <Link onClick={logoutUser} to={"/"}>Haz click aquí para cerrar sesión.</Link></p>
                                <Link to={"/index"}>Volver</Link>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container>)
    )
}
