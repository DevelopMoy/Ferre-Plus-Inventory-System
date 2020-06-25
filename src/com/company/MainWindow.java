package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private SwingComponents allComponents = new SwingComponents();
    private MainData allData = new MainData();
    private InitialPanel mainPanel = new InitialPanel(allComponents,allData);

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
