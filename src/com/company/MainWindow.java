package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private SwingComponents allComponents = new SwingComponents();
    private MainData allData = new MainData();
    private InitialPanel mainPanel = new InitialPanel(allComponents,allData);

    public MainWindow (){
        setTitle("Ferre-Plus");
        addWindowListener(new WindowEvents(this));
        super.setSize(new Dimension(800,600));
        super.setMinimumSize(new Dimension(800,600));
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        add(mainPanel);
        super.setVisible(true);
    }

    private class WindowEvents extends WindowAdapter {
        private JFrame superComp;
        public WindowEvents (JFrame e){
            superComp=e;
        }
        @Override
        public void windowClosing (WindowEvent e){
            if (allData.isCanClose()){
                superComp.dispose();
            }
        }
    }

}
