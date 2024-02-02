import React from 'react';
import { useAuth } from '../../contexts/AuthContext';

export default function Login() {

    const { user, loginUser, logoutUser } = useAuth();

  return (
    <div>Login</div>
  )
}
