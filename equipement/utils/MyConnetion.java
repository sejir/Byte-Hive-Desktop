/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class MyConnetion {
    public String url="jdbc:mysql://localhost:3306/nature_cruise";
    public String login="root";
    public String pwd="";
    
    Connection cnx;
    public static MyConnetion instance;
    
    private MyConnetion() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion Etablie!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static MyConnetion getInstance() {
        if(instance==null){
            instance = new MyConnetion();
        }
        return instance;
    }
}
