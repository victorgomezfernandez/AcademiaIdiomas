package com.grupocuatro.academiaidiomas;

import com.grupocuatro.academiaidiomas.models.Curso;
import com.grupocuatro.academiaidiomas.services.CursoServiceImpl;

public class AcademiaIdiomas {

    public static void main(String[] args) {
        CursoServiceImpl cur = new CursoServiceImpl();
        Curso curso = new Curso("Ingles", "B1", "120H", "14:00", "08:00", "12/09/2024","01/22/2025");
        cur.Insert(curso);
    }
}
