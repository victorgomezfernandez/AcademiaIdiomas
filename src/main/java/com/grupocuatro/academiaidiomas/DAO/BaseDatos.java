package com.grupocuatro.academiaidiomas.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/db_academia";
    private static final String USER = "bdd_admin";
    private static final String PASSWORD = "azkj-d53r-pm6y";

    
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: el driver no fue encontrado");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    public BaseDatos() {
        conectar();
    }
    
    
}
