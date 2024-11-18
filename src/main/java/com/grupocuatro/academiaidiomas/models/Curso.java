/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupocuatro.academiaidiomas.models;

/**
 *
 * @author Alejandro
 */
public class Curso {
    private int id;
    private int Hora_Inicio;
    private int Hora_Fin;
    private String F_Inicio;
    private String F_Fin;
    private int Duracion;

    public Curso(int id, int Hora_Inicio, int Hora_Fin, String F_Inicio, String F_Fin, int Duracion) {
        this.id = id;
        this.Hora_Inicio = Hora_Inicio;
        this.Hora_Fin = Hora_Fin;
        this.F_Inicio = F_Inicio;
        this.F_Fin = F_Fin;
        this.Duracion = Duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(int Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;
    }

    public int getHora_Fin() {
        return Hora_Fin;
    }

    public void setHora_Fin(int Hora_Fin) {
        this.Hora_Fin = Hora_Fin;
    }

    public String getF_Inicio() {
        return F_Inicio;
    }

    public void setF_Inicio(String F_Inicio) {
        this.F_Inicio = F_Inicio;
    }

    public String getF_Fin() {
        return F_Fin;
    }

    public void setF_Fin(String F_Fin) {
        this.F_Fin = F_Fin;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }
    
}
