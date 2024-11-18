/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    public boolean actualizarProfesor(int id);
    public Profesor mostrarProfesores(int id);
    public List<Profesor> listarProfesores();
}
