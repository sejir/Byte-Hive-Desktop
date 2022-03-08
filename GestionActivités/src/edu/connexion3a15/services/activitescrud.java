/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import edu.connexion3a15.utiles.Myconnection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import edu.connexion3a15.entities.activites;
import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author chiha
 */
public class activitescrud {
    
    
    public void ajouteractivites(activites a){
        try {
            String requete = "INSERT INTO act(nom_act,description,d_debut,d_fin,emplacement,idemplacement,nb_personne,id_user) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst= Myconnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, a.getNom_act());
            pst.setString(2, a.getDescription());
            pst.setDate(3, a.getD_debut());
            pst.setDate(4, a.getD_fin());
            pst.setString(5, a.getEmplacement());
            pst.setInt(6, a.getIdemplacement());
            pst.setInt(7, a.getNb_personne());
            pst.setInt(8, a.getId_user());
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
            a.setNb_personne(rs.getInt("nb_personne"));
           
                
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
           String requete="DELETE FROM act WHERE id_act ="+z ;
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
            String requete =  "UPDATE act SET nom_act = ?, description = ?, d_debut = ?,d_fin = ?,emplacement = ? , idemplacement= ?, nb_personne=?,id_user=? WHERE id_act ="+z;
           
            PreparedStatement pst= Myconnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, a.getNom_act());
            pst.setString(2, a.getDescription());
            pst.setDate(3, a.getD_debut());
            pst.setDate(4, a.getD_fin());
            pst.setString(5, a.getEmplacement());
            pst.setInt(6, a.getIdemplacement());
            pst.setInt(7, a.getNb_personne());
            pst.setInt(8, a.getId_user());
            pst.executeUpdate();
            System.out.println("Element MODIFIER!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    
    
  
  public   ObservableList <activites> dupli(){
        
 ObservableList <activites> list =  FXCollections.observableArrayList();        
 try{
            
            String requete = " SELECT emplacement, COUNT(emplacement) FROM act GROUP BY nom_act HAVING COUNT(emplacement)"  ;
            Statement pste = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
             while (rs.next()){
            
                
           activites a = new activites() ;
         
            a.setEmplacement(rs.getString(1));
            a.setCount(rs.getString(2));
          rs.getInt(2);
            
            list.add(a);

            }
         
        }

        catch(SQLException k){
System.out.println(k.getMessage());         }
        return list;
        
    } 
     
 
    
    
    
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
 

    public  void  sms () {
        String bu = reporting();
        Twilio.init("AC692fa849b80bef1ce8d79f6fe8b04767","f58c00857427f18e068513449b40a182");
       Message message;
        message = Message.creator(
                new com.twilio.type.PhoneNumber("+21653940997"),
                new com.twilio.type.PhoneNumber("+16812486427"),
                "vous avez une evenement le"+bu)
                .create();

     }
    

    
    
    
     
    
   public String reporting (){           
                  String requete="SELECT * FROM `act` WHERE d_debut <=(DATE_ADD(LOCALTIME, INTERVAL +1 DAY) )  order by d_debut limit 1";

                String ret = null ;
        try {
           
            
            Statement pste = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
            while (rs.next()){
                
               
               ret= rs.getString("d_debut"); 
             }
        }
       
        catch (SQLException ex) {
            Logger.getLogger(activitescrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (ret!=null) { 
        return  ret ;
       }else
            return "0";
   } 

   
    
 public String suggestion(int nb){
     String a ="";
     String s="SELECT nom_act FROM `act` GROUP BY nom_act,nb_personne HAVING nb_personne = "+nb;
     String f = "ORDER BY COUNT(*) DESC limit 1 ";
     try{
            
            String requete =s  ;
            Statement pste = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
            while (rs.next()){
                
            a= rs.getString("d_debut");
            }
         
        }

        catch(SQLException k){
System.out.println(k.getMessage());         }
        return a;
        
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
