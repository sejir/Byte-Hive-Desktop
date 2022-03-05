/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import edu.SprintJava2.entities.Contact;
import edu.SprintJava2.entities.Users;
import edu.SprintJava2.utlis.MyConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author chayma
 */
public class ContactCRUD {
        public boolean ajoutecontact( Contact c) {
        try {
            String requete = "INSERT into contact(name,email,date,description) values(?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,c.getName());
            pst.setString(2,c.getEmail());
            pst.setString(3,c.getDate());
            pst.setString(4,c.getDescription());
           pst.executeUpdate();
           System.out.println("Contact ajouteé avec succées !");
           return true;
                    
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
        return false;
    }
          public static void supprimerContact(Contact c){
        try {
            String requete="DELETE from contact where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.executeUpdate();
            System.err.println("contact supprimé avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          }
}
