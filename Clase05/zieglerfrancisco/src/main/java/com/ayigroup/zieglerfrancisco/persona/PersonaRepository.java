
package com.ayigroup.zieglerfrancisco.persona;

import com.ayigroup.zieglerfrancisco.utils.Connections;
import com.ayigroup.zieglerfrancisco.interfaces.RepositoryInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepository implements RepositoryInterface<Persona, PersonaDTO>{
    
    private Connections connections;
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM persona";
    private static final String SQL_SELECT_ONE = "SELECT * FROM persona WHERE idpersona = ?";
    private static final String SQL_INSERT = "INSERT INTO persona(idpersona, nombre, apellido, numero_documento) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, numero_documento = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona = ?";
    private static final String SQL_SELECT_ONE_DOCU = "SELECT * FROM persona WHERE numero_documento = ?";


    public PersonaRepository(Connections connections) {
        this.connections = connections;
    }

    public List<PersonaDTO> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PersonaDTO> personas = new ArrayList<>();
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);   
            rs = stmt.executeQuery();                   
            while (rs.next()){                          
                int id = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int documento = rs.getInt("numero_documento");
                personas.add(new PersonaDTO(id,nombre,apellido,documento));
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
        return personas;
    }

    public PersonaDTO getOne(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO personaDTO = null;
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE);   
            stmt.setInt(1, id);
            rs = stmt.executeQuery();                   
            if(rs.next()){
                personaDTO =  new PersonaDTO(
                        rs.getInt("idpersona"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("numero_documento")
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
        return personaDTO;
    }
    
    public PersonaDTO getOneByDocumento(int documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO personaDTO = null;
        
        try {
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE_DOCU);   
            stmt.setInt(1, documento);
            rs = stmt.executeQuery();                   
            if(rs.next()){
                personaDTO =  new PersonaDTO(
                        rs.getInt("idpersona"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("numero_documento")
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
        return personaDTO;
    }

    public PersonaDTO create(Persona newEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        if(newEntity.getIdPersona()==0){
            newEntity.setIdPersona((int) Math.floor(Math.random()*10000));
        }
        PersonaDTO personaDTO = getOne(newEntity.getIdPersona());
        
        try {
            if(personaDTO!=null){
                return personaDTO;
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, newEntity.getIdPersona());
            stmt.setString(2, newEntity.getNombre());
            stmt.setString(3, newEntity.getApellido());
            stmt.setInt(4, newEntity.getDocumento().getNumeroDocumento());
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
        personaDTO = getOne(newEntity.getIdPersona());
        return personaDTO;
    }
    
    public PersonaDTO update(Persona upEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        PersonaDTO personaDTO = getOne(upEntity.getIdPersona());
        
        try {
            if(personaDTO!=null){
                throw new SQLException("Persona inexistente.");
            }
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, upEntity.getNombre());
            stmt.setString(2, upEntity.getApellido());
            stmt.setInt(3, upEntity.getDocumento().getNumeroDocumento());
            stmt.setInt(4, upEntity.getIdPersona());
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
        personaDTO = getOne(upEntity.getIdPersona());
        return personaDTO;
    }

    public PersonaDTO delete(Persona delEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        PersonaDTO personaDTO = getOne(delEntity.getIdPersona());
        
        try {
            if(personaDTO!=null){
                throw new SQLException("Persona inexistente.");
            }
            personaDTO = getOne(delEntity.getIdPersona());
            conn = connections.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, delEntity.getIdPersona());            
            if(stmt.executeUpdate()!=0){
                return personaDTO;
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
        return personaDTO;
    }
    
}
