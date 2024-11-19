package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.DAO.BaseDatos;
import com.grupocuatro.academiaidiomas.models.Alumno;
import com.grupocuatro.academiaidiomas.models.Colegio;
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
public class ColegioServiceImpl implements IColegio {

    @Override
    public boolean agregarColegio(Colegio colegio) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();
        try {
            String sql = "INSERT INTO colegio (nombre, direccion) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, colegio.getNombre());
            stmt.setString(2, colegio.getDireccion());

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
    public boolean eliminarColegio(int id) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        try {
            String sql = "DELETE FROM colegio WHERE id = " + id;

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
    public boolean actualizarColegio(int id, Colegio colegio) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        try {
            String sql = "UPDATE colegio SET nombre = ?, direccion = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, colegio.getNombre());
            stmt.setString(2, colegio.getDireccion());
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
    public Colegio mostrarColegio(int id) {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        Colegio colegio = null;

        try {
            String sql = "SELECT * FROM colegio WHERE id = " + id + "";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int colegioId = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

                colegio = new Colegio(nombre, direccion);
                colegio.setId(colegioId);  // Establece el ID que no se pasa en el constructor

                // Imprimir los datos por la terminal
                System.out.println("Alumno: " + colegioId);
                System.out.println("Nombre: " + nombre);
                System.out.println("Dirección: " + direccion);
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

        return colegio;
    }

    @Override
    public List<Colegio> listarColegios() {
        BaseDatos base = new BaseDatos();
        base.conectar();
        Connection conn = base.getConn();

        List<Colegio> colegios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM colegio";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

                Colegio colegio = new Colegio(nombre, direccion);
                colegio.setId(id);
                colegios.add(colegio);

                // Imprimir los datos de cada alumno por la terminal
                /**
                 * System.out.println("Alumno: " + id);
                 * System.out.println("Nombre: " + nombre);
                 * System.out.println("Apellido: " + apellido);
                 * System.out.println("Edad: " + edad); System.out.println("DNI:
                 * " + dni); System.out.println("Dirección: " + direccion);
                 * System.out.println("Teléfono: " + telefono);
                 * System.out.println("-------------------------------");
                 */
            }
        } catch (Exception e) {
            System.out.println("Error al listar colegios: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e.getMessage());
            }
        }

        return colegios;
    }

}
