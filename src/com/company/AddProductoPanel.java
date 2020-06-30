package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class AddProductoPanel extends JPanel {

    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill]","[][][][][][]"
    );
    public AddProductoPanel(SwingComponents allC, MainData allD){
        allComponents=allC;
        allData=allD;
        setLayout(layout);
        layoutConfig ();
        configEvents ();
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
