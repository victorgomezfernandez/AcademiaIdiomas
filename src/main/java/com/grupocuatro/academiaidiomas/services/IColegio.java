/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupocuatro.academiaidiomas.services;


import com.grupocuatro.academiaidiomas.models.Colegio;
import java.util.List;

/**
 *
 * @author luish
 */
public interface IColegio {
    public boolean agregarColegio(Colegio colegio);
    public boolean eliminarColegio(int id);
    public boolean actualizarColegio(int id, Colegio colegio);
    public Colegio mostrarColegio(int id);
    public List<Colegio> listarColegios();
}
