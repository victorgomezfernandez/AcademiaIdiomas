package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.models.Curso;
import java.util.List;
/**
 *
 * @author Alejandro
 */
public interface  ICurso {
    public boolean Insert(Curso curso);
    public boolean Remove(int id);
    public boolean Update(int id);
    public Curso Show(int id);
    public List<Curso> ShowAll();
}
    

