package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddProductFrame extends JFrame {
    private AddInventoryPanel mainPanel;
    private MainData allData;
    private JFrame superComp;

    public AddProductFrame(SwingComponents allC,MainData allD){
        allData=allD;
        superComp=this;
        super.setSize(new Dimension (600,450));
        super.setResizable (false);
        super.setTitle("Ferre-plus: Add-Product");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.add(new AddProductoPanel (allC,allData));
        super.setVisible(true);
    }

}
