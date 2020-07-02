package com.company.JFrames;

import com.company.MainData;
import com.company.JPanels.SearchCompraPanel;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class SearchCompraFrame extends JFrame {
    private SearchCompraPanel mainPanel;
    private MainData allData;

    public SearchCompraFrame(SwingComponents allC, MainData allD){
        allData=allD;
       // this.addWindowListener(new AddProductFrame.WindowEvents (this));
        super.setSize(new Dimension (500,450));
        super.setResizable (false);
        super.setTitle("Search");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.add(new SearchCompraPanel (allC,allData,this));
        super.setVisible(true);
    }

}
