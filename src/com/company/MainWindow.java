package com.company;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private SwingComponents allComponents = new SwingComponents();
    private MainData allData = new MainData();
    private InitialPanel mainPanel = new InitialPanel(allComponents,allData,this);

    public MainWindow (){
        setTitle("Ferre-Plus");
        super.setSize(new Dimension(800,600));
        super.setMinimumSize(new Dimension(800,600));
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(mainPanel);
        super.setVisible(true);
    }


}
