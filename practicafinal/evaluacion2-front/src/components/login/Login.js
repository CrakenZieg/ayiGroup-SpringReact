import React from 'react';
import { useAuth } from '../../contexts/AuthContext';

export default function Login() {

    const { user, loginUser, logoutUser } = useAuth();

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
            
        </>
    
  )
}
