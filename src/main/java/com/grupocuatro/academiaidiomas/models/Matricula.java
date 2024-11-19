/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupocuatro.academiaidiomas.models;

/**
 *
 * @author Alejandro
 */

public class Matricula {
    private int id;
    private int id_curso;
    private int id_alumno;
    private int nota;

    public Matricula(int id, int id_curso, int id_alumno, int nota) {
        this.id = id;
        this.id_curso = id_curso;
        this.id_alumno = id_alumno;
        this.nota = nota;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
