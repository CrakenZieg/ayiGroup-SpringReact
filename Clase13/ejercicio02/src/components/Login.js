import React from 'react'

export default function Login() {
  return (
    <div>
      <h1>Login</h1>
      <form>
        <input type="text" name="username" id="usermane"/>
        <br/>
        <input type="password" name="password" id="password"/>
        <br/>
        <input type="submit" value="Enviar"/>
      </form>
    </div>
  )
}
