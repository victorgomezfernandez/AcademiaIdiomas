package com.grupocuatro.academiaidiomas;

import com.grupocuatro.academiaidiomas.models.Curso;
import com.grupocuatro.academiaidiomas.services.CursoServiceImpl;
import vista.VistaCurso;

public class AcademiaIdiomas {

    public static void main(String[] args)  {
    
      
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCurso().setVisible(true);
            }
        });
    }
}
