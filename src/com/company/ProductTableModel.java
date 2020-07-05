package com.company;

import javafx.scene.control.Tab;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private ArrayList <TableRegister> data;
    public ProductTableModel (ArrayList <TableRegister> datos){
        data=datos;
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    @Override
    public String getColumnName(int n){
        switch (n){
            case 0:
                return "ID";
            case 1:
                return "Cantidad";
            case 2:
                return "Nombre";
            case 3:
                return "Precio Unidad";
            case 4:
                return "Precio Total";
        }
        return "";
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return data.get(rowIndex).getIdProd();
            case 1:
                return data.get(rowIndex).getCantidad();
            case 2:
                return data.get(rowIndex).getNombre();
            case 3:
                return data.get(rowIndex).getPrecioUnit();
            case 4:
                return data.get(rowIndex).getPrecioTotal();
        }
        return "";
    }
}
