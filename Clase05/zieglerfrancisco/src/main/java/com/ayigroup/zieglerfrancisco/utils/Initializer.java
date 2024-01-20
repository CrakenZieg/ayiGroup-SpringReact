
package com.ayigroup.zieglerfrancisco.utils;

import com.ayigroup.zieglerfrancisco.documento.DocumentoDao;
import com.ayigroup.zieglerfrancisco.documento.DocumentoMenu;
import com.ayigroup.zieglerfrancisco.documento.DocumentoRepository;
import com.ayigroup.zieglerfrancisco.documento.DocumentoService;
import com.ayigroup.zieglerfrancisco.persona.PersonaDao;
import com.ayigroup.zieglerfrancisco.persona.PersonaMenu;
import com.ayigroup.zieglerfrancisco.persona.PersonaRepository;
import com.ayigroup.zieglerfrancisco.persona.PersonaService;
import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuarioDao;
import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuarioMenu;
import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuarioRepository;
import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuarioService;
import com.ayigroup.zieglerfrancisco.usuario.UsuarioDao;
import com.ayigroup.zieglerfrancisco.usuario.UsuarioMenu;
import com.ayigroup.zieglerfrancisco.usuario.UsuarioRepository;
import com.ayigroup.zieglerfrancisco.usuario.UsuarioService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Initializer {
    
    private Connections connections;
    private BufferedReader reader;
    private Utils utils;
    
    private DocumentoRepository documentoRepository;
    private TipoUsuarioRepository tipoUsuarioRepository;
    private PersonaRepository personaRepository;
    private UsuarioRepository usuarioRepository;
    
    private DocumentoDao documentoDao;
    private TipoUsuarioDao tipoUsuarioDao;
    private PersonaDao personaDao;
    private UsuarioDao usuarioDao;
    
    private DocumentoService documentoService;
    private TipoUsuarioService tipoUsuarioService;
    private PersonaService personaService;
    private UsuarioService usuarioService;
    
    private DocumentoMenu documentoMenu;
    private TipoUsuarioMenu tipoUsuarioMenu;
    private PersonaMenu personaMenu;
    private UsuarioMenu usuarioMenu;
    
    public Initializer(){
        this.connections = new Connections();
        try{
            this.connections.create();
        }catch(SQLException ex){
            System.out.println("Error: "+ex);
        }
        
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.utils = new Utils(reader);
        
        this.documentoRepository = new DocumentoRepository(connections);
        this.tipoUsuarioRepository = new TipoUsuarioRepository(connections);
        this.personaRepository = new PersonaRepository(connections);
        this.usuarioRepository = new UsuarioRepository(connections);
        
        this.documentoDao = new DocumentoDao(documentoRepository);
        this.tipoUsuarioDao = new TipoUsuarioDao(tipoUsuarioRepository);
        this.personaDao = new PersonaDao(personaRepository, documentoRepository);
        this.usuarioDao = new UsuarioDao(tipoUsuarioRepository, documentoRepository, personaRepository, usuarioRepository);
        
        this.documentoService = new DocumentoService(documentoDao);
        this.tipoUsuarioService = new TipoUsuarioService(tipoUsuarioDao);
        this.personaService = new PersonaService(personaDao);
        this.usuarioService = new UsuarioService(usuarioDao);
        
        this.documentoMenu = new DocumentoMenu(utils, documentoService);
        this.tipoUsuarioMenu = new TipoUsuarioMenu(utils, tipoUsuarioService);
        this.personaMenu = new PersonaMenu(utils, personaService, documentoService);
        this.usuarioMenu = new UsuarioMenu(utils, usuarioService, personaService, documentoService, tipoUsuarioService);
        
    }

    public BufferedReader getReader() {
        return reader;
    }

    public Utils getUtils() {
        return utils;
    }

    public DocumentoMenu getDocumentoMenu() {
        return documentoMenu;
    }

    public TipoUsuarioMenu getTipoUsuarioMenu() {
        return tipoUsuarioMenu;
    }

    public PersonaMenu getPersonaMenu() {
        return personaMenu;
    }

    public UsuarioMenu getUsuarioMenu() {
        return usuarioMenu;
    }

}
