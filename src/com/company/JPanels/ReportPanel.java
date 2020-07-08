package com.company.JPanels;

import com.company.*;
import com.company.JFrames.MainWindow;
import jdk.nashorn.internal.scripts.JO;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private JPanel thisComp;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][][]","[][][][]"
    );
    private JFrame parentFrame;
    private ArrayList <ReportTableRegister> datosTabla=new ArrayList<>();
    private ReportTableModel modeloTabla = new ReportTableModel(datosTabla);

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

    private void configLayout(){
        add(allComponents.getReportTitleLabel (),"span 2, align left");
        add (new JLabel (""),"wrap");
        allComponents.getReportTable().setModel(modeloTabla);
        add(allComponents.getContenedorReportTable (),"span 2 2,width 550!,height 420!");
        add(allComponents.getGenerarReporteBoton (),"width 180!,height 50! , wrap," );
        add(allComponents.getImprimirReporteBoton (),"wrap");
        add (allComponents.getGoHomeReportPanel (),"span 2, align center");

    }

    private void actualizarTabla(){
        try {
            ResultSet res= allData.getMainStatementDB().executeQuery("SELECT registro_ventas.NumeroPedido, productos.NombreProducto,registro_ventas.FechaTransacc,registro_ventas.MontoVentaTotal,registro_ventas.CantidadProductos,registro_ventas.IDProveedor FROM registro_ventas INNER JOIN productos ON registro_ventas.IDProducto=productos.IDProducto");
            while(res.next()){
                datosTabla.add(new ReportTableRegister(Integer.parseInt(res.getString(1)),res.getString(2),res.getString(3),Double.parseDouble(res.getString(4)),Integer.parseInt(res.getString(5)),Integer.parseInt(res.getString(6))));
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(thisComp,throwables.getMessage());
        }
    }

    private void configEvents(){
        allComponents.getGenerarReporteBoton ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                datosTabla.clear();
                actualizarTabla();
                modeloTabla.fireTableDataChanged();
            }
        });
        allComponents.getImprimirReporteBoton ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!datosTabla.isEmpty()){
                    try {
                        allComponents.getReportTable().print();
                    } catch (PrinterException printerException) {
                        JOptionPane.showMessageDialog(thisComp,"Error al imprimir");
                    }
                }else {
                    JOptionPane.showMessageDialog(thisComp,"Es necesario generar el reporte antes de imprimir.");
                }
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
