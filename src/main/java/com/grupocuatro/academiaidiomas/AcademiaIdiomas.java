package com.grupocuatro.academiaidiomas;

import com.grupocuatro.academiaidiomas.models.Alumno;
import com.grupocuatro.academiaidiomas.models.Profesor;
import com.grupocuatro.academiaidiomas.services.AlumnoServiceImpl;
import com.grupocuatro.academiaidiomas.services.ProfesorServiceImpl;
import java.util.LinkedList;
import java.util.List;

public class AcademiaIdiomas {

    public static void main(String[] args) {
        ProfesorServiceImpl pi1 = new ProfesorServiceImpl();
        Profesor p1 = new Profesor (2, "Perro", "Sanxe", "6666666A", "infierno", "6666666");
        pi1.agregarProfesor(p1);
        List<Profesor> profesores = new LinkedList<>();
        profesores = pi1.listarProfesores();
        profesores.forEach(profesor -> {
            System.out.println(profesor.getNombre());
        });
    }
}
