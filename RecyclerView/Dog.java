package com.example.pedro.woof.RecyclerView;

import java.io.Serializable;

public class Dog implements Serializable {
    int id;
    int estado; // 1 adoptado, 0 no adoptado
    String nombre;
    String edad;
    String sexo;
    String descripcion;
    String albergue;
    int fotoID;

    public Dog(int id, int estado, String nombre, String edad, String sexo, String descripcion, String albergue, int fotoID) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.albergue = albergue;
        this.fotoID = fotoID;
    }

    public Dog(String nombre, String edad, String sexo, String descripcion, String albergue, int fotoID) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.albergue = albergue;
        this.fotoID = fotoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlbergue() {
        return albergue;
    }

    public void setAlbergue(String albergue) {
        this.albergue = albergue;
    }

    public int getFotoID() {
        return fotoID;
    }

    public void setFotoID(int fotoID) {
        this.fotoID = fotoID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
