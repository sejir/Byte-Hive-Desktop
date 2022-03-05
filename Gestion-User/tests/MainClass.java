/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.tests;

import edu.SprintJava2.entities.Users;
import edu.SprintJava2.services.UsersCRUD;
import edu.SprintJava2.utlis.MyConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chayma
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            //MyConnection mc = new MyConnection();
            UsersCRUD cc = new UsersCRUD();
            Users u = new Users(4,"Mounir","Mese3di","aa","bbbb","host","ee");
            cc.ajouteruser(u);
            //System.out.println(cc.listerUsers());
            //cc.modifierUsers(1, "Mounir", "Mese3di", "chayma", "chayma", "chayma", "monji");
            //cc.supprimerUser(u);
            cc.Login("aa", "vv");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
}}
