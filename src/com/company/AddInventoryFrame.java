package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddInventoryFrame extends JFrame {
    private AddInventoryPanel mainPanel;
    private MainData allData;

    public AddInventoryFrame(SwingComponents allC,MainData allD){
        allData=allD;
        mainPanel=new AddInventoryPanel(allC,allD,this);
        super.setSize(new Dimension(800,600));
        super.setMinimumSize(new Dimension(800,600));
        super.setTitle("Ferre-plus: Add-Mode");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(mainPanel);
        super.setVisible(true);
    }
}
