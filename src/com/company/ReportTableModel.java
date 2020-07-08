package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ReportTableModel extends AbstractTableModel {
    ArrayList <ReportTableRegister> data;
    public ReportTableModel (ArrayList <ReportTableRegister> datos){
        data=datos;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0:
                return "Numero Pedido";
            case 1:
                return "Producto";
            case 2:
                return "Fecha";
            case 3:
                return "Monto Total";
            case 4:
                return "Cantidad";
            case 5:
                return "ID Proveedor";
            default:
                return "";
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return data.get(rowIndex).getNumeroPedido();
            case 1:
                return data.get(rowIndex).getNombreProducto();
            case 2:
                return data.get(rowIndex).getFecha();
            case 3:
                return data.get(rowIndex).getMontoTotal();
            case 4:
                return data.get(rowIndex).getCantidadProductos();
            case 5:
                return data.get(rowIndex).getIdProveedor();
            default:
                return "";
        }
    }
}
