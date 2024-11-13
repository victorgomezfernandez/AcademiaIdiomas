package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.DAO.BaseDatos;
import com.grupocuatro.academiaidiomas.models.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

        @Override
    public boolean Update(int id) {
        BaseDatos base = new BaseDatos();
        return false;
    }

        @Override

    public Curso Show(int id) {
        BaseDatos base = new BaseDatos();
        return null;
    }

        @Override
    public List<Curso> ShowAll() {
        BaseDatos base = new BaseDatos();
        return null;
    }
}

