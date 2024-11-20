package com.grupocuatro.academiaidiomas.services;

import com.grupocuatro.academiaidiomas.models.Alumno;
import com.grupocuatro.academiaidiomas.models.Curso;
import com.grupocuatro.academiaidiomas.services.CursoServiceImpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.VistaCurso;
import vista.VistaCursoEditar;

public class AcademiaController {

    CursoServiceImpl cursoBd = new CursoServiceImpl();

    public void putAlumno(Alumno alumno) {

    }

    public void MostratTablaCurso(JTable tabla, VistaCurso panel) {
        List<Curso> cursos = new ArrayList<>();
        cursos = cursoBd.ShowAll();
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"ID_Profesor", "Idioma", "Nivel", "Duración", "Hora Inicio", "Hora Fin", "Fecha Inicio", "Fecha Fin", ""};
        model.setColumnIdentifiers(columnNames);
        for (Curso curso : cursos) {
            Object[] rowData = {
                curso.getId_profesor(),
                curso.getIdioma(),
                curso.getNivel(),
                curso.getDuracion(),
                curso.getHoraIni(),
                curso.getHoraFin(),
                curso.getFechaIni(),
                curso.getFechaFin(),
                new JButton("Editar")
            };
            model.addRow(rowData);
        }
        tabla.setModel(model);

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Doble clic
                    int filaSeleccionada = tabla.convertRowIndexToModel(tabla.getSelectedRow());
                    if (filaSeleccionada >= 0) {
                        // Obtener los datos del curso seleccionado
                        List<Curso> cursos = new ArrayList<>();
                        cursos = cursoBd.ShowAll();
                        Curso cursoSeleccionado = cursos.get(filaSeleccionada);

                        // Crear y mostrar el JFrame VistaCursoEditar
                        VistaCursoEditar vistaCursoEditar = new VistaCursoEditar(cursoSeleccionado,panel);
                        vistaCursoEditar.setVisible(true);
                        System.out.print("Click");
                    }
                }
            }
        });

    }
    
    public void borrarCurso(int id){
        cursoBd.Remove(id);
    }

    public void SubirNuevoCurso(int id_profesor, String idioma, String nivel, String duracion, String horaInicio, String horaFin, String fechaInicio, String fechaFin) {
        Curso newCurso = new Curso(id_profesor, idioma, nivel, duracion, horaFin,horaInicio,  fechaFin, fechaInicio);
        cursoBd.Insert(newCurso);
    }
    
    public void ActualizarCurso(Curso curso) {
        cursoBd.Update(curso);
    }
}
