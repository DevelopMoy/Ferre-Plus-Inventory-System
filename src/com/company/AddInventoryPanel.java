package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddInventoryPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "debug,fillx,filly","27[][shrink,grow,fill]15[left][fill]","[]-130[]-190[]-125[]-125[]-150[]-125[]-125[]"
    );


    public AddInventoryPanel(SwingComponents allC, MainData allD){
        allComponents=allC;
        allData=allD;
        setLayout(layout);
        layoutConfig ();
        configEvents ();

    }
    private void configEvents() {
        allComponents.getPlusLogo ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddProductFrame (allComponents, allData);
            }
        });
    }

    public void layoutConfig (){
        add(new JLabel(""),cellSize);
        add(allComponents.getAddLogo (),"span 2");
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getProduct ());
        add(allComponents.getProductosComboBox (),"align left");
        add(allComponents.getPlusLogo (),"width 35!,height 35!,split 3");
        add (allComponents.getSearchLogo (),"width 35!,height 35!, align left");

        add (allComponents.getCantidad (),"align center");
        add (allComponents.getAmountTextField ());
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getCategory ());
        add (allComponents.getCategorys ());
        add (allComponents.getPriceUnit (),"align center");
        add (allComponents.getPriceUnitTextField ());
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getProvider ());
        add (allComponents.getProviders ());
        add (allComponents.getPrecProveLabel ());
        add (allComponents.getPriceProveedorTextField (),"wrap");
        add(new JLabel(""),cellSize);
        add (allComponents.getSubmmitButton (),"width 280!,height 80!,span 2,align center");
        add (new JLabel(""),cellSize);
    }
}
