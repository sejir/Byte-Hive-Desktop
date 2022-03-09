/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import edu.SprintJava2.entities.ClientLouer;
import edu.SprintJava2.entities.EquipementLouer;
import edu.SprintJava2.entities.EquipementVendre;
import edu.SprintJava2.utlis.MyConnection;
import java.awt.Image;
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
public class EquipementLouerCRUD {
    
    public void ajouterEquipementLouer(EquipementLouer el){
        try {
            String requete = "INSERT INTO equipementlouer(nomEquipement,prixEquipement,descriptionEquipement,imageEquipement,idFournisseur,disponibilite) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, el.getNomEquipement());
            pst.setString(2, el.getPrixEquipement());
            pst.setString(3, el.getDescriptionEquipement());
            pst.setString(4, el.getImageEquipement());
            pst.setInt(5, el.getIdFournisseur());
            pst.setInt(6, el.getDisponibilite());
            pst.executeUpdate();
            System.out.println("Equipement Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    public ObservableList<EquipementLouer> listerEquipementLouer0(){
        ObservableList<EquipementLouer> myList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM equipementlouer where disponibilite=0";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementLouer el = new EquipementLouer();
                el.setIdEquipement(rs.getInt(1));
                el.setNomEquipement(rs.getString(2));
                el.setPrixEquipement(rs.getString(3));
                el.setDescriptionEquipement(rs.getString(4));
                el.setImageEquipement(rs.getString(5));
                el.setIdFournisseur(rs.getInt(6)); 
                el.setDisponibilite(rs.getInt(7));
                el.setRating(rs.getDouble(8));
                myList.add(el);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    
    public ObservableList<EquipementLouer> listerEquipementLouer1(){
        ObservableList<EquipementLouer> myList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM equipementlouer where disponibilite=1";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementLouer el = new EquipementLouer();
                el.setIdEquipement(rs.getInt(1));
                el.setNomEquipement(rs.getString(2));
                el.setPrixEquipement(rs.getString(3));
                el.setDescriptionEquipement(rs.getString(4));
                el.setImageEquipement(rs.getString(5));
                el.setIdFournisseur(rs.getInt(6)); 
                el.setDisponibilite(rs.getInt(7));
                el.setRating(rs.getDouble(8));
                myList.add(el);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    public void modifierEquipementLouer(int id ,EquipementLouer el)    {
        String requete = "UPDATE equipementlouer SET nomEquipement=?, prixEquipement=?,descriptionEquipement=?,imageEquipement=? ,  idFournisseur=? , disponibilite=? WHERE idEquipement = " + id;
        try {
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, el.getNomEquipement());
            pst.setString(2, el.getPrixEquipement());
            pst.setString(3, el.getDescriptionEquipement());
            pst.setString(4, el.getImageEquipement());
            pst.setInt(5, el.getIdFournisseur());
            pst.setInt(6, el.getDisponibilite());
            pst.executeUpdate();
            System.out.println("Equipement Modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public void supprimerEquipementLouer(int id )  {
      String requete = "DELETE FROM equipementlouer where idEquipement = ?";
        try {
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    
    }
      
    public ObservableList<ClientLouer> clientEquip(){
       String requete = "select c.nomClient,el.nomEquipement ,el.imageEquipement FROM equipementlouer el inner join louer l on el.idequipement=l.idEquipement inner join client c on c.idClient=l.idClient  "; 
       ObservableList<ClientLouer> myList = FXCollections.observableArrayList();
 
        try {
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                 ClientLouer cl = new ClientLouer();
                cl.setNomClient(rs.getString(1));
                cl.setNomEquipement(rs.getString(2));
                cl.setImage(rs.getString(3));

                //cl.setNomEquipement(rs.getString(2));
                myList.add(cl);
              

             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
        
       
    }
    
    public ObservableList<EquipementLouer> rechercher(String S){
        ObservableList<EquipementLouer> myList = FXCollections.observableArrayList();;
        try {
            String requete = "select * from equipementlouer where ( nomEquipement LIKE '%"+S+"%' || prixEquipement LIKE '%"+S+"%' || descriptionEquipement LIKE '%"+S+"%') && disponibilite=1";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementLouer el = new EquipementLouer();
                el.setIdEquipement(rs.getInt("idEquipement"));
                el.setNomEquipement(rs.getString("nomEquipement"));
                el.setPrixEquipement(rs.getString("prixEquipement"));
                el.setDescriptionEquipement(rs.getString("descriptionEquipement"));
                el.setImageEquipement(rs.getString("imageEquipement"));
                el.setDisponibilite(rs.getInt("disponibilite"));
                el.setIdFournisseur(rs.getInt("idFournisseur"));
                el.setRating(rs.getDouble("rating"));
                myList.add(el);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    public ObservableList<EquipementLouer> trierNom(){
        ObservableList<EquipementLouer> myList = FXCollections.observableArrayList();;
        try {
            String requete = "select * from equipementlouer where disponibilite=1 order by nomEquipement";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementLouer el = new EquipementLouer();
                el.setIdEquipement(rs.getInt("idEquipement"));
                el.setNomEquipement(rs.getString("nomEquipement"));
                el.setPrixEquipement(rs.getString("prixEquipement"));
                el.setDescriptionEquipement(rs.getString("descriptionEquipement"));
                el.setImageEquipement(rs.getString("imageEquipement"));
                el.setDisponibilite(rs.getInt("disponibilite"));
                el.setIdFournisseur(rs.getInt("idFournisseur"));
                el.setRating(rs.getDouble("rating"));
                myList.add(el);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    public ObservableList<EquipementLouer> trierPrix(){
        ObservableList<EquipementLouer> myList = FXCollections.observableArrayList();;
        try {
            String requete = "select * from equipementlouer where disponibilite=1 order by prixEquipement";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementLouer el = new EquipementLouer();
                el.setIdEquipement(rs.getInt("idEquipement"));
                el.setNomEquipement(rs.getString("nomEquipement"));
                el.setPrixEquipement(rs.getString("prixEquipement"));
                el.setDescriptionEquipement(rs.getString("descriptionEquipement"));
                el.setImageEquipement(rs.getString("imageEquipement"));
                el.setDisponibilite(rs.getInt("disponibilite"));
                el.setIdFournisseur(rs.getInt("idFournisseur"));
                el.setRating(rs.getDouble("rating"));
                myList.add(el);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
}
