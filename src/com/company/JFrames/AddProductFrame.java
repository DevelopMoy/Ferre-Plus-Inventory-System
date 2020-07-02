package com.company.JFrames;

import com.company.JPanels.AddInventoryPanel;
import com.company.JPanels.AddProductoPanel;
import com.company.MainData;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class AddProductFrame extends JFrame {
    private AddInventoryPanel mainPanel;
    private MainData allData;
    private JFrame superComp;

    public AddProductFrame(SwingComponents allC, MainData allD){
        allData=allD;
        superComp=this;
        super.setSize(new Dimension (600,450));
        super.setResizable (false);
        super.setTitle("Ferre-plus: Add-Product");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.add(new AddProductoPanel(allC,allData));
        super.setVisible(true);
    }

}
