package models;

public class Alumno {

    public int getId() {
        return id;
    }

    public void setId(int id2) {
        this.id = id2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
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

    public void setTelefono(String setTelefono) {
        this.telefono = telefono;
    }

    public Alumno(int id, String nombre, String apellidos, int edad, String dni, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    
    
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private String direccion;
    private String telefono;

}
