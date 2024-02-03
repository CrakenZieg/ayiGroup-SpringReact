import React from 'react';
import { ArrowLeft } from 'react-bootstrap-icons';
import { Link } from 'react-router-dom';
import { useAuth } from '../../contexts/AuthContext';
import Container from 'react-bootstrap/Container';

export default function Error() {

    const { user } = useAuth();

  return (
    <Container>
        <h1>Error:</h1>
        <p>Algo salió mal..</p>
        <Link to={!user?"/":"/index"}><ArrowLeft/> Volver</Link>    
    </Container>
  )
}
