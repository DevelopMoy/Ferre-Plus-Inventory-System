package com.company;

public class TableRegister {
    private String idProd;
    private String nombre;
    private int cantidad;
    private double precioUnit;
    private double precioTotal;

    public TableRegister(String idProd, String nombre, int cantidad, double precioUnit, double precioTotal) {
        this.idProd = idProd;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.precioTotal = precioTotal;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
