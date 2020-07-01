package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SearchCompraPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "debug,fillx,filly","[][shrink,grow,fill][]","[][][][]"
    );

    public SearchCompraPanel(SwingComponents allC, MainData allD){
        setLayout (layout);
        allComponents=allC;
        allData=allD;
        layoutConfig ();
        configEvents ();
    }
    public void layoutConfig(){
        add (allComponents.getNombreAddProductLabel ());
        add (allComponents.getNombreSearchCompraTextField (),"split 2");

        add (allComponents.getSearchButtonSearchCompraPanel (),"width 35!,height 35!,wrap");


        add (allComponents.getSearchCompraJTable (),"span  2 2 ,wrap");
        add (new JLabel (""),"wrap,wrap");



        add (allComponents.getAceptarButtonSearchCompraPanel (),"span 2, align center");




    }
    public void configEvents(){

    }


}
