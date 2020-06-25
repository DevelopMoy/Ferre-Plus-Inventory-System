package com.company;

import mdlaf.MaterialLookAndFeel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel (new MaterialLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace ();
        }
        MainWindow v1 = new MainWindow();
    }
}
