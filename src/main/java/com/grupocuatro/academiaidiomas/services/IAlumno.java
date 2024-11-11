package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.models.Alumno;
import java.util.List;

/**
 *
 * @author luish
 */
public interface IAlumno {
    public boolean agregarAlumno(Alumno alumno);
    public boolean eliminarAlumno(int id);
    public boolean actualizarAlumno(int id);
    public Alumno mostrarAlumnos(int id);
    public List<Alumno> listarAlumnos();
}
