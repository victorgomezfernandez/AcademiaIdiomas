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
            String sql = "INSERT INTO curso (idioma, nivel, duracion, hora_Ini, f_Ini, hora_Fin, f_Fin) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getIdioma());
            stmt.setString(2, curso.getNivel());
            stmt.setString(3, curso.getDuracion());
            stmt.setString(4, curso.getHoraIni());
            stmt.setString(5, curso.getFechaIni());
            stmt.setString(6, curso.getHoraFin());
            stmt.setString(7, curso.getFechaFin());

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
            String sql = "UPDATE curso SET idioma=?, nivel=?, duracion=?, hora_Ini=?, f_Ini=?, hora_Fin=?, f_Fin=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getIdioma());
            stmt.setString(2, curso.getNivel());
            stmt.setString(3, curso.getDuracion());
            stmt.setString(4, curso.getHoraIni());
            stmt.setString(5, curso.getFechaIni());
            stmt.setString(6, curso.getHoraFin());
            stmt.setString(7, curso.getFechaFin());
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
                        rs.getString("hora_Ini"),
                        rs.getString("f_Ini"),
                        rs.getString("hora_Fin"),
                        rs.getString("f_Fin")
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

    public List<Curso> listarIdiomaYNivel(int idAlumno) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        List<Curso> listaCursos = new ArrayList<>();

        try {
            String sql = """
        SELECT c.id, c.idioma, c.nivel, c.duracion, c.horaFin, c.horaIni, c.fechaFin, c.fechaIni
        FROM curso c
        INNER JOIN matricula m ON c.id = m.id_curso
        WHERE m.id_alumno = ?
        """;

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAlumno);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idCurso = rs.getInt("id");
                String idioma = rs.getString("idioma");
                String nivel = rs.getString("nivel");
                String duracion = rs.getString("duracion");
                String horaFin = rs.getString("horaFin");
                String horaIni = rs.getString("horaIni");
                String fechaFin = rs.getString("fechaFin");
                String fechaIni = rs.getString("fechaIni");

                // Crear un nuevo objeto Curso con los datos obtenidos y agregarlo a la lista
                Curso curso = new Curso(idioma, nivel, duracion, horaFin, horaIni, fechaFin, fechaIni);
                curso.setId(idCurso); // Asegúrate de que el método setId esté en la clase Curso
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
