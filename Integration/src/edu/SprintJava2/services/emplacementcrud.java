/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;
import edu.SprintJava2.entities.activites;
import edu.SprintJava2.utlis.MyConnection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import edu.SprintJava2.entities.emplacement;
import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author chiha
 */
public class emplacementcrud {
    
    
    
    
    
    
    public void ajouteremplacement(emplacement e){
        try {
            String requete = "INSERT INTO localisation(nom_emplacement,d_emplacement) VALUES(?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, e.getNom_emplacement());
            pst.setString(2, e.getD_emplacement());
            pst.executeUpdate();
            System.out.println("emplacement Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    
    
     
   public   ObservableList <emplacement> listeremplacement(){
        
      ObservableList <emplacement> list =  FXCollections.observableArrayList();
        try{
            
            String requete = "SELECT * FROM localisation"  ;
            Statement pste = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
            while (rs.next()){
                
            emplacement e = new emplacement() ;
            e.setId_emplacement(rs.getInt("id_emplacement"));
            e.setNom_emplacement(rs.getString("nom_emplacement"));
            e.setD_emplacement(rs.getString("d_emplacement"));
          
                     list.add(e);

            }
         
        }

        catch(SQLException k){
System.out.println(k.getMessage());         }
        return list;
        
    } 


 public void supprimeremplacement(int del) {
       try
       {
           String requete="DELETE FROM localisation WHERE id_emplacement =" +del ;
          PreparedStatement pste=MyConnection.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("emplacement supprimer");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
 }
 
           
 
    public void modifieremplacement(emplacement a, int modif){
        try {
            String requete =  "UPDATE localisation SET nom_emplacement = ?, d_emplacement = ? WHERE id_emplacement ="+modif;
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, a.getNom_emplacement());
            pst.setString(2, a.getD_emplacement());
            pst.executeUpdate();
            System.out.println("Element MODIFIER!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    } 
     
 
}


