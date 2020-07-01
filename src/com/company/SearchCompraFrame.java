package com.company;

import javax.swing.*;
import java.awt.*;

public class SearchCompraFrame extends JFrame {
    private SearchCompraPanel mainPanel;
    private MainData allData;

    public SearchCompraFrame(SwingComponents allC,MainData allD){
        allData=allD;
       // this.addWindowListener(new AddProductFrame.WindowEvents (this));
        super.setSize(new Dimension (500,450));
        super.setResizable (false);
        super.setTitle("Search");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.add(new SearchCompraPanel (allC,allData));
        super.setVisible(true);
    }

}
