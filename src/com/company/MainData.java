package com.company;

import java.sql.*;
import java.util.ArrayList;

//This class will contain all the Data-structure and variables that will be used by the GUI
public class MainData {
    private Statement mainStatementDB; //CONECTOR PARA BASE DE DATOS
    //ARREGLOS PANEL INVENTRY ADD Y ADD PANEL
    private ArrayList <String> nombreProductosParaCBox;
    //VARIABLES DE SECCION ACTUAL Y PROVEEDOR ACTUAL PARA EL PANEL ADDINVENTORY
    private String IDSeccionActualInvent="";
    private String IDProveedorActualInvent="";

    public MainData (){
        initConnectionToDB();
    }

    public static String getIDProducto (String nombreProducto, Statement allData) throws SQLException {
        ResultSet res=allData.executeQuery("SELECT IDProducto FROM productos WHERE NombreProducto='"+nombreProducto+"'");
        res.next();
        return res.getString(1);
    }

    public static String getIDProveedor (String nombreProducto, Statement allData) throws SQLException {
        ResultSet res=allData.executeQuery("SELECT IDProveedor FROM productos WHERE NombreProducto='"+nombreProducto+"'");
        res.next();
        return res.getString(1);
    }

    public static boolean existeEnInventario (String idProducto,String idProveedor, Statement allData) throws SQLException {
        ResultSet res = allData.executeQuery("SELECT CANTIDAD FROM inventario WHERE IDProducto='"+idProducto+"' AND IDProveedor='"+idProveedor+"'");
        while(res.next()){
            return true;
        }
        return false;
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
