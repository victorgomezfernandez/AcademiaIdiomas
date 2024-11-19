package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.DAO.BaseDatos;
import com.grupocuatro.academiaidiomas.models.Matricula;
import com.grupocuatro.academiaidiomas.services.IMatricula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class MatriculacionServiceImpl implements IMatricula {

    @Override
    public boolean agregarMatricula(Matricula matricula) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "INSERT INTO matricula (id_alumno, id_curso, nota) VALUES (?, ?, ?, )";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, matricula.getId_alumno());
            stmt.setInt(2, matricula.getId_curso());
            stmt.setInt(3, matricula.getNota());
            stmt.setInt(4, matricula.getId());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminarMatricula(int id) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
         String sql = "DELETE FROM matricula WHERE id LIKE " + id;
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean actualizarMatricula(Matricula matricula) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        try {
            String sql = "UPDATE matricula SET Id_alumno = ?, Id_curso = ?, getNota = ?, id = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, matricula.getId_alumno());
            stmt.setInt(2, matricula.getId_curso());
            stmt.setInt(3, matricula.getNota());
            stmt.setInt(4, matricula.getId());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Matricula mostrarMatricula(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Matricula> listarMatricula(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}