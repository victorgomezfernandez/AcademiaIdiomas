package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.models.Alumno;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IProfesor {
    public boolean agregarProfesor(Alumno alumno);
    public boolean eliminarProfesor(int id);
    public boolean actualizarProfesor(int id);
    public Alumno mostrarProfesores(int id);
    public List<Alumno> listarProfesores();

}
