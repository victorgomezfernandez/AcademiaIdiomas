package com.grupocuatro.academiaidiomas.models;

/**
 *
 * @author luish
 */
public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String direccion;
    private String telefono;
    private Integer colegioId;

    public Alumno(String nombre, String apellidos, int edad, String dni, String direccion, String telefono, Integer colegioId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.colegioId = colegioId;
        
    }

    public Alumno(String nombre, String apellido, int edad, String dni, String direccion, String telefono) {
        this(nombre, apellido, edad, dni, direccion, telefono, null );
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellido;
    }

    public void setApellidos(String apellidos) {
        this.apellido = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getColegioId() {
        return colegioId;
    }

    public void setColegioId(Integer colegioId) {
        this.colegioId = colegioId;
    }
    
    
    
    
    
    
}
