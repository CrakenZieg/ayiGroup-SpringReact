
export function clienteWithIngresoString(cliente){
    const clienteWithString = {}
    if(cliente.id!==""){
        clienteWithString.id = cliente.id
    }
    clienteWithString.nombre = cliente.nombre;
    clienteWithString.apellido = cliente.apellido;
    clienteWithString.ingreso = `${cliente.ingreso.getUTCFullYear()}-${cliente.ingreso.getUTCMonth()+1}-${cliente.ingreso.getUTCDate()}`;
    clienteWithString.domicilio = cliente.domicilio;
    clienteWithString.telefono = cliente.telefono;
    return clienteWithString;
}