package com.company.JPanels;

import com.company.MainData;
import com.company.JFrames.MainWindow;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VentaMainPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private JPanel thisComp;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill][][]","-35[top,fill]-40[][][][][]-50[fill]-15"
    );
    private JFrame parentFrame;

    public  VentaMainPanel(SwingComponents allC, MainData allD,JFrame parentFrame){
        thisComp=this;
        this.parentFrame=parentFrame;
        setLayout (layout);
        allComponents=allC;
        allData=allD;
        actualizarProductosCB();
        layoutConfig ();
        configEvents ();

    }

    private void verificarExistencia (String idProd)throws Exception{

    }

    private void actualizarProductosCB (){
        ArrayList <String> productosExistentes =new ArrayList<>();
        try {
            ResultSet datosBD=allData.getMainStatementDB().executeQuery("SELECT DISTINCT NombreProducto FROM productos WHERE IDProducto IN (SELECT IDProducto FROM inventario WHERE Cantidad>0)");
            while(datosBD.next()){
                productosExistentes.add(datosBD.getString(1));
            }
            allComponents.getProductoVentaCombobox().setModel(new DefaultComboBoxModel(productosExistentes.toArray()));
        }catch (Exception er){
            JOptionPane.showMessageDialog(thisComp,"ERROR AL ACTUALIZAR COMBO BOX: "+er.getMessage());
        }
    }

    public void configEvents (){
        allComponents.getGoHomeButtonVenta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                new MainWindow();
            }
        });
    }
    public void layoutConfig(){
        add (allComponents.getSellModeLogo (), "align center,span 4, wrap");
       add(allComponents.getProduct ());
        AutoCompleteDecorator.decorate(allComponents.getProductoVentaCombobox());
       add(allComponents.getProductoVentaCombobox (),"split 3");
       add(allComponents.getSearchVentaButton (),"width 35!,height 35!");
       add (allComponents.getAddVentaButton (),"width 35!,height 35!");
       add (allComponents.getCantidad ());
       add (allComponents.getCantVentaTextField (),"width 80!,height 30!,wrap");
      //  add (new JLabel (""),"wrap");
       add (allComponents.getContenedorTabla(), "span 2 3");
       add (allComponents.getLimpiarVentaBoton (),"align center,span 2 2 ,wrap");
        add (new JLabel (""),"wrap");
       add (allComponents.getQuitarVentanaBoton (),"align center, span 2 ,wrap");
       //add (new JLabel (""),"wrap");
       add (new JLabel (""),"width 80!,height 30!, split 2");
       add (allComponents.getContVentaLabel (),"width 80!,height 30!");
       allComponents.getContVentaTextField().setEnabled(false);
       add (allComponents.getContVentaTextField (),"split 3");
       add (allComponents.getTotalVentaLabel (),"width 50!,height 30!,");
       allComponents.getTotalVentaTextField().setEnabled(false);
       add (allComponents.getTotalVentaTextField ());
       add(allComponents.getGoHomeButtonVenta (),"span 2, align center,wrap");
       add (allComponents.getTerminarVentaBoton (),"width 300!,height 80!,span ,align center");
    }

}
