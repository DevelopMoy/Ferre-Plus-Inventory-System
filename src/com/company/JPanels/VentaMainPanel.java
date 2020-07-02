package com.company.JPanels;

import com.company.MainData;
import com.company.JFrames.MainWindow;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentaMainPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill][][]","-35[top,fill]-40[][][][][]-50[fill]-15"
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
        allComponents.getGoHomeButtonVenta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                new MainWindow();
            }
        });
    }
    public void layoutConfig(){
        add (allComponents.getSellModeLogo (), "align center,span 4, wrap");
       add(allComponents.getProduct ());
       add(allComponents.getProductoVentaCombobox (),"split 3");
       add(allComponents.getSearchVentaButton (),"width 35!,height 35!");
       add (allComponents.getAddVentaButton (),"width 35!,height 35!");
       add (allComponents.getCantidad ());
       add (allComponents.getCantVentaTextField (),"width 80!,height 30!,wrap");
      //  add (new JLabel (""),"wrap");
       add (allComponents.getVentTable (), "span 2 3");
       add (allComponents.getLimpiarVentaBoton (),"align center,span 2 2 ,wrap");
        add (new JLabel (""),"wrap");
       add (allComponents.getQuitarVentanaBoton (),"align center, span 2 ,wrap");
       //add (new JLabel (""),"wrap");
       add (new JLabel (""),"width 80!,height 30!, split 2");
       add (allComponents.getContVentaLabel (),"width 80!,height 30!");
       add (allComponents.getContVentaTextField (),"split 3");
       add (allComponents.getTotalVentaLabel (),"width 50!,height 30!,");
       add (allComponents.getTotalVentaTextField ());
       add(allComponents.getGoHomeButtonVenta (),"span 2, align center,wrap");
       add (allComponents.getTerminarVentaBoton (),"width 300!,height 80!,span ,align center");


    }

}
