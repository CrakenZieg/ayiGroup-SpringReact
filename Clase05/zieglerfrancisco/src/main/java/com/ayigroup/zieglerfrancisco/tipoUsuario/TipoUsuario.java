
package com.ayigroup.zieglerfrancisco.tipoUsuario;

public class TipoUsuario {
    
    private int idTipoUsuario;
    private String descripcion;

    public TipoUsuario() {
    }

    public TipoUsuario(int idTipoUsuario, String descripcion) {
        this.idTipoUsuario = idTipoUsuario;
        this.descripcion = descripcion;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipoUsuario{");
        sb.append("idTipoUsuario=").append(idTipoUsuario);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }    
    
}
