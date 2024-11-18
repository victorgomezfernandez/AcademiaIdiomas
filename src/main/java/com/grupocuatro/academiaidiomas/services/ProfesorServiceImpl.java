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
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ProfesorServiceImpl implements IProfesor {

    @Override
    public boolean agregarProfesor(Profesor profesor) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "INSERT INTO profesor (id,nombre, apellidos, dni, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, profesor.getId());
            stmt.setString(2, profesor.getNombre());
            stmt.setString(3, profesor.getApellidos());
            stmt.setString(4, profesor.getDni());
            stmt.setString(5, profesor.getDireccion());
            stmt.setString(6, profesor.getTelefono());
            stmt.executeUpdate();
            stmt.close();
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
            String sql = "DELETE FROM profesor WHERE id = " + id;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean actualizarProfesor(Profesor profesor) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "UPDATE profesor SET nombre = ?, apellidos = ?, direccion = ?, telefono = ?, dni = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(3, profesor.getDireccion());
            stmt.setString(4, profesor.getTelefono());
            stmt.setString(5, profesor.getDni());
            stmt.setInt(6, profesor.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Profesor mostrarProfesores(int id) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        Profesor profesor = null;
        try {
            String sql = "SELECT * FROM profesor WHERE id = " + id;
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idProf = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("dni");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                profesor = new Profesor(idProf, nombre, apellidos, dni, direccion, telefono);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return profesor;
    }

    @Override
    public List<Profesor> listarProfesores() {
        List<Profesor> profesores = new LinkedList<>();
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "SELECT * FROM profesor";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("dni");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                Profesor profesor = new Profesor(id, nombre, apellidos, dni, direccion, telefono);
                profesores.add(profesor);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return profesores;
    }
}
