package com.company.JPanels;

import com.company.JFrames.AddInventoryFrame;
import com.company.JFrames.AddProductFrame;
import com.company.JFrames.VentaMainFrame;
import com.company.MainData;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private JFrame parentFrame;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill][shrink,grow,fill][]","[][][][]"
    );

    public InitialPanel (SwingComponents allC, MainData allD,JFrame parentFrame){
        this.parentFrame=parentFrame;
        allComponents=allC;
        allData=allD;
        setLayout(layout);
        layoutConfig ();
        buttonsConfig ();
    }

    public void layoutConfig (){
        add(new JLabel(""),cellSize);
        add(allComponents.getMainLogo(),"span 2");
        add (new JLabel(""),cellSize+",wrap");
        add(new JLabel(""),cellSize);
        add (allComponents.getSellModeButton());
        add(allComponents.getAddModeButton());
        add (new JLabel(""),cellSize+",wrap");
        add (new JLabel(""),cellSize);
        add (allComponents.getSellLabel(),"aligny top");
        add (allComponents.getAddLabel(),"aligny top");
        add (new JLabel(""),cellSize+",wrap");
        add (new JLabel(""),cellSize);
        add (new JLabel(""),cellSize);
        add(new JLabel(""),cellSize);
        add (allComponents.getInitSettingsButton(),"width 100!,height 70!,aligny top,growx");
        add (allComponents.getAgregarProductoCatalogo());
    }

    public void buttonsConfig (){
        allComponents.getAgregarProductoCatalogo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                new AddProductFrame(allComponents,allData);
            }
        });
        allComponents.getAddModeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                new AddInventoryFrame(allComponents,allData);
            }
        });
        allComponents.getSellModeButton ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                new VentaMainFrame(allComponents,allData);
            }
        });
    }
}
