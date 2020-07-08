package com.company.JPanels;

import com.company.MainData;
import com.company.SearchTableAbstractModel;
import com.company.SearchTableRegister;
import com.company.SwingComponents;
import jdk.nashorn.internal.scripts.JO;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchCompraPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private MigLayout layout = new MigLayout(
            "fillx,filly","[][shrink,grow,fill][]","[][][][][]"
    );
    private JFrame parentFrame;
    private JPanel thisComp=this;
    private ArrayList<SearchTableRegister> tableData=new ArrayList<>();
    private SearchTableAbstractModel modeloTabla=new SearchTableAbstractModel(tableData);

    public SearchCompraPanel(SwingComponents allC, MainData allD,JFrame parentFrame){
        this.parentFrame=parentFrame;
        setLayout (layout);
        allComponents=allC;
        allData=allD;
        layoutConfig ();
        configEvents ();
    }
    private void busquedaPorNombre (String criterio){
        ArrayList<String> nombresEnBD = new ArrayList<>();
        try {
            ResultSet nombresRS = allData.getMainStatementDB().executeQuery("SELECT NombreProducto FROM productos");
            while (nombresRS.next()){
                nombresEnBD.add(nombresRS.getString(1));
            }
            for (String auxBusq:nombresEnBD){
                if(auxBusq.toUpperCase().contains(criterio.toUpperCase())){//llenar tabla con todas las coincidencias
                    ResultSet resultAux = allData.getMainStatementDB().executeQuery("SELECT productos.IDProducto,productos.NombreProducto,productos.CodigoInterno,seccion.NombreSeccion,productos.Descripcion FROM productos INNER JOIN seccion ON productos.IDSeccion=seccion.IDSeccion WHERE productos.NombreProducto='"+auxBusq+"'");
                    while(resultAux.next()){
                        tableData.add(new SearchTableRegister(Integer.parseInt(resultAux.getString(1)),resultAux.getString(2),resultAux.getString(3),resultAux.getString(4),resultAux.getString(5)));
                    }
                }
            }
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(thisComp,"Error al buscar: "+throwables.getMessage());
        }
    }

    private void busquedaPorCodigo (String criterio){

    }

    private void layoutConfig(){
        add (allComponents.getSearchTitle (),"span 2,align center, wrap");
        add (allComponents.getTitulosSearch ());
        add (allComponents.getNombreSearchCompraTextField (),"split 2");
        add (allComponents.getSearchButtonSearchCompraPanel (),"width 35!,height 35!,wrap");
        allComponents.getTablaNuevaSearch().setModel(modeloTabla);
        add (allComponents.getContenedorNuevoSearch(),"width 680!,span  2 2 ,wrap");
        add (new JLabel (""),"wrap,wrap");
        add (allComponents.getGoHomeSearchPanel ());
        add (allComponents.getAceptarButtonSearchCompraPanel ()," align center");
    }
    private void configEvents(){
        allComponents.getSearchButtonSearchCompraPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableData.clear();
                try{
                    String filtroBusqueda = (String)allComponents.getTitulosSearch().getSelectedItem();
                    String datoBusqueda=allComponents.getNombreSearchCompraTextField().getText();
                    if (datoBusqueda.compareTo("")==0){
                        throw new Exception("Campo de busqueda vacio");
                    }
                    if (filtroBusqueda.compareTo("Nombre")==0){
                        busquedaPorNombre(datoBusqueda);
                    }else {
                        if (filtroBusqueda.compareTo("Codigo")==0){
                            busquedaPorCodigo(datoBusqueda);
                        }
                    }
                    modeloTabla.fireTableDataChanged();
                }catch (Exception exc){
                    JOptionPane.showMessageDialog(thisComp,"Error en la busqueda: "+exc.getMessage() );
                }

            }
        });
        allComponents.getAceptarButtonSearchCompraPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
            }
        });
    }


}
