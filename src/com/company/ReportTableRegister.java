package com.company;

public class ReportTableRegister {
    int numeroPedido;
    String nombreProducto;
    String fecha;
    Double montoTotal;
    int cantidadProductos;
    int idProveedor;

    public ReportTableRegister(int numeroPedido, String nombreProducto, String fecha, Double montoTotal, int cantidadProductos, int idProveedor) {
        this.numeroPedido = numeroPedido;
        this.nombreProducto = nombreProducto;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.cantidadProductos = cantidadProductos;
        this.idProveedor = idProveedor;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}
