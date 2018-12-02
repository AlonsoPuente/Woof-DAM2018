package com.example.pedro.woof.Adoptante;

public class Adoptante {
    private int dni;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private String telefono;
    private String direccion;
    private String estadoCivil;// S=soltero; Co=conviviente; Ca=Casado y V=Viudo;
    private int estado; //Ha adoptado = 1; no ha adoptado=0;
    private int aceptado; //Si ha sido aceptado o no para adoptar

    public Adoptante(int dni, String nombre, String apellido, String correo, String clave, String telefono, String direccion, String estadoCivil, int estado, int aceptado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.estado = estado;
        this.aceptado = aceptado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getAceptado() {
        return aceptado;
    }

    public void setAceptado(int aceptado) {
        this.aceptado = aceptado;
    }
}


