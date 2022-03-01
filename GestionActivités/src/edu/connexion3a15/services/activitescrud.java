/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;
import edu.connexion3a15.utiles.Myconnection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import edu.connexion3a15.entities.activites;
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
public class activitescrud {
    
    
    public void ajouteractivites(activites a){
        try {
            String requete = "INSERT INTO act(nom_act,description,d_debut,d_fin,emplacement,idemplacement) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst= Myconnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, a.getNom_act());
            pst.setString(2, a.getDescription());
            pst.setDate(3, a.getD_debut());
            pst.setDate(4, a.getD_fin());
            pst.setString(5, a.getEmplacement());
            pst.setInt(6, a.getIdemplacement());
            pst.executeUpdate();
            System.out.println("Element Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    
    
     
   public   ObservableList <activites> listeract(){
        
      ObservableList <activites> list =  FXCollections.observableArrayList();
        try{
            
            String requete = "SELECT * FROM act"  ;
            Statement pste = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
            while (rs.next()){
                
            activites a = new activites() ;
            a.setId_act(rs.getInt("id_act"));
            a.setNom_act(rs.getString("nom_act"));
            a.setDescription(rs.getString("description"));
            a.setD_debut(rs.getDate("d_debut"));
            a.setD_fin(rs.getDate("d_fin"));
            a.setEmplacement(rs.getString("emplacement"));
            a.setIdemplacement(rs.getInt("idemplacement"));
                
                     list.add(a);

            }
         
        }

        catch(SQLException k){
System.out.println(k.getMessage());         }
        return list;
        
    } 


 public void delete(int z) {
       try
       {
           String requete="DELETE FROM act WHERE id_act =" +z ;
          PreparedStatement pste=Myconnection.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("activité supprimer");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
 }
 
           
 
    public void modifieractivites(activites a, int z){
        try {
            String requete =  "UPDATE act SET nom_act = ?, description = ?, d_debut = ?,d_fin = ?,emplacement = ? , idemplacement= ? WHERE id_act ="+z;
           
            PreparedStatement pst= Myconnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, a.getNom_act());
            pst.setString(2, a.getDescription());
            pst.setDate(3, a.getD_debut());
            pst.setDate(4, a.getD_fin());
            pst.setString(5, a.getEmplacement());
            pst.setInt(6, a.getIdemplacement());
            pst.executeUpdate();
            System.out.println("Element MODIFIER!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
 /*
  public   List <activites> dupli(){
        
      List <activites> list = new ArrayList<>();
        try{
            
            String requete = "SELECT nom_act, COUNT(nom_act) FROM act GROUP BY nom_act HAVING COUNT(nom_act)"  ;
            Statement pste = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
             while (rs.next()){
            
                
           activites a = new activites() ;
         
            a.setNom_act(rs.getString("nom_act"));
            rs.getInt(2);
            
            list.add(a);

            }
         
        }

        catch(SQLException k){
System.out.println(k.getMessage());         }
        return list;
        
    } 
     */
 
    
    
    
   public   List <activites> search(int Id_act){
        
      List <activites> list = new ArrayList<>();
        try{
            
            String requete = "select id_act from act WHERE id_act=?"  ;
            Statement pste = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
            while (rs.next()){
                
            activites a = new activites() ;
            a.setId_act(rs.getInt("id_act"));
            a.setNom_act(rs.getString("nom_act"));
            a.setDescription(rs.getString("description"));
            a.setD_debut(rs.getDate("d_debut"));
            a.setD_fin(rs.getDate("d_fin"));
            a.setEmplacement(rs.getString("emplacement"));
                
                     list.add(a);

            }
         
        }

        catch(SQLException k){
System.out.println(k.getMessage());         }
        return list;
        
    } 
 
    
 
    
    
     public   List <activites> jointure(int p){
        
      List <activites> list = new ArrayList<>();
        try{
            
            String requete = "SELECT nom_act,description  , d_debut  , d_fin   , emplacement,id_emplacement,d_emplacement   FROM act inner JOIN localisation ON act.idemplacement= localisation.id_emplacement where id_act=" +p  ;
            Statement pste = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
            while (rs.next()){
                
            activites a = new activites() ;
           // a.setId_act(rs.getInt("id_act"));
            a.setNom_act(rs.getString("nom_act"));
            a.setDescription(rs.getString("description"));
            a.setD_debut(rs.getDate("d_debut"));
            a.setD_fin(rs.getDate("d_fin"));
            a.setEmplacement(rs.getString("emplacement"));
            a.setIdemplacement(rs.getInt("id_emplacement"));
                
                     list.add(a);

            }
         
        }

        catch(SQLException k){
System.out.println(k.getMessage());         }
        return list;
        
    } 
}
