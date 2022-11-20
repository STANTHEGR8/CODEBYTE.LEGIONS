package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection dblink;
    public Connection getDbLink2;

    public Connection getDblink(){
        String databaseName = "login";
        String databaseUser = "root";
        String databasePassword = "Lo.ng!PAss<>?!";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dblink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dblink;
    }

    public Connection getDbLink2(){
        String databaseName = "cubcsdb";
        String databaseUser = "root";
        String databasePassword = "Lo.ng!PAss<>?!";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            getDbLink2 = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return getDbLink2;
    }
}
