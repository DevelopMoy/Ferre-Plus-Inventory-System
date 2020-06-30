package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddProductFrame extends JFrame {
    private AddInventoryPanel mainPanel;
    private MainData allData;

    public AddProductFrame(SwingComponents allC,MainData allD){
        allData=allD;
        this.addWindowListener(new AddProductFrame.WindowEvents (this));
        super.setSize(new Dimension (600,450));
        super.setResizable (false);
        super.setTitle("Ferre-plus: Add-Product");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.add(new AddProductoPanel (allC,allData));
        super.setVisible(true);
    }

    private class WindowEvents extends WindowAdapter {
        private JFrame superComp;
        public WindowEvents (JFrame e){
            superComp=e;
        }
        @Override
        public void windowClosing (WindowEvent e){
            allData.setCanClose(true);
        }
    }
}
