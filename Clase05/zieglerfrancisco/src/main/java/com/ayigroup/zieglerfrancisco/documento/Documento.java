
package com.ayigroup.zieglerfrancisco.documento;

public class Documento {
    
    private int numeroDocumento;
    private String descripcion;

    public Documento() {
    }

    public Documento(int numeroDocumento, String descripcion) {
        this.numeroDocumento = numeroDocumento;
        this.descripcion = descripcion;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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
        sb.append("Documento{");
        sb.append("numeroDocumento=").append(numeroDocumento);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }
    
}
