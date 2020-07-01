package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentaMainFrame extends JFrame {
    private SearchCompraPanel mainPanel;
    private MainData allData;

    public VentaMainFrame(SwingComponents allC,MainData allD){
        allData=allD;
        // this.addWindowListener(new AddProductFrame.WindowEvents (this));
        super.setSize(new Dimension(800,600));
        super.setMinimumSize(new Dimension(800,600));
        super.setTitle("Venta - Mode ");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.add(new VentaMainPanel (allC,allData,this));
        super.setVisible(true);
    }

}
