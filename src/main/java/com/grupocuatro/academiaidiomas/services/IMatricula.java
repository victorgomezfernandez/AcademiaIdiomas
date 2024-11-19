package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.models.Matricula;
import java.util.List;

public interface IMatricula {
    public boolean agregarMatricula(Matricula matricula);
    public boolean eliminarMatricula(int id);
    public boolean actualizarMatricula(int id);
    public Matricula mostrarMatricula(int id);
    public List<Matricula> listarMatricula(int id);
}
