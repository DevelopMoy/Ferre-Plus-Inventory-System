package com.company;

import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class AddProductoPanel extends JPanel {

    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill]","[][][][][][]"
    );
    private JPanel thisComp;
    public AddProductoPanel(SwingComponents allC, MainData allD){
        thisComp=this;
        allComponents=allC;
        allData=allD;
        setLayout(layout);
        layoutConfig ();
        configEvents ();
        dataBaseInitialConfig ();
    }
    private void dataBaseInitialConfig (){
        try {
            ArrayList<String> nombreSecciones = new ArrayList<>();
            ResultSet resultadoConsulta = allData.getMainStatementDB().executeQuery("SELECT NombreSeccion FROM seccion");

            while (resultadoConsulta.next()){
                nombreSecciones.add(resultadoConsulta.getString(1));
            }
            allComponents.getSeccionAddProductCombobox().setModel(new DefaultComboBoxModel(nombreSecciones.toArray()));
            AutoCompleteDecorator.decorate(allComponents.getSeccionAddProductCombobox());
        }catch (Exception e){
            JOptionPane.showMessageDialog(thisComp,"ERROR EN LA BASE DE DATOS: "+e.getMessage());
        }
    }
    private void layoutConfig(){
        add (allComponents.getAddProductLogo (),"span 2, align center, wrap");
        add(allComponents.getNombreAddProductLabel (),"align left");
        add (allComponents.getNombreAddProductTextField (),"wrap");
        add (allComponents.getCodeInternoLabel (),"align left");
        add (allComponents.getCodigointernoTextField (),"wrap");
        add (allComponents.getCategory ());
        add (allComponents.getSeccionAddProductCombobox (),"wrap");
        add (allComponents.getPrecProveLabel ());
        add (allComponents.getPriceProveedorTextField (),"wrap");
        add (allComponents.getPriceUnit ());
        add (allComponents.getPrecioVentaAddProductTextField (),"wrap");
        add (allComponents.getDescripcionLabel ());
        add (allComponents.getDescripcionTextField (),"wrap");
        add (allComponents.getAceptarAddProductButton (),"span 2, align center");
    }
    private void configEvents(){

    }
}
