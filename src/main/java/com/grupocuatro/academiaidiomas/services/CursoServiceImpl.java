package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.DAO.BaseDatos;
import com.grupocuatro.academiaidiomas.models.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class CursoServiceImpl implements ICurso {

    @Override
    public boolean Insert(Curso curso) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "INSERT INTO curso (id_profesor, idioma, nivel, duracion, h_Inicio, f_Inicio, h_Fin, f_Fin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, curso.getId_profesor());
            stmt.setString(2, curso.getIdioma());
            stmt.setString(3, curso.getNivel());
            stmt.setString(4, curso.getDuracion());
            stmt.setString(5, curso.getHoraIni());
            stmt.setString(6, curso.getHoraFin());
            stmt.setString(7, curso.getFechaIni());
            stmt.setString(8, curso.getFechaFin());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean Remove(int id) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "DELETE FROM curso WHERE id LIKE " + id;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean Update(Curso curso) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        try {
            String sql = "UPDATE curso SET id_profesor=?, idioma=?, nivel=?, duracion=?, h_Inicio=?, f_Inicio=?, h_Fin=?, f_Fin=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, curso.getId_profesor());
            stmt.setString(2, curso.getIdioma());
            stmt.setString(3, curso.getNivel());
            stmt.setString(4, curso.getDuracion());
            stmt.setString(5, curso.getHoraIni());
            stmt.setString(6, curso.getHoraFin());
            stmt.setString(7, curso.getFechaIni());
            stmt.setString(8, curso.getFechaFin());
            stmt.setInt(9, curso.getId()); // Set the ID for the WHERE clause
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Update" + curso.getId());
            return true;

        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
            return false;
        }

    }

    @Override
    public Curso Show(int id) {
        BaseDatos base = new BaseDatos();
        return null;
    }

    @Override
    public List<Curso> ShowAll() {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        List<Curso> cursos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM curso";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            //String sql = "INSERT INTO curso (idioma, nivel, duracion, hora_Ini, f_Ini, hora_Fin, f_Fin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id_profesor"),
                        rs.getString("idioma"),
                        rs.getString("nivel"),
                        rs.getString("duracion"),
                        rs.getString("h_fin"),
                        rs.getString("h_inicio"),
                        rs.getString("f_Fin"),
                        rs.getString("f_inicio")
                );
                curso.setId(rs.getInt("id"));
                cursos.add(curso);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cursos;

    }

    @Override
    public boolean Update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
