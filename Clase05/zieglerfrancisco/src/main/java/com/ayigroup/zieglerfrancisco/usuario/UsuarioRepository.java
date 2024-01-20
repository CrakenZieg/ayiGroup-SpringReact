
package com.ayigroup.zieglerfrancisco.usuario;

import com.ayigroup.zieglerfrancisco.utils.Connections;
import com.ayigroup.zieglerfrancisco.interfaces.RepositoryInterface;
import com.ayigroup.zieglerfrancisco.persona.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements RepositoryInterface<Usuario, UsuarioDTO>{

    private Connections connections;
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM usuario";
    private static final String SQL_SELECT_ONE = "SELECT * FROM usuario WHERE idusuario = ?";
    private static final String SQL_INSERT = "INSERT INTO usuario(idusuario, nombre_usuario, password, idpersona, tipo_usuario) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre_usuario = ?, password = ?, idpersona = ?, tipo_usuario = ? WHERE idusuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario = ?";
    private static final String SQL_SELECT_ONE_PER = "SELECT * FROM usuario WHERE idpersona = ?";


    public UsuarioRepository(Connections connections) {
        this.connections = connections;
    }
    
    @Override
    public List<UsuarioDTO> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);   
            rs = stmt.executeQuery();                   
            while (rs.next()){                          
                int id = rs.getInt("idusuario");
                String nombreUsuario = rs.getString("nombre_usuario");
                String password = rs.getString("password");
                int persona = rs.getInt("idpersona");
                int tipoUsuario = rs.getInt("tipo_usuario");
                usuarios.add(new UsuarioDTO(id,nombreUsuario,password,persona,tipoUsuario));
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
        return usuarios;
    }

    @Override
    public UsuarioDTO getOne(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = null;
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();                   
            if(rs.next()){
                usuario =  new UsuarioDTO(
                        rs.getInt("idusuario"),
                        rs.getString("nombre_usuario"),
                        rs.getString("password"),
                        rs.getInt("idpersona"),
                        rs.getInt("tipo_usuario")
                        );
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
        return usuario;
    }
        
    public UsuarioDTO getOneByPersona(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = null;
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE_PER);
            stmt.setInt(1, persona.getIdPersona());
            rs = stmt.executeQuery();                   
            if(rs.next()){
                usuario =  new UsuarioDTO(
                        rs.getInt("idusuario"),
                        rs.getString("nombre_usuario"),
                        rs.getString("password"),
                        rs.getInt("idpersona"),
                        rs.getInt("tipo_usuario")
                        );
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
        return usuario;
    }

    @Override
    public UsuarioDTO create(Usuario newEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        if(newEntity.getIdUsuario()==0){
            newEntity.setIdUsuario((int) Math.floor(Math.random()*10000));
        }
        UsuarioDTO usuarioDTO = getOne(newEntity.getIdUsuario());
        
        try {
            if(usuarioDTO!=null){
                return usuarioDTO;
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, newEntity.getIdUsuario());
            stmt.setString(2, newEntity.getNombreUsuario());
            stmt.setString(3, newEntity.getPassword());            
            stmt.setInt(4, newEntity.getPersona().getIdPersona());
            stmt.setInt(5, newEntity.getTipoUsuario().getIdTipoUsuario());
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
        usuarioDTO = getOne(newEntity.getIdUsuario());
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO update(Usuario upEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        UsuarioDTO usuarioDTO = getOne(upEntity.getIdUsuario());
        
        try {
            if(usuarioDTO!=null){
                throw new SQLException("Usuario inexistente.");
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, upEntity.getNombreUsuario());
            stmt.setString(2, upEntity.getPassword());
            stmt.setInt(3, upEntity.getPersona().getIdPersona());
            stmt.setInt(4, upEntity.getTipoUsuario().getIdTipoUsuario());
            stmt.setInt(5, upEntity.getIdUsuario());
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
        usuarioDTO = getOne(upEntity.getIdUsuario());
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO delete(Usuario delEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        UsuarioDTO usuarioDTO = getOne(delEntity.getIdUsuario());
        
        try {
            if(usuarioDTO!=null){
                throw new SQLException("Usuario inexistente.");
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, delEntity.getIdUsuario());            
            if(stmt.executeUpdate()!=0){
                return usuarioDTO;
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
        return usuarioDTO;
    }
    
}
