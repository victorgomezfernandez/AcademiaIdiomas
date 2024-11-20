package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.models.Profesor;
import java.util.List;

/**
 *
 * @author victo
 */
public interface IProfesor {
    public boolean agregarProfesor(Profesor profesor);
    public boolean eliminarProfesor(int id);
    public boolean actualizarProfesor(Profesor profesor);
    public Profesor mostrarProfesores(int id);
    public List<Profesor> listarProfesores();
}
