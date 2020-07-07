package com.company.JPanels;

import com.company.MainData;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SearchCompraPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill][]","[][][][][]"
    );
    private JFrame parentFrame;

    public SearchCompraPanel(SwingComponents allC, MainData allD,JFrame parentFrame){
        this.parentFrame=parentFrame;
        setLayout (layout);
        allComponents=allC;
        allData=allD;
        layoutConfig ();
        configEvents ();
    }
    public void layoutConfig(){
        add (allComponents.getSearchTitle (),"span 2,align center, wrap");
        add (allComponents.getTitulosSearch ());
        add (allComponents.getNombreSearchCompraTextField (),"split 2");
        add (allComponents.getSearchButtonSearchCompraPanel (),"width 35!,height 35!,wrap");
        add (allComponents.getSearchCompraJTable (),"span  2 2 ,wrap");
        add (new JLabel (""),"wrap,wrap");
        add (allComponents.getGoHomeSearchPanel ());
        add (allComponents.getAceptarButtonSearchCompraPanel ()," align center");

    }
    public void configEvents(){

    }


}
