package com.company;

import javax.swing.*;
import java.awt.*;

public class AddInventoryFrame extends JFrame {
    private AddInventoryPanel mainPanel;

    public AddInventoryFrame(SwingComponents allC,MainData allD){
        mainPanel=new AddInventoryPanel(allC,allD);
        super.setSize(new Dimension(800,600));
        super.setMinimumSize(new Dimension(800,600));
        super.setTitle("Ferre-plus: Add-Mode");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(mainPanel);
        super.setVisible(true);
    }
}
