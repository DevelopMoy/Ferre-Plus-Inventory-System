package com.company.JFrames;

import com.company.JPanels.InitialPanel;
import com.company.MainData;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

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
