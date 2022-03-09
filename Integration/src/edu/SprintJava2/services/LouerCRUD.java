/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import edu.SprintJava2.entities.EquipementLouer;
import edu.SprintJava2.entities.Louer;
import edu.SprintJava2.utlis.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class LouerCRUD {
    
    public void ajouterLouer(Louer l){
        try {
            String requete = "INSERT INTO louer(dateEmprunt,dateRemise,idEquipement,idClient) VALUES(?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setDate(1, l.getDateEmprunt());
            pst.setDate(2, l.getDateRemise());
            pst.setInt(3, l.getIdEquipement());
            pst.setInt(4, l.getIdClient());
           
            pst.executeUpdate();
            System.out.println("Louer Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    public ObservableList<Louer> listerLouer(){
        ObservableList<Louer> myList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM louer";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Louer l = new Louer();
                l.setIdLouer(rs.getInt(1));
                l.setDateEmprunt(rs.getDate(2));
                l.setDateRemise(rs.getDate(3));
                l.setIdEquipement(rs.getInt(4));
                l.setIdClient(rs.getInt(5));
                myList.add(l);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    public void modifierLouer(int id ,Louer l)    {
     
 
        String requete = "UPDATE louer SET dateEmprunt=?,dateRemise=?,idEquipement=?,idClient=? WHERE idEquipement = " + id;
    
        try {
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setDate(1, l.getDateEmprunt());
            pst.setDate(2, l.getDateRemise());
            pst.setInt(3, l.getIdEquipement());
            pst.setInt(4, l.getIdClient());

             
            pst.executeUpdate();
            System.out.println("Louer Modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public void supprimerEquipementLouer(int id )  {
      String requete = "DELETE FROM louer where idLouer = ?";
        try {
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    
    }
   
}

