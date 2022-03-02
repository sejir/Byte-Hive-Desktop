/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.services;

import edu.naturecruise.entites.EquipementLouer;
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
public class EquipementLouerCRUD {
    
    public void ajouterEquipementLouer(EquipementLouer el){
        try {
            String requete = "INSERT INTO equipementlouer(nomEquipement,prixEquipement,descriptionEquipement,imageEquipement,idFournisseur,disponibilite) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, el.getNomEquipement());
            pst.setFloat(2, el.getPrixEquipement());
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
    public ObservableList<EquipementLouer> listerEquipementLouer(){
        ObservableList<EquipementLouer> myList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM equipementlouer";
            Statement st= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementLouer el = new EquipementLouer();
                el.setIdEquipement(rs.getInt(1));
                el.setNomEquipement(rs.getString(2));
                el.setPrixEquipement(rs.getFloat(3));
                el.setDescriptionEquipement(rs.getString(4));
                el.setImageEquipement(rs.getString(5));
                el.setIdFournisseur(rs.getInt(6)); 
                el.setDisponibilite(rs.getInt(7));
                myList.add(el);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    public ObservableList<EquipementLouer> listerEquipementLouerClient(){
        ObservableList<EquipementLouer> myList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM equipementlouer where disponibilite=0";
            Statement st= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementLouer el = new EquipementLouer();
                el.setIdEquipement(rs.getInt(1));
                el.setNomEquipement(rs.getString(2));
                el.setPrixEquipement(rs.getFloat(3));
                el.setDescriptionEquipement(rs.getString(4));
                el.setImageEquipement(rs.getString(5));
                el.setIdFournisseur(rs.getInt(6)); 
                el.setDisponibilite(rs.getInt(7));
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
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, el.getNomEquipement());
            pst.setFloat(2, el.getPrixEquipement());
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
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    
    }
    
    
    public ObservableList<EquipementLouer> duree(){
       String requete = "select c.nomClient,el.nomEquipement FROM equipementlouer el inner join louer l on el.idequipement=l.idEquipement inner join client c on c.idClient=l.idClient where dateRemise > sysdate() "; 
       ObservableList<EquipementLouer> myList = FXCollections.observableArrayList();
 
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                 EquipementLouer el = new EquipementLouer();
                el.setDescriptionEquipement(rs.getString(1));

                el.setNomEquipement(rs.getString(2));
                myList.add(el);
              

             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
        
       
    }
}
