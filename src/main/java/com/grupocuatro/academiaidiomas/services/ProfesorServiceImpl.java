/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupocuatro.academiaidiomas.services;

/**
 *
 * @author victo
 */
import com.grupocuatro.academiaidiomas.DAO.BaseDatos;
import com.grupocuatro.academiaidiomas.models.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ProfesorServiceImpl implements IProfesor {

    @Override
    public boolean agregarProfesor(Profesor profesor) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "INSERT INTO profesores (nombre, apellidos, dni, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(4, profesor.getDni());
            stmt.setString(5, profesor.getDireccion());
            stmt.setString(6, profesor.getTelefono());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminarProfesor(int id) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "DELETE FROM profesores WHERE id LIKE " + id;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean actualizarProfesor(int id) {
        BaseDatos base = new BaseDatos();
        return false;
    }

    @Override
    public Profesor mostrarProfesores(int id) {
        BaseDatos base = new BaseDatos();
        return null;
    }

    @Override
    public List<Profesor> listarProfesores() {
        BaseDatos base = new BaseDatos();
        return null;
    }
}
