package com.company.JPanels;

import com.company.JFrames.MainWindow;
import com.company.MainData;
import com.company.ProductTableModel;
import com.company.SwingComponents;
import com.company.TableRegister;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReportPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private JPanel thisComp;
    private MigLayout layout = new MigLayout(
            "debug,fillx,filly","[][][]","[][][][]"
    );
    public ReportPanel (SwingComponents allC, MainData allD, JFrame parentFrame){
        this.parentFrame=parentFrame;
        setLayout (layout);
        allComponents=allC;
        allData=allD;
        thisComp=this;
        //actualizarProductosCB();
        configLayout();
        configEvents ();
    }
    private JFrame parentFrame;
    private ArrayList<TableRegister> datosTabla= new ArrayList<>();
    private ProductTableModel modeloTabla=new ProductTableModel(datosTabla);
    private void configLayout(){
    add(allComponents.getReportTitleLabel (),"span 2, align left");
    add (new JLabel (""),"wrap");
        add(allComponents.getReportTable (),"span 2 2,width 550!,height 420!");
        add(allComponents.getGenerarReporteBoton (),"width 180!,height 50! , wrap," );
        add(allComponents.getImprimirReporteBoton (),"wrap");
        add (allComponents.getGoHomeReportPanel (),"span 2, align center");

    }
    private void configEvents(){
        allComponents.getGenerarReporteBoton ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        allComponents.getImprimirReporteBoton ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        allComponents.getGoHomeReportPanel ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                new MainWindow ();
            }
        });
    }

}
