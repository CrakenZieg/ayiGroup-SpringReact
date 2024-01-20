
package com.ayigroup.zieglerfrancisco.tipoUsuario;

import com.ayigroup.zieglerfrancisco.utils.Connections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioRepository {
    
    private Connections connections;
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM tipo_usuario";
    private static final String SQL_SELECT_ONE = "SELECT * FROM tipo_usuario WHERE idtipo_usuario = ?";
    private static final String SQL_INSERT = "INSERT INTO tipo_usuario(idtipo_usuario, descripcion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tipo_usuario SET descripcion = ? WHERE idtipo_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM tipo_usuario WHERE idtipo_usuario = ?";

    public TipoUsuarioRepository(Connections connections) {
        this.connections = connections;
    }

    public List<TipoUsuario> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TipoUsuario> tiposUsuario = new ArrayList<>();
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);   
            rs = stmt.executeQuery();                   
            while (rs.next()){                          
                int id = rs.getInt("idtipo_usuario");
                String descripcion = rs.getString("descripcion");
                tiposUsuario.add(new TipoUsuario(id,descripcion));
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
        return tiposUsuario;
    }

    public TipoUsuario getOne(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoUsuario tipoUsuario = null;
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE);   
            stmt.setInt(1, id);
            rs = stmt.executeQuery();                   
            if(rs.next()){
                tipoUsuario =  new TipoUsuario(
                        rs.getInt("idtipo_usuario"),
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
        return tipoUsuario;
    }

    public TipoUsuario create(TipoUsuario newEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        if(newEntity.getIdTipoUsuario()==0){
            newEntity.setIdTipoUsuario((int) Math.floor(Math.random()*10000));
        }
        TipoUsuario tipoUsuario = getOne(newEntity.getIdTipoUsuario());
        
        try {
            if(tipoUsuario!=null){
                return tipoUsuario;
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, newEntity.getIdTipoUsuario());
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
        tipoUsuario = getOne(newEntity.getIdTipoUsuario());
        return tipoUsuario;
    }
    
    public TipoUsuario update(TipoUsuario upEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        TipoUsuario tipoUsuario = getOne(upEntity.getIdTipoUsuario());
        
        try {
            if(tipoUsuario==null){
                throw new SQLException("Tipo de usuario inexistente.");
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, upEntity.getDescripcion());
            stmt.setInt(2, upEntity.getIdTipoUsuario());
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
        tipoUsuario = getOne(upEntity.getIdTipoUsuario());
        return tipoUsuario;
    }

    public TipoUsuario delete(TipoUsuario delEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        TipoUsuario tipoUsuario = getOne(delEntity.getIdTipoUsuario());
        
        try {
            if(tipoUsuario==null){
                throw new SQLException("Tipo de usuario inexistente.");
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, delEntity.getIdTipoUsuario());            
            if(stmt.executeUpdate()!=0){
                return tipoUsuario;
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
        return tipoUsuario;
    }
    
}
