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
    private String idioma;
    private String nivel;
    private String duracion;
    private String horaFin;
    private String horaIni;
    private String fechaFin;
    private String fechaIni;

    public Curso(String idioma, String nivel, String duracion, String horaFin, String horaIni, String fechaFin, String fechaIni) {
        this.id=id;
        this.idioma = idioma;
        this.nivel = nivel;
        this.duracion = duracion;
        this.horaFin = horaFin;
        this.horaIni = horaIni;
        this.fechaFin = fechaFin;
        this.fechaIni = fechaIni;
    }

    public int getId() {
        return id;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getNivel() {
        return nivel;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

   
    
    
}
