/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Myconnection {
    public String url="jdbc:mysql://localhost:3306/pi";
    public String login="root";
    public String pwd="";
    
    Connection cnx;
    public static Myconnection instance;
    
    private Myconnection() {
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

    public static Myconnection getInstance() {
        if(instance==null){
            instance = new Myconnection();
        }
        return instance;
    }

    public static void main(String[] args) {
        Myconnection s = new Myconnection();
    }
    
}
