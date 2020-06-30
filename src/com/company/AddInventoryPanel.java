package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class AddInventoryPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "debug,fillx,filly","27[][shrink,grow,fill]15[left][fill]","[]-80[]-110[]-115[]"
    );

    public AddInventoryPanel(SwingComponents allC, MainData allD){
        allComponents=allC;
        allData=allD;
        setLayout(layout);
        layoutConfig ();
    }

    public void layoutConfig (){
        add(new JLabel(""),cellSize);
        add(allComponents.getAddLogo (),"span 2");
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getProduct ());
        add(allComponents.getProducts (),"split 3, align center");
        add(allComponents.getPlusLogo (),"width 35!,height 35!");
        add (allComponents.getSearchLogo (),"width 35!,height 45!, align center");

        add (allComponents.getCantidad ());
        add (allComponents.getAmountTextField ());
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getCategory ());
        add (allComponents.getCategorys ());
        add (allComponents.getPriceUnit ());
        add (allComponents.getPriceUnitTextField ());
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getProvider ());
        add (allComponents.getProviders ());
        add (allComponents.getSubmmitButton (),"span 3");
    }
}
