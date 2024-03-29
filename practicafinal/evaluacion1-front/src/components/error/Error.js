import React from 'react';
import { Link } from 'react-router-dom';
import { ArrowLeft } from 'react-bootstrap-icons';
import Container from 'react-bootstrap/Container';
import { useAuth } from '../../contexts/AuthContext';

export default function Error() {

    const { user } = useAuth();

    return (
        <Container className="p-3">
            <h1>Error:</h1>
            <p>Algo salió mal..</p>
            <Link to={!user ? "/" : "/index"} className="btn btn-outline-secondary"><ArrowLeft /> Volver</Link>
        </Container>
    )
}
