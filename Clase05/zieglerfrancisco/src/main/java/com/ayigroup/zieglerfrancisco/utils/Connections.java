package com.ayigroup.zieglerfrancisco.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connections {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ayigroup?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    public void create() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", JDBC_USER, JDBC_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(
                "CREATE SCHEMA IF NOT EXISTS ayigroup;"
                + "CREATE TABLE ayigroup.documento (\n"
                + "    numero_documento INT NOT NULL PRIMARY KEY,\n"
                + "    descripcion VARCHAR(45)\n"
                + ");"
                + "CREATE TABLE ayigroup.tipo_usuario (\n"
                + "    idtipo_usuario INT NOT NULL PRIMARY KEY,\n"
                + "    descripcion VARCHAR(45)\n"
                + ");"
                + "CREATE TABLE ayigroup.persona (\n"
                + "    idpersona INT NOT NULL PRIMARY KEY,\n"
                + "    nombre VARCHAR(45),\n"
                + "    apellido VARCHAR(45),\n"
                + "    numero_documento INT,\n"
                + "    FOREIGN KEY (numero_documento) REFERENCES ayigroup.documento(numero_documento)\n"
                + ");"
                + "CREATE TABLE ayigroup.usuario (\n"
                + "    idusuario INT NOT NULL PRIMARY KEY,\n"
                + "    nombre_usuario VARCHAR(45),\n"
                + "    password VARCHAR(45),\n"
                + "    idpersona INT,\n"
                + "    tipo_usuario INT,\n"
                + "    FOREIGN KEY (idpersona) REFERENCES ayigroup.persona(idpersona),\n"
                + "    FOREIGN KEY (tipo_usuario) REFERENCES ayigroup.tipo_usuario(idtipo_usuario)\n"
                + ");"
        );
        stmt.execute();
        close(stmt);
        close(conn);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }

    public void close(Connection conn) throws SQLException {
        conn.close();
    }

}
