package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SearchTableAbstractModel extends AbstractTableModel {
    private ArrayList <SearchTableRegister> data;
    public SearchTableAbstractModel(ArrayList<SearchTableRegister> arreglo){
        data=arreglo;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Codigo";
            case 3:
                return "Seccion";
            case 4:
                return "Descripcion";
            default:
                    return "";

        }
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int columnIndex) {
        switch (columnIndex){
            case 0:
                return data.get(row).getId();
            case 1:
                return data.get(row).getNombre();
            case 2:
                return data.get(row).getCodigo();
            case 3:
                return data.get(row).getSeccion();
            case 4:
                return data.get(row).getDescripcion();
            default:
                return "";

        }
    }
}
