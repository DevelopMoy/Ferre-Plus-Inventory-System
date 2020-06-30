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
    private JComboBox categorys = new JComboBox ();
    private JComboBox providers = new JComboBox ();
    private JTextField priceUnitTextField = new JTextField ();
    private JTextField amountTextField = new JTextField ();
    private JTextField priceProveedorTextField = new JTextField ();
    private JButton plusLogo = new JButton (new ImageIcon ("images/plusLogo.png"));
    private JButton searchLogo = new JButton (new ImageIcon ("images/searchLogo.png"));


    private JLabel addProductLogo = new JLabel (new ImageIcon ("images/addProductLogo.png"));
    private JLabel nombreAddProductLabel = new JLabel ("Nombre:");
    private JLabel codeInternoLabel = new JLabel ("Codigo Interno: ");
    private JLabel descripcionLabel = new JLabel ("Descripcion");
    private JTextField nombreAddProductTextField = new JTextField ();
    private JTextField codigointernoTextField = new JTextField ();
    private JComboBox seccionAddProductCombobox = new JComboBox ();
    private JTextField precioProvAddProductTextField = new JTextField ();
    private JTextField precioVentaAddProductTextField = new JTextField ();
    private JTextField descripcionTextField = new JTextField ();
    private JButton aceptarAddProductButton = new JButton (new ImageIcon ("images/aceptarAdd.png"));
    private JButton cancelarAddProductButton = new JButton ("Cancelar");

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

    public JComboBox getCategorys() {
        return categorys;
    }

    public JComboBox getProviders() {
        return providers;
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
