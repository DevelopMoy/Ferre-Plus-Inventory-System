package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentaMainPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "debug,fillx,filly","[][shrink,grow,fill][]","[][][][]"
    );
    private JFrame parentFrame;

    public  VentaMainPanel(SwingComponents allC, MainData allD,JFrame parentFrame){
        this.parentFrame=parentFrame;
        setLayout (layout);
        allComponents=allC;
        allData=allD;
        layoutConfig ();
        configEvents ();
    }

    public void configEvents (){
        allComponents.getGoHomeButtonInventory().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                new MainWindow();
            }
        });
    }
    public void layoutConfig(){
       add(allComponents.getProduct ());
       add(allComponents.getProductoVentaCombobox (),"split 3");
       add(allComponents.getSearchVentaButton ());
       add (allComponents.getAddVentaButton (),"wrap");
       add (allComponents.getCantidad ());
       add (allComponents.getCantVentaTextField ());
        add (new JLabel (""),"wrap");
       add (allComponents.getVentTable (), "span 2 2");
       add (allComponents.getLimpiarVentaBoton (),"wrap");
       add (new JLabel (""),"wrap");
        add (new JLabel (""),"split 2");
       add (allComponents.getContVentaLabel ());
       add (allComponents.getContVentaTextField ());
       add (allComponents.getTotalVentaLabel (),"split 2");
       add (allComponents.getTotalVentaTextField ());
       add(allComponents.getGoHomeButtonInventory());
    }

}
