package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.DAO.BaseDatos;
import com.grupocuatro.academiaidiomas.models.Matricula;
import com.grupocuatro.academiaidiomas.services.IMatricula;

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
public class MatriculacionServiceImpl implements IMatricula {

    @Override
    public boolean agregarMatricula(Matricula matricula) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "INSERT INTO matricula (id_alumno, id_curso, nota) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, matricula.getId_alumno());
            stmt.setInt(1, matricula.getId_alumno());

            stmt.setInt(2, matricula.getId_curso());
            stmt.setInt(3, matricula.getNota());

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
    public boolean actualizarMatricula(int id, Matricula matricula) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        try {
            String sql = "UPDATE matricula SET id_alumno = ?, id_curso = ?, nota = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, matricula.getId_alumno());
            stmt.setInt(2, matricula.getId_curso());
            stmt.setInt(3, matricula.getNota());
            stmt.setInt(4, id);

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
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        Matricula matricula = null;

        try {
            String sql = "SELECT * FROM matricula WHERE id = " + id + "";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_Matricula = rs.getInt("id");
                int id_curso = rs.getInt("id_curso");
                int id_alumno = rs.getInt("id_alumno");
                int nota = rs.getInt("nota");

                matricula = new Matricula(id_curso, id_alumno, nota);
                matricula.setId(id_Matricula);  // Establece el ID que no se pasa en el constructor

                // Imprimir los datos por la terminal
                System.out.println("id: " + id);
                System.out.println("id_curso: " + id_curso);
                System.out.println("id_alumno: " + id_alumno);
                System.out.println("nota: " + nota);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar matricula: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Matricula> listarMatricula() {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        List<Matricula> matriculas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM matricula";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int id_curso = rs.getInt("id_curso");
                int id_alumno = rs.getInt("id_alumno");
                int nota = rs.getInt("nota");

                Matricula matricula = new Matricula(id_curso, id_alumno, nota);
                matricula.setId(id);
                matriculas.add(matricula);
            }
        } catch (Exception e) {
            System.out.println("Error al listar matriculas: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e.getMessage());
            }
        }

        return matriculas;
    }

}
