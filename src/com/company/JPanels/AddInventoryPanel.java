package com.company.JPanels;

import com.company.JFrames.AddProductFrame;
import com.company.JFrames.SearchCompraFrame;
import com.company.MainData;
import com.company.JFrames.MainWindow;
import com.company.SwingComponents;
import jdk.nashorn.internal.scripts.JO;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddInventoryPanel extends JPanel {
    private final String cellSize = "width 150!,height 140!";
    private SwingComponents allComponents;
    private MainData allData;
    private JFrame parentFrame;
    private JPanel thisComp;

    private MigLayout layout = new MigLayout(
            "fillx,filly","27[][shrink,grow,fill]15[left][fill]","[]-130[]-190[]-125[]-125[]-150[]-125[]-125[]"
    );

    public AddInventoryPanel(SwingComponents allC, MainData allD, JFrame parentFrame){
        thisComp=this;
        this.parentFrame=parentFrame;
        allComponents=allC;
        allData=allD;
        setLayout(layout);
        layoutConfig ();
        configEvents ();
        actualizarComboBoxSeccion();
        actualizarComboBoxProveedor();
        actualizarTextFieldPrecios();
    }

    private void actualizarTextFieldPrecios(){
        String nombreProd=(String)allComponents.getProductosComboBox().getSelectedItem();
        String precioProv="",precioVent="";
        try {
            ResultSet res = allData.getMainStatementDB().executeQuery("SELECT PrecioProveedor,PrecioVenta FROM productos WHERE NombreProducto='"+nombreProd+"'");
            while(res.next()){
                precioProv=res.getString(1);
                precioVent=res.getString(2);
            }
            allComponents.getPriceProveedorTextField().setText(precioProv);
            allComponents.getPriceUnitTextField().setText(precioVent);
        }catch (Exception e){
            JOptionPane.showMessageDialog(thisComp,"ERROR AL ACTUALIZAR PRECIOS: "+e.getMessage());
        }
    }

    private void actualizarComboBoxSeccion(){
        String nombreProducto=(String)allComponents.getProductosComboBox().getSelectedItem();
        String idProducto="",nombreSeccion="";
        try {
            ResultSet result = allData.getMainStatementDB().executeQuery("SELECT IDProducto FROM productos WHERE NombreProducto='"+nombreProducto+"'");
            while (result.next()){
                idProducto=result.getString(1);
            }
            result=allData.getMainStatementDB().executeQuery("SELECT NombreSeccion FROM seccion INNER JOIN productos ON seccion.IDSeccion=productos.IDSeccion WHERE productos.IDProducto="+idProducto);
            while (result.next()){
                nombreSeccion=result.getString(1);
            }
            String [] auxiliar ={nombreSeccion};
            allComponents.getCategoryComboBox().setModel(new DefaultComboBoxModel(auxiliar));
        } catch (Exception throwables) {
            JOptionPane.showMessageDialog(thisComp,"ERROR AL ACTUALIZA COMBOBOX SECCION: "+throwables.getMessage());
        }
    }

    private void actualizarComboBoxProveedor (){
        ArrayList<String> nombreProveedores=new ArrayList<>();
        try {
            ResultSet resultado=allData.getMainStatementDB().executeQuery("SELECT EMPRESA FROM proveedor");
            while(resultado.next()){
                nombreProveedores.add(resultado.getString(1));
            }
            allComponents.getProvidersComboBox().setModel(new DefaultComboBoxModel(nombreProveedores.toArray()));
        }catch (Exception e){
            JOptionPane.showMessageDialog(thisComp,"ERROR AL ACTUALIZAR PROVEEDORES: "+e.getMessage());
        }
    }

    private String getIdProveedorPorEmpresa (String NombreEmpresa) throws SQLException {
        ResultSet res= allData.getMainStatementDB().executeQuery("SELECT IDProveedor FROM proveedor WHERE EMPRESA='"+NombreEmpresa+"'");
        res.next();
        return res.getString(1);
    }

    private void subirInventarioABaseDatos(){
        String nombreProducto,precioVent,precioProv;
        nombreProducto=(String)allComponents.getProductosComboBox().getSelectedItem();
        precioProv=(String)allComponents.getPriceProveedorTextField().getText();
        precioVent=(String)allComponents.getPriceUnitTextField().getText();
        try {
            AddProductoPanel.validateNumbers("5.6",allComponents.getAmountTextField().getText());
            //SI EXISTE EN EL INVENTARIO, INCREMENTAR LA CANTIDAD
            String ammount=allComponents.getAmountTextField().getText();
            if(MainData.existeEnInventario(MainData.getIDProducto(nombreProducto,allData.getMainStatementDB()),getIdProveedorPorEmpresa((String)allComponents.getProvidersComboBox().getSelectedItem()),allData.getMainStatementDB())){
                allData.getMainStatementDB().executeUpdate("UPDATE inventario SET Cantidad=Cantidad+"+ammount+" WHERE IDProducto='"+MainData.getIDProducto(nombreProducto,allData.getMainStatementDB())+"' AND IDProveedor='"+getIdProveedorPorEmpresa((String)allComponents.getProvidersComboBox().getSelectedItem())+"'");
            }else {// SI NO, SE CREA UN NUEVO REGISTRO EN INVENTARIO
                allData.getMainStatementDB().executeUpdate("INSERT INTO inventario VALUES("+MainData.getIDProducto(nombreProducto,allData.getMainStatementDB())+","+ammount+","+getIdProveedorPorEmpresa((String)allComponents.getProvidersComboBox().getSelectedItem())+")");
            }
            allComponents.getAmountTextField().setText("");
        }catch (Exception e){
            JOptionPane.showMessageDialog(thisComp,"ERROR AL SUBIR INVENTARIO: "+e.getMessage());
        }
    }

    private void configEvents() {
        allComponents.getPlusLogo ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddProductFrame(allComponents, allData);
            }
        });
        allComponents.getSearchLogo ().addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchCompraFrame(allComponents,allData);
            }
        });
        allComponents.getGoHomeButtonInventory().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                new MainWindow();
            }
        });
        allComponents.getProductosComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarComboBoxSeccion();
                actualizarTextFieldPrecios();
            }
        });
        allComponents.getSubmmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// AÑADIR PRODUCTOS AL INVENTARIO
                subirInventarioABaseDatos ();
            }
        });
    }

    public void layoutConfig (){
        AutoCompleteDecorator.decorate( allComponents.getProductosComboBox());
        AutoCompleteDecorator.decorate(allComponents.getProvidersComboBox());
        allComponents.getPriceUnitTextField().setEnabled(false);
        allComponents.getPriceProveedorTextField().setEnabled(false);
        add(new JLabel(""),cellSize);
        add(allComponents.getAddLogo (),"span 2");
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getProduct ());
        try {
            allData.actualizarArrayProductos();
        } catch (Exception throwables) {
            JOptionPane.showMessageDialog(this,"ERROR AL ACTUALIZAR COMBOBOX "+throwables.getMessage());
        }
        allComponents.getProductosComboBox().setModel(new DefaultComboBoxModel(allData.getNombreProductosParaCBox().toArray()));
        add(allComponents.getProductosComboBox (),"align left");
            add(allComponents.getPlusLogo (),"width 35!,height 35!,split 3");
        add (allComponents.getSearchLogo (),"width 35!,height 35!, align left");
        add (allComponents.getCantidad (),"align center");
        add (allComponents.getAmountTextField ());
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getCategory ());
        add (allComponents.getCategoryComboBox());
        add (allComponents.getPriceUnit (),"align center");
        add (allComponents.getPriceUnitTextField ());
        add (new JLabel(""),cellSize+",wrap");
        add (allComponents.getProvider ());
        add (allComponents.getProvidersComboBox());
        add (allComponents.getPrecProveLabel ());
        add (allComponents.getPriceProveedorTextField (),"wrap");
        add(allComponents.getGoHomeButtonInventory(),"width 58!,height 58!, align left,growx");
        add (allComponents.getSubmmitButton (),"width 280!,height 80!,span 2,align center");
        add (new JLabel(""),cellSize);
    }
}
