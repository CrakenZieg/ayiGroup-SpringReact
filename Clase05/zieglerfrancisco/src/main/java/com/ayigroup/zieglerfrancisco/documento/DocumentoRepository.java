
package com.ayigroup.zieglerfrancisco.documento;

import com.ayigroup.zieglerfrancisco.utils.Connections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentoRepository{
    
    private Connections connections;
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM documento";
    private static final String SQL_SELECT_ONE = "SELECT * FROM documento WHERE numero_documento = ?";
    private static final String SQL_INSERT = "INSERT INTO documento(numero_documento, descripcion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE documento SET descripcion = ? WHERE numero_documento = ?";
    private static final String SQL_DELETE = "DELETE FROM documento WHERE numero_documento = ?";

    public DocumentoRepository(Connections connections) {
        this.connections = connections;
    }

    public List<Documento> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Documento> documentos = new ArrayList<>();
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);   
            rs = stmt.executeQuery();                   
            while (rs.next()){                          
                int numeroDocumento = rs.getInt("numero_documento");
                String descripcion = rs.getString("descripcion");
                documentos.add(new Documento(numeroDocumento,descripcion));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                if (rs != null){
                    connections.close(rs);}
                if (stmt != null){
                    connections.close(stmt);}
                if (conn != null){
                    connections.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        return documentos;
    }

    public Documento getOne(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Documento documento = null;
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE);   
            stmt.setInt(1, id);
            rs = stmt.executeQuery();                   
            if(rs.next()){
                documento =  new Documento(
                        rs.getInt("numero_documento"),
                        rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                if (rs != null){
                    connections.close(rs);}
                if (stmt != null){
                    connections.close(stmt);}
                if (conn != null){
                    connections.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        return documento;
    }

    public Documento create(Documento newEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Documento documento = getOne(newEntity.getNumeroDocumento());
        
        try {
            if(documento!=null){
                return documento;
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, newEntity.getNumeroDocumento());
            stmt.setString(2, newEntity.getDescripcion());
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                if (stmt != null){
                    connections.close(stmt);}
                if (conn != null){
                    connections.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        documento = getOne(newEntity.getNumeroDocumento());
        return documento;
    }
    
    public Documento update(Documento upEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Documento documento = getOne(upEntity.getNumeroDocumento());
        
        try {
            if(documento==null){
                throw new SQLException("Documento inexistente.");
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, upEntity.getDescripcion());
            stmt.setInt(2, upEntity.getNumeroDocumento());
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                if (stmt != null){
                    connections.close(stmt);}
                if (conn != null){
                    connections.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        documento = getOne(upEntity.getNumeroDocumento());
        return documento;
    }

    public Documento delete(Documento delEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Documento documento = getOne(delEntity.getNumeroDocumento());
        
        try {
            if(documento==null){
                throw new SQLException("Documento inexistente.");
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, delEntity.getNumeroDocumento());            
            if(stmt.executeUpdate()!=0){
                return documento;
            } 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                if (stmt != null){
                    connections.close(stmt);}
                if (conn != null){
                    connections.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        return documento;
    }
    
}
