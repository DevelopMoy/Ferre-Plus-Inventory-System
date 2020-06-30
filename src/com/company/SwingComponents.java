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
    private JLabel product = new JLabel ("Product: ");
    private JLabel category = new JLabel ("Category: ");
    private JLabel priceUnit = new JLabel ("Price Unit: ");
    private JLabel provider = new JLabel ("Provider: ");
    private JLabel cantidad = new JLabel ("Amount: ");
    private JComboBox products = new JComboBox ();
    private JComboBox categorys = new JComboBox ();
    private JComboBox providers = new JComboBox ();
    private JTextField priceUnitTextField = new JTextField ();
    private JTextField amountTextField = new JTextField ();
    private JButton plusLogo = new JButton (new ImageIcon ("images/plusLogo.png"));
    private JButton searchLogo = new JButton (new ImageIcon ("images/searchLogo.png"));

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
    }
    //GETTERS


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

    public JComboBox getProducts() {
        return products;
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
