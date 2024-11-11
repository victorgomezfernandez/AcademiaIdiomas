package models;

import java.io.Serializable;

public class Alumno {

    public long getId() {
        return id;
    }

    public void setId(long id2) {
        this.id = id2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private long id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private String direccion;
    private String telefono;

}
