package com.company;

import java.sql.*;
import java.util.ArrayList;

//This class will contain all the Data-structure and variables that will be used by the GUI
public class MainData {
    private Statement mainStatementDB; //CONECTOR PARA BASE DE DATOS
    //ARREGLOS PANEL INVENTRY ADD Y ADD PANEL
    private ArrayList <String> nombreProductosParaCBox;

    public MainData (){
        initConnectionToDB();
    }

    public void initConnectionToDB (){
        try {
            Connection conectionDataB= DriverManager.getConnection("jdbc:mysql://localhost:3306/upndowndatabase","root","");
            mainStatementDB = conectionDataB.createStatement();
        }catch (Exception e){
            System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS: "+e.getMessage());
        }
    }

    public Statement getMainStatementDB() {
        return mainStatementDB;
    }

    public void setMainStatementDB(Statement mainStatementDB) {
        this.mainStatementDB = mainStatementDB;
    }

    //METODOS ACTUALIZACION DATOS
    public void actualizarArrayProductos () throws SQLException {
        nombreProductosParaCBox=new ArrayList<>();
        ResultSet result =mainStatementDB.executeQuery("SELECT NombreProducto FROM productos");
        while (result.next()){
            nombreProductosParaCBox.add(result.getString(1));
        }
    }

    //GETTER Y SETTER
    public ArrayList<String> getNombreProductosParaCBox() {
        return nombreProductosParaCBox;
    }

    public void setNombreProductosParaCBox(ArrayList<String> nombreProductosParaCBox) {
        this.nombreProductosParaCBox = nombreProductosParaCBox;
    }

}
