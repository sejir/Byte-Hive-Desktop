/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava1.services;

import edu.SprintJava1.entities.Admin;
import edu.SprintJava1.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*; 

/**
 *
 * @author chayma
 */
public class AdminCRUD {
     private Connection mc = MyConnection.getInstance().getCnx();
     public void ajouterAdmin(Admin ad){
        try {
            String requete = "insert into admin(idadmin,nom,prenom,cin,email)"
                    + "values(?,?,?,?,?)";
            PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, ad.getIdadmin());
            pst.setString(2,ad.getNom());
            pst.setString(3,ad.getPrenom());
            pst.setInt(4,ad.getCin());
            pst.setString(5,ad.getEmail());
            pst.executeUpdate();
            System.err.println("Admin ajouteé avec sucées !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
     public List<Admin>listerAdmins(){
         List<Admin>myList = new ArrayList();
         try {
             
             String requete = "SELECT * FROM admin";
             Statement st = MyConnection.getInstance().getCnx().createStatement();
             ResultSet rs = st.executeQuery(requete);
             while(rs.next()){
                 Admin adm = new Admin();
                 adm.setIdadmin(rs.getInt(1));
                 adm.setNom(rs.getString("nom"));
                 adm.setPrenom(rs.getString("prenom"));
                 adm.setCin(rs.getInt(1));
                 adm.setEmail(rs.getString("email"));
                 myList.add(adm);
                 
             }
             
         } catch (SQLException ex) {
             System.out.println(ex.getMessage()); 
         }
         
        return myList;
     }
     public void modifierAdmin(int idadmin_e,String nom_e,String prenom_e,int cin_e,String email_e){
         try {
             String requete = "UPDATE admin SET " + "`idadmin`='"+idadmin_e+"' , `nom`='"+nom_e+"' , `prenom`='"+prenom_e+"',`cin`='"+cin_e+"',`email`='"+email_e+"' where `idadmin`='"+idadmin_e+"'";
             PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.executeUpdate();
             System.err.println("admin modifié avec succée ! ");
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
     }
     public void supprimerAdmin(Admin ad) {
         try {
             String requete = "DELETE FROM admin where idadmin=?";
             PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.setInt(1,ad.getIdadmin());
             pst.executeUpdate();
             System.err.println("admin supprimé avec succée ! ");
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
     }
     public List<Admin> rechercherAdmin (int idadmin){
        List <Admin> AdminList = new ArrayList<>();
        try {
            String requete="SELECT * FROM admin WHERE `idadmin`='"+idadmin+"' ";
            Statement st= mc.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                Admin ad =new Admin();
                
                ad.setIdadmin(rs.getInt(1));
                ad.setNom(rs.getString("nom"));
                ad.setPrenom(rs.getString("prenom"));
                ad.setCin(rs.getInt(4));
                ad.setEmail(rs.getString("email"));
                
                AdminList.add(ad);
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return AdminList;
    }
    
}
