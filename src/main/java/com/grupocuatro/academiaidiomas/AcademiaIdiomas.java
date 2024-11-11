package com.grupocuatro.academiaidiomas;

import com.grupocuatro.academiaidiomas.models.Alumno;
import com.grupocuatro.academiaidiomas.services.AlumnoServiceImpl;

public class AcademiaIdiomas {

    public static void main(String[] args) {
        AlumnoServiceImpl al = new AlumnoServiceImpl();
        Alumno alumno = new Alumno("alejandro", "abreu", 8, "bbsshgcfaf", "afafafaf", "111111111");
        al.agregarAlumno(alumno);
    }
}
