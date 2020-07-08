package com.company.JFrames;

import com.company.JPanels.ReportPanel;
import com.company.JPanels.SearchCompraPanel;
import com.company.JPanels.VentaMainPanel;
import com.company.MainData;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class ReportFrame extends JFrame {
    private SearchCompraPanel mainPanel;
    private MainData allData;

    public ReportFrame(SwingComponents allC, MainData allD){
        allData=allD;
        // this.addWindowListener(new AddProductFrame.WindowEvents (this));
        super.setSize(new Dimension (760,800));
        super.setMinimumSize(new Dimension(760,800));
        super.setTitle("Report- Mode ");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.add(new ReportPanel (allC,allData,this));
        super.setVisible(true);
    }
}
