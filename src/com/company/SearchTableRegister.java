package com.company;

public class SearchTableRegister {
    private int id;
    private String nombre;
    private String codigo;
    private String seccion;
    private String descripcion;

    public SearchTableRegister(int id, String nombre, String codigo, String seccion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.seccion = seccion;
        this.descripcion = descripcion;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
