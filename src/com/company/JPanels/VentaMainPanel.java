package com.company.JPanels;

import com.company.MainData;
import com.company.JFrames.MainWindow;
import com.company.ProductTableModel;
import com.company.SwingComponents;
import com.company.TableRegister;
import com.mysql.cj.xdevapi.Table;
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
            "debug,fillx,filly","[][shrink,grow,fill][][]","-25[top,fill]-40[][][][]-25[]-35[fill]-15"
    );
    private JFrame parentFrame;
    private ArrayList <TableRegister> datosTabla= new ArrayList<>();
    private ProductTableModel modeloTabla=new ProductTableModel(datosTabla);

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

    private void verificarExistencia (String idProd,String cantidad)throws Exception{
        int acumuCant=0,cantAux=0;
        boolean existOnTable=false;
        ResultSet res = allData.getMainStatementDB().executeQuery("SELECT Cantidad FROM inventario WHERE IDProducto="+idProd);
        //SUMAR TODOS LOS PRODUCTOS EXISTENTES
        while (res.next()){
            acumuCant=acumuCant+Integer.parseInt(res.getString(1));
        }
        for (TableRegister auxProd:datosTabla){
            if (auxProd.getIdProd().compareTo(idProd)==0){
                existOnTable=true;
                cantAux=auxProd.getCantidad();
            }
        }
        acumuCant=acumuCant-cantAux;//OBTENEMOS LOS PRODUCTOS TOTALES -> SE RESTA LOS PRODUCTOS YA AÑADIDOS A LA TABLA AL TOTAL DE PRODUCTOS EN EL INVENTARIO
        if (acumuCant>=Integer.parseInt(cantidad)){//SI HAY EXISTENCIA
            if (existOnTable){//SI EXISTE SOLO INCREMENTAMOS LA CANTIDAD EN datosTabla Y ACTUALIZAMOS COSTO TOTAL
                for (TableRegister auxData:datosTabla){
                    if (auxData.getIdProd().compareTo(idProd)==0){
                        auxData.setCantidad(auxData.getCantidad()+Integer.parseInt(cantidad));
                        auxData.setPrecioTotal(auxData.getCantidad()*auxData.getPrecioUnit());
                    }
                }
            }else{// SI NO, CREAMOS UN NUEVO REGISTRO EN DATOS TABLA
                String nombre=(String)allComponents.getProductoVentaCombobox().getSelectedItem();
                ResultSet resPrecUnit = allData.getMainStatementDB().executeQuery("SELECT PrecioVenta FROM productos WHERE IDProducto="+idProd);
                resPrecUnit.next();
                String precioUnit=resPrecUnit.getString(1);
                Double precioTotal=Double.parseDouble(precioUnit)*Double.parseDouble(cantidad);
                datosTabla.add(new TableRegister(idProd,nombre,Integer.parseInt(cantidad),Double.parseDouble(precioUnit),precioTotal));
            }
        }else {
            throw new Exception("No hay suficientes productos!, Cantidad en inventario: "+acumuCant);
        }
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
        allComponents.getAddVentaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddProductoPanel.validateNumbers("5.0",allComponents.getCantVentaTextField().getText());
                    verificarExistencia(MainData.getIDProducto((String)allComponents.getProductoVentaCombobox().getSelectedItem(),allData.getMainStatementDB()),allComponents.getCantVentaTextField().getText());
                    modeloTabla.fireTableDataChanged();
                }catch (Exception x){
                    JOptionPane.showMessageDialog(thisComp,"ERROR AL AGREGAR PRODUCTO: "+x.getMessage());
                }
                allComponents.getCantVentaTextField().setText("");
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
        allComponents.getVentTable().setModel(modeloTabla);
       add (allComponents.getContenedorTabla(), ",align center, width 650!,height 420!,span 2 2");
       add (allComponents.getLimpiarVentaBoton (),"align center,span 2 ,wrap");
     //   add (new JLabel (""),"wrap");
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
