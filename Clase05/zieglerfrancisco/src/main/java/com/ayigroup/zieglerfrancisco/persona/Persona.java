
package com.ayigroup.zieglerfrancisco.persona;

import com.ayigroup.zieglerfrancisco.documento.Documento;

public class Persona {
    
    private int idPersona;
    private String nombre;
    private String apellido;
    private Documento documento;

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apellido, Documento documento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("idPersona=").append(idPersona);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", documento=").append(documento);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
