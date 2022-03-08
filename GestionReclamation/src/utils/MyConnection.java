/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entities.Guide;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Feryel Derouich
 */
public class MyConnection {
    public String url="jdbc:mysql://localhost:3306/piferyel";
    public String login="root";
    public String pwd="";

    Connection cnx;
    public static MyConnection instance;
    
    public MyConnection() {
        try {
            cnx= DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public static MyConnection getInstance(){
        if (instance == null){
            instance = new MyConnection();
        }
        return instance;
    }
    
    
}
