package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.DAO.BaseDatos;
import com.grupocuatro.academiaidiomas.models.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author luish
 */
public class AlumnoServiceImpl implements IAlumno {

    @Override
    public boolean agregarAlumno(Alumno alumno) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "INSERT INTO alumnos (nombre, apellidos, edad, dni, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellidos());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getDni());
            stmt.setString(5, alumno.getDireccion());
            stmt.setString(6, alumno.getTelefono());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminarAlumno(int id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarAlumno(int id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno mostrarAlumnos(int id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> listarAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
