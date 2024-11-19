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
            String sql = "INSERT INTO curso (idioma, nivel, f_inicio, f_fin, h_inicio, h_fin, duracion) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getIdioma());
            stmt.setString(2, curso.getNivel());
            stmt.setString(3, curso.getFechaIni());
            stmt.setString(4, curso.getFechaFin());
            stmt.setString(5, curso.getHoraIni());
            stmt.setString(6, curso.getHoraFin());
            stmt.setString(7, curso.getDuracion());

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
            String sql = "UPDATE curso SET idioma=?, nivel=?, f_inicio=?, f_fin=?, h_inicio=?, h_fin=?, duracion=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getIdioma());
            stmt.setString(2, curso.getNivel());
            stmt.setString(3, curso.getFechaIni());
            stmt.setString(4, curso.getFechaFin());
            stmt.setString(5, curso.getHoraIni());
            stmt.setString(6, curso.getHoraFin());
            stmt.setString(7, curso.getDuracion());
            stmt.setInt(8, curso.getId()); // Set the ID for the WHERE clause
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
        List<Curso> cursos = new ArrayList<>();
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        try {
            String sql = "SELECT * FROM curso";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            //String sql = "INSERT INTO curso (idioma, nivel, duracion, hora_Ini, f_Ini, hora_Fin, f_Fin) VALUES (?, ?, ?, ?, ?, ?, ?)";
            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getString("idioma"),
                        rs.getString("nivel"),
                        rs.getString("duracion"),
                        rs.getString("h_inicio"),
                        rs.getString("f_inicio"),
                        rs.getString("h_fin"),
                        rs.getString("f_fin")
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

    public List<Curso> obtenerCursosPorAlumno(int idAlumno) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        List<Curso> listaCursos = new ArrayList<>();

        try {
            // Consulta para obtener los cursos donde el alumno esté matriculado
            String sql = """
        SELECT c.id, c.idioma, c.nivel, c.f_inicio, c.f_fin, c.h_inicio, c.h_fin, c.duracion
        FROM curso c
        JOIN matricula m ON c.id = m.id_curso
        WHERE m.id_alumno = ?;
        """;

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAlumno); // Establecemos el id del alumno

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Creación del objeto Curso a partir de los resultados de la consulta
                int idCurso = rs.getInt("id");
                String idioma = rs.getString("idioma");
                String nivel = rs.getString("nivel");
                String duracion = rs.getString("duracion");
                String horaIni = rs.getString("h_inicio");
                String fechaIni = rs.getString("f_inicio");
                String horaFin = rs.getString("h_fin");
                String fechaFin = rs.getString("f_fin");

                // Crear el objeto Curso y añadirlo a la lista
                Curso curso = new Curso(idioma, nivel, duracion, horaFin, horaIni, fechaFin, fechaIni);
                curso.setId(idCurso); // Establecer el ID del curso
                listaCursos.add(curso);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error fetching cursos: " + e.getMessage());
        }

        return listaCursos;
    }

    @Override
    public boolean Update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
