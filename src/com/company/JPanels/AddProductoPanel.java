package com.company.JPanels;

import com.company.MainData;
import com.company.SwingComponents;
import jdk.nashorn.internal.scripts.JO;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class AddProductoPanel extends JPanel {

    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill]","[][][][][][]"
    );
    private JPanel thisComp;
    public AddProductoPanel(SwingComponents allC, MainData allD){
        thisComp=this;
        allComponents=allC;
        allData=allD;
        setLayout(layout);
        layoutConfig ();
        configEvents ();
        dataBaseInitialConfig ();
    }
    private void dataBaseInitialConfig (){
        try {
            ArrayList<String> nombreSecciones = new ArrayList<>();
            ResultSet resultadoConsulta = allData.getMainStatementDB().executeQuery("SELECT NombreSeccion FROM seccion");

            while (resultadoConsulta.next()){
                nombreSecciones.add(resultadoConsulta.getString(1));
            }
            allComponents.getSeccionAddProductCombobox().setModel(new DefaultComboBoxModel(nombreSecciones.toArray()));
            AutoCompleteDecorator.decorate(allComponents.getSeccionAddProductCombobox());
        }catch (Exception e){
            JOptionPane.showMessageDialog(thisComp,"ERROR EN LA BASE DE DATOS: "+e.getMessage());
        }
    }
    private void layoutConfig(){
        add (allComponents.getAddProductLogo (),"span 2, align center, wrap");
        add(allComponents.getNombreAddProductLabel (),"align left");
        add (allComponents.getNombreAddProductTextField (),"wrap");
        add (allComponents.getCodeInternoLabel (),"align left");
        add (allComponents.getCodigointernoTextField (),"wrap");
        add (allComponents.getCategory ());
        add (allComponents.getSeccionAddProductCombobox (),"wrap");
        add (allComponents.getPrecProveLabel ());
        add (allComponents.getPrecioProvAddProductTextField (),"wrap");
        add (allComponents.getPriceUnit ());
        add (allComponents.getPrecioVentaAddProductTextField (),"wrap");
        add (allComponents.getDescripcionLabel ());
        add (allComponents.getDescripcionTextField (),"wrap");
        add (allComponents.getAceptarAddProductButton (),"span 2, align center");
    }
    private boolean isValidated (){
        if (allComponents.getNombreAddProductTextField().getText().compareTo("")!=0){
            if (allComponents.getCodigointernoTextField().getText().compareTo("")!=0){
                if (allComponents.getPrecioVentaAddProductTextField().getText().compareTo("")!=0){
                    if (allComponents.getPrecioProvAddProductTextField().getText().compareTo("")!=0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private int getCategoria (String aux){
         try{
             ResultSet idResult=allData.getMainStatementDB().executeQuery("SELECT IDSeccion FROM seccion WHERE NombreSeccion='"+aux+"'");
             idResult.next();
             return Integer.parseInt(idResult.getString(1));
         } catch (Exception throwables) {
             JOptionPane.showMessageDialog(thisComp,"ERROR: "+throwables.getMessage());
         }
         return 0;
    }
    private void validateNumbers (String dobleX,String dobleY)throws Exception {
        try {
            Double y1=Double.parseDouble(dobleX);
            y1=Double.parseDouble(dobleY);
        }catch (Exception exc){
            throw new Exception("Ingrese solamente numeros en los campos de precio.");
        }

    }
    private void configEvents(){
        allComponents.getAceptarAddProductButton().addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String nombre, codInter,idCateg,precProv,precVent,descr;
                if (isValidated()){
                    nombre=allComponents.getNombreAddProductTextField().getText();
                    codInter=allComponents.getCodigointernoTextField().getText();
                    idCateg=String.valueOf(getCategoria((String)allComponents.getSeccionAddProductCombobox().getSelectedItem()));
                    precProv=allComponents.getPrecioProvAddProductTextField().getText();
                    precVent=allComponents.getPrecioVentaAddProductTextField().getText();
                    descr=allComponents.getDescripcionTextField().getText();
                    try {
                        validateNumbers(precProv,precVent);
                        allData.getMainStatementDB().executeUpdate("INSERT INTO productos VALUES (DEFAULT,'"+nombre+"','"+codInter+"',DEFAULT,"+idCateg+","+precProv+","+precVent+",'"+descr+"')");
                        allData.actualizarArrayProductos();
                        allComponents.getNombreAddProductTextField().setText("");
                        allComponents.getCodigointernoTextField().setText("");
                        allComponents.getPrecioProvAddProductTextField().setText("");
                        allComponents.getPrecioVentaAddProductTextField().setText("");
                        allComponents.getDescripcionTextField().setText("");
                    } catch (Exception throwables) {
                        JOptionPane.showMessageDialog(thisComp,"ERROR AL INGRESAR PRODUCTO: "+throwables.getMessage());
                    }

                }else {
                    JOptionPane.showMessageDialog(thisComp,"ERROR, VERIFIQUE LOS DATOS E INTENTE NUEVAMENTE");
                }
            }
        });
    }
}
