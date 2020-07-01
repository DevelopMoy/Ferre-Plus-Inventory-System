package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//This class will contain all the Data-structure and variables that will be used by the GUI
public class MainData {
    private Statement mainStatementDB;
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

}
