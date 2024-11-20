package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.DAO.BaseDatos;
import com.grupocuatro.academiaidiomas.models.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String sql = "INSERT INTO alumno (nombre, apellidos, edad, dni, direccion, telefono, id_colegio) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellido());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getDni());
            stmt.setString(5, alumno.getDireccion());
            stmt.setString(6, alumno.getTelefono());

            // Usar setObject para permitir null en id_colegio
            if (alumno.getColegioId() != null) {
                stmt.setInt(7, alumno.getColegioId()); // Si el valor no es null
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER); // Si el valor es null
            }

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
    public boolean eliminarAlumno(int id) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        try {
            String sql = "DELETE FROM alumno WHERE id = " + id;

            PreparedStatement stmt = conn.prepareStatement(sql);
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
    public boolean actualizarAlumno(int id, Alumno alumno) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        try {
            String sql = "UPDATE alumno SET nombre = ?, apellidos = ?, edad = ?, dni = ?, direccion = ?, telefono = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellido());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getDni());
            stmt.setString(5, alumno.getDireccion());
            stmt.setString(6, alumno.getTelefono());
            stmt.setInt(7, id);

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
    public Alumno mostrarAlumnos(int id) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        Alumno alumno = null;

        try {
            String sql = "SELECT * FROM alumno WHERE id = " + id + "";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int alumnoId = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int edad = rs.getInt("edad");
                String dni = rs.getString("dni");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                Integer colegioId = rs.getInt("id_colegio");

                alumno = new Alumno(nombre, apellidos, edad, dni, direccion, telefono, colegioId);
                alumno.setId(alumnoId);  // Establece el ID que no se pasa en el constructor

            }
        } catch (Exception e) {
            System.out.println("Error al mostrar alumno: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e.getMessage());
            }
        }

        return alumno;
    }

    @Override
    public List<Alumno> listarAlumnos() {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        List<Alumno> alumnos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM alumno";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int edad = rs.getInt("edad");
                String dni = rs.getString("dni");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                // Leer el valor de colegioId y verificar si es null
                Integer colegioId = rs.getInt("id_colegio");
                if (rs.wasNull()) {
                    colegioId = null;
                }

                Alumno alumno = new Alumno(nombre, apellidos, edad, dni, direccion, telefono, colegioId);
                alumno.setId(id);
                alumnos.add(alumno);
            }
        } catch (Exception e) {
            System.out.println("Error al listar alumnos: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e.getMessage());
            }
        }

        return alumnos;
    }

    
}
