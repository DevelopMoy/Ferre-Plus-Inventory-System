package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill][shrink,grow,fill][]","[][][][]"
    );

    public InitialPanel (SwingComponents allC, MainData allD){
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
    }

    public void buttonsConfig (){
        allComponents.getAddModeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allData.setCanClose(false);
                new AddInventoryFrame(allComponents,allData);
            }
        });
    }
}
