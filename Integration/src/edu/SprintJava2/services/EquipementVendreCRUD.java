/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import edu.SprintJava2.entities.EquipementVendre;
import edu.SprintJava2.utlis.MyConnection;
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
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, ev.getNomEquipement());
            pst.setString(2, ev.getPrixEquipement());
            pst.setString(3, ev.getDescriptionEquipement());
            pst.setString(4, ev.getImageEquipement());
            pst.setString(5, ev.getQuantiteEquipement());
            pst.setInt(6, ev.getIdFournisseur());
            pst.executeUpdate();
            System.out.println("Element Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    public ObservableList<EquipementVendre> listerEquipementVendre(){
        ObservableList<EquipementVendre> myList = FXCollections.observableArrayList();;
        try {
            String requete = "SELECT * FROM equipementvendre";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementVendre ev = new EquipementVendre();
                ev.setIdEquipement(rs.getInt("idEquipement"));
                ev.setNomEquipement(rs.getString("nomEquipement"));
                ev.setPrixEquipement(rs.getString("prixEquipement"));
                ev.setDescriptionEquipement(rs.getString("descriptionEquipement"));
                ev.setImageEquipement(rs.getString("imageEquipement"));
                ev.setQuantiteEquipement(rs.getString("quantiteEquipement"));
                ev.setIdFournisseur(rs.getInt("idFournisseur"));
                ev.setRating(rs.getDouble("rating"));
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
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, ev.getNomEquipement());
            pst.setString(2, ev.getPrixEquipement());
            pst.setString(3, ev.getDescriptionEquipement());
            pst.setString(4, ev.getImageEquipement());
            pst.setString(5, ev.getQuantiteEquipement());
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
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
//    public ObservableList<EquipementVendre> calculChiffreAffaire(){
//        ObservableList<EquipementVendre> myList = FXCollections.observableArrayList();
//        String requete = "select nomEquipement,quantiteEquipement*prixEquipement from equipementvendre";
//        try {
//            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
//             ResultSet rs = pst.executeQuery();
//             while(rs.next()){
//                EquipementVendre ev = new EquipementVendre();
//                ev.setNomEquipement(rs.getString(1));
//                ev.setPrixEquipement(rs.getString(2));
//                myList.add(ev);
//             }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());            
//        }
//        
//        return myList ;
//        
//    } 
    
    public ObservableList<EquipementVendre> rechercher(String S){
        ObservableList<EquipementVendre> myList = FXCollections.observableArrayList();;
        try {
            String requete = "select * from equipementvendre where ( nomEquipement LIKE '%"+S+"%' || prixEquipement LIKE '%"+S+"%' || descriptionEquipement LIKE '%"+S+"%')";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementVendre ev = new EquipementVendre();
                ev.setIdEquipement(rs.getInt("idEquipement"));
                ev.setNomEquipement(rs.getString("nomEquipement"));
                ev.setPrixEquipement(rs.getString("prixEquipement"));
                ev.setDescriptionEquipement(rs.getString("descriptionEquipement"));
                ev.setImageEquipement(rs.getString("imageEquipement"));
                ev.setQuantiteEquipement(rs.getString("quantiteEquipement"));
                ev.setIdFournisseur(rs.getInt("idFournisseur"));
                ev.setRating(rs.getDouble("rating"));
                myList.add(ev);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    public ObservableList<EquipementVendre> TriNom(){
        ObservableList<EquipementVendre> myList = FXCollections.observableArrayList();;
        try {
            String requete = "select * from equipementvendre order by nomEquipement";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementVendre ev = new EquipementVendre();
                ev.setIdEquipement(rs.getInt("idEquipement"));
                ev.setNomEquipement(rs.getString("nomEquipement"));
                ev.setPrixEquipement(rs.getString("prixEquipement"));
                ev.setDescriptionEquipement(rs.getString("descriptionEquipement"));
                ev.setImageEquipement(rs.getString("imageEquipement"));
                ev.setQuantiteEquipement(rs.getString("quantiteEquipement"));
                ev.setIdFournisseur(rs.getInt("idFournisseur"));
                ev.setRating(rs.getDouble("rating"));
                myList.add(ev);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    public ObservableList<EquipementVendre> TriPrix(){
        ObservableList<EquipementVendre> myList = FXCollections.observableArrayList();;
        try {
            String requete = "select * from equipementvendre order by prixEquipement";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementVendre ev = new EquipementVendre();
                ev.setIdEquipement(rs.getInt("idEquipement"));
                ev.setNomEquipement(rs.getString("nomEquipement"));
                ev.setPrixEquipement(rs.getString("prixEquipement"));
                ev.setDescriptionEquipement(rs.getString("descriptionEquipement"));
                ev.setImageEquipement(rs.getString("imageEquipement"));
                ev.setQuantiteEquipement(rs.getString("quantiteEquipement"));
                ev.setIdFournisseur(rs.getInt("idFournisseur"));
                ev.setRating(rs.getDouble("rating"));
                myList.add(ev);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
}
