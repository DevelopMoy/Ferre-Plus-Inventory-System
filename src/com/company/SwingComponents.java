package com.company;

import javax.swing.*;
import java.awt.*;

//This class will contain all the components used by the GUI
public class SwingComponents {
    //InitialPanel Components
    private JButton addModeButton=new JButton(new ImageIcon("images/arrowUp.png"));
    private JButton sellModeButton= new JButton(new ImageIcon("images/arrowDown.png"));
    private JLabel mainLogo = new JLabel(new ImageIcon("images/mainLogo.png"));
    private JButton initSettingsButton = new JButton(new ImageIcon("images/settBot.png"));
    private JLabel addLabel = new JLabel("Add Mode");
    private JLabel sellLabel = new JLabel("Sell Mode");
    // ------------------------------------------------------------------
    //AddInventoryPanel Components
    private JButton submmitButton = new JButton (new ImageIcon ("images/submitButton.png"));
    private JLabel addLogo = new JLabel(new ImageIcon("images/addLogo.png"));
    private JLabel product = new JLabel ("Producto: ");
    private JLabel category = new JLabel ("Categoría: ");
    private JLabel priceUnit = new JLabel ("Precio Venta: ");
    private JLabel provider = new JLabel ("Proveedor: ");
    private JLabel cantidad = new JLabel ("Cantidad: ");
    private JLabel precProveLabel = new JLabel ("Precio Proveedor: ");
    private JComboBox productosComboBox = new JComboBox ();
    private JComboBox categoryComboBox = new JComboBox ();
    private JComboBox providersComboBox = new JComboBox ();
    private JTextField priceUnitTextField = new JTextField ();
    private JTextField amountTextField = new JTextField ();
    private JTextField priceProveedorTextField = new JTextField ();
    private JButton plusLogo = new JButton (new ImageIcon ("images/plusLogo.png"));
    private JButton searchLogo = new JButton (new ImageIcon ("images/searchLogo.png"));
    private JButton goHomeButtonInventory = new JButton("GO HOME");
    //ADDPRODUCTFRAME COMPONENTS
    private JLabel addProductLogo = new JLabel (new ImageIcon ("images/addProductLogo.png"));
    private JLabel nombreAddProductLabel = new JLabel ("Nombre:");
    private JLabel codeInternoLabel = new JLabel ("Código Interno: ");
    private JLabel descripcionLabel = new JLabel ("Descripción");
    private JTextField nombreAddProductTextField = new JTextField ();
    private JTextField codigointernoTextField = new JTextField ();
    private JComboBox seccionAddProductCombobox = new JComboBox ();
    private JTextField precioProvAddProductTextField = new JTextField ();
    private JTextField precioVentaAddProductTextField = new JTextField ();
    private JTextField descripcionTextField = new JTextField ();
    private JButton aceptarAddProductButton = new JButton (new ImageIcon ("images/aceptarAdd.png"));
    private JButton cancelarAddProductButton = new JButton ("Cancelar");


    //SerachCompraPanel
    private JTextField nombreSearchCompraTextField = new JTextField ();
    private JButton searchButtonSearchCompraPanel = new JButton (new ImageIcon ("images/searchLogo.png"));
    private JTable searchCompraJTable = new JTable ();
    private JButton aceptarButtonSearchCompraPanel = new JButton (new ImageIcon ("images/aceptarAdd.png"));

    //VentaPanelComponents
    private JComboBox productoVentaCombobox = new JComboBox ();
    private JButton searchVentaButton = new JButton (new ImageIcon ("images/searchLogo.png"));
    private JButton addVentaButton = new JButton (new ImageIcon ("images/addProductLogo.png"));
    private JButton goHomeButtonVenta = new JButton("GO HOME");
    private JTextField cantVentaTextField = new JTextField ();
    private JTable ventTable = new JTable ();
    private JButton limpiarVentaBoton = new JButton ("Limpiar");
    private JButton ventaFinalBoton = new JButton ("Venta");
    private JLabel contVentaLabel = new JLabel ("Productos: ");
    private JTextField contVentaTextField = new JTextField ();
    private JLabel totalVentaLabel = new JLabel ("Total: ");
    private JTextField totalVentaTextField = new JTextField ();

    public JButton getGoHomeButtonInventory() {
        return goHomeButtonInventory;
    }

    public JComboBox getProductoVentaCombobox() {
        return productoVentaCombobox;
    }

    public JButton getSearchVentaButton() {
        return searchVentaButton;
    }

    public JButton getAddVentaButton() {
        return addVentaButton;
    }

    public JTextField getCantVentaTextField() {
        return cantVentaTextField;
    }

    public JTable getVentTable() {
        return ventTable;
    }

    public JButton getLimpiarVentaBoton() {
        return limpiarVentaBoton;
    }

    public JButton getVentaFinalBoton() {
        return ventaFinalBoton;
    }

    public JLabel getContVentaLabel() {
        return contVentaLabel;
    }

    public JTextField getContVentaTextField() {
        return contVentaTextField;
    }

    public JLabel getTotalVentaLabel() {
        return totalVentaLabel;
    }

    public JTextField getTotalVentaTextField() {
        return totalVentaTextField;
    }

    public JTextField getNombreSearchCompraTextField() {
        return nombreSearchCompraTextField;
    }

    public JButton getSearchButtonSearchCompraPanel() {
        return searchButtonSearchCompraPanel;
    }

    public JTable getSearchCompraJTable() {
        return searchCompraJTable;
    }

    public JButton getAceptarButtonSearchCompraPanel() {
        return aceptarButtonSearchCompraPanel;
    }

    public JButton getAceptarAddProductButton() {        return aceptarAddProductButton; }

    public JButton getCancelarAddProductButton() {        return cancelarAddProductButton; }

    public JLabel getAddProductLogo() {        return addProductLogo; }

    public JLabel getNombreAddProductLabel() {
        return nombreAddProductLabel;
    }

    public JLabel getCodeInternoLabel() {
        return codeInternoLabel;
    }

    public JLabel getDescripcionLabel() {
        return descripcionLabel;
    }

    public JTextField getNombreAddProductTextField() {
        return nombreAddProductTextField;
    }

    public JTextField getCodigointernoTextField() {
        return codigointernoTextField;
    }

    public JComboBox getSeccionAddProductCombobox() {
        return seccionAddProductCombobox;
    }

    public JTextField getPrecioProvAddProductTextField() {
        return precioProvAddProductTextField;
    }

    public JTextField getPrecioVentaAddProductTextField() {
        return precioVentaAddProductTextField;
    }

    public JTextField getDescripcionTextField() {
        return descripcionTextField;
    }

    public SwingComponents(){
        initialPanelConf();
    }

    //CONFIG FUNCTIONS
    public void initialPanelConf (){
        addLabel.setFont(new Font("Agency FB",Font.BOLD,38));
        addLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sellLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sellLabel.setFont(new Font("Agency FB",Font.BOLD,38));
        product.setFont(new Font("Agency FB",Font.BOLD,38));
        product.setHorizontalAlignment(SwingConstants.CENTER);
        category.setFont(new Font("Agency FB",Font.BOLD,38));
        category.setHorizontalAlignment(SwingConstants.CENTER);
        priceUnit.setFont(new Font("Agency FB",Font.BOLD,38));
        priceUnit.setHorizontalAlignment(SwingConstants.CENTER);
        provider.setFont(new Font("Agency FB",Font.BOLD,38));
        provider.setHorizontalAlignment(SwingConstants.CENTER);
        cantidad.setFont(new Font("Agency FB",Font.BOLD,38));
        cantidad.setHorizontalAlignment(SwingConstants.CENTER);
        precProveLabel.setFont(new Font("Agency FB",Font.BOLD,38));
        precProveLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreAddProductLabel.setFont(new Font("Agency FB",Font.BOLD,38));
        nombreAddProductLabel.setHorizontalAlignment(SwingConstants.CENTER);
        codeInternoLabel.setFont(new Font("Agency FB",Font.BOLD,38));
        codeInternoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descripcionLabel.setFont(new Font("Agency FB",Font.BOLD,38));
        descripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);



    }
    //GETTERS


    public JLabel getPrecProveLabel() {
        return precProveLabel;
    }

    public JTextField getPriceProveedorTextField() {
        return priceProveedorTextField;
    }

    public JButton getSearchLogo() {
        return searchLogo;
    }

    public JButton getPlusLogo() { return plusLogo; }

    public void setPlusLogo(JButton plusLogo) {this.plusLogo = plusLogo; }

    public JButton getSubmmitButton() {
        return submmitButton;
    }

    public JLabel getAddLogo() {
        return addLogo;
    }

    public JLabel getProduct() {
        return product;
    }

    public JLabel getCategory() {
        return category;
    }

    public JLabel getPriceUnit() {
        return priceUnit;
    }

    public JLabel getProvider() {
        return provider;
    }

    public JLabel getCantidad() {
        return cantidad;
    }

    public JComboBox getProductosComboBox() {
        return productosComboBox;
    }

    public JComboBox getCategoryComboBox() {
        return categoryComboBox;
    }

    public JComboBox getProvidersComboBox() {
        return providersComboBox;
    }

    public JTextField getPriceUnitTextField() {
        return priceUnitTextField;
    }

    public JTextField getAmountTextField() {
        return amountTextField;
    }

    public JButton getInitSettingsButton() {
        return initSettingsButton;
    }

    public JLabel getAddLabel() {
        return addLabel;
    }

    public JLabel getSellLabel() {
        return sellLabel;
    }

    public JLabel getMainLogo() {
        return mainLogo;
    }

    public JButton getAddModeButton() {
        return addModeButton;
    }

    public JButton getSellModeButton() {
        return sellModeButton;
    }
}
