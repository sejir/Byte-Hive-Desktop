/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.services;

import edu.naturecruise.entites.EquipementVendre;
import edu.naturecruise.utils.MyConnetion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class EquipementVendreCRUD {
    
   
    public void ajouterEquipementVendre(EquipementVendre ev){
        try {
            String requete = "INSERT INTO equipementvendre(nomEquipement,prixEquipement,descriptionEquipement,imageEquipement,quantiteEquipement,idFournisseur) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, ev.getNomEquipement());
            pst.setFloat(2, ev.getPrixEquipement());
            pst.setString(3, ev.getDescriptionEquipement());
            pst.setString(4, ev.getImageEquipement());
            pst.setInt(5, ev.getQuantiteEquipement());
            pst.setInt(6, ev.getIdFournisseur());
            
            pst.executeUpdate();
            System.out.println("Element Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    public ObservableList<EquipementVendre> listerEquipementVendre(){
        ObservableList<EquipementVendre> myList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM equipementvendre ";
            Statement st= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementVendre ev = new EquipementVendre();
                ev.setIdEquipement(rs.getInt(1));
                ev.setNomEquipement(rs.getString(2));
                ev.setPrixEquipement(rs.getFloat(3));
                ev.setDescriptionEquipement(rs.getString(4));
                ev.setImageEquipement(rs.getString(5));
                ev.setQuantiteEquipement(rs.getInt(6));
                ev.setIdFournisseur(rs.getInt(7));
                myList.add(ev);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    public void modifierEquipementVendre(int id ,EquipementVendre ev)    {
     
 
        String requete = "UPDATE equipementvendre SET nomEquipement=?,prixEquipement=?,descriptionEquipement=?, imageEquipement=? , quantiteEquipement=? ,idFournisseur=? WHERE idEquipement =" + id;
    
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, ev.getNomEquipement());
            pst.setFloat(2, ev.getPrixEquipement());
            pst.setString(3, ev.getDescriptionEquipement());
            pst.setString(4, ev.getImageEquipement());
            pst.setInt(5, ev.getQuantiteEquipement());
            pst.setInt(6, ev.getIdFournisseur());

            pst.executeUpdate();
            System.out.println("equipement modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public void supprimerEquipementVendre(int id )  {
      String requete = "DELETE FROM equipementvendre where idEquipement = ?";
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public ObservableList<EquipementVendre> calculChiffreAffaire(){
        ObservableList<EquipementVendre> myList = FXCollections.observableArrayList();
        String requete = "select nomEquipement,quantiteEquipement*prixEquipement from equipementvendre";
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                EquipementVendre ev = new EquipementVendre();
                ev.setNomEquipement(rs.getString(1));
                ev.setPrixEquipement(rs.getFloat(2));
                myList.add(ev);
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        
        return myList ;
        
    } 
    
    
}
