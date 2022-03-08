/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.services;

import java.sql.Connection;
import Reservation.entities.Cabine;
import reservation.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sejir
 */
public class CabineCRUD {
   
    public void ajouterCabine(Cabine c){
        try {
            String requete="INSERT INTO res_cabine(num,nb_personnes,type,prix,Dispo)Values(?,?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
        pst.setInt(1, c.getNum());
        pst.setInt(2, c.getNb_personnes());
        pst.setString(3, c.getType());
        pst.setFloat(4, c.getPrix());
        pst.setInt(5, c.getDispo());
        pst.executeUpdate();
            System.out.println("elemenT AJOUTEEEEE");
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }          
    }
    
    public List<Cabine>listerCabine(){
     List<Cabine>mylist=new ArrayList();
        try {
            
            String requete="SELECT *FROM res_cabine";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
            
            Cabine per=new Cabine();
            per.setId(rs.getInt(1));
            per.setNum(rs.getInt("num"));
            per.setNb_personnes(rs.getInt("nb_personnes"));
            per.setPrix(rs.getFloat("prix"));
            per.setType(rs.getString("type"));
            mylist.add(per);}
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   return mylist;}
     public void deleteCabine(Cabine C) {
      String requete = "DELETE FROM res_cabine WHERE id=?";
 
        try {
            PreparedStatement statement = MyConnection.getInstance().getCnx().prepareStatement(requete);
            statement.setInt(1,C.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 public List recupererCabine(String z)
 {
     List<Integer> mylist=new ArrayList();
     

 String requete="SELECT num FROM res_cabine  WHERE type=?";
         try {
            PreparedStatement statement = MyConnection.getInstance().getCnx().prepareStatement(requete);
            statement.setString(1,z);
            statement.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
   return mylist;
 
 
 }   
           
 
    public void modifierCabine(Cabine C){
        try {
            String requete =  "UPDATE res_cabine SET num = ?, nb_personnes = ?, type = ?,prix= ?,Dispo= ? WHERE id=?";
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(6, C.getId());
            pst.setInt(1, C.getNum());
            pst.setInt(2, C.getNb_personnes());
            pst.setString(3, C.getType());
            pst.setFloat(4, C.getPrix());
            pst.setFloat(5, C.getDispo());
            pst.executeUpdate();
            System.out.println("cabine modifiée!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    public void Dispo(Cabine C,int y){
      
        try {
            String requete =  "UPDATE res_cabine SET Dispo= ? WHERE num=?";
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
         
            pst.setInt(2,y);
            
            pst.setInt(1,1);
            pst.executeUpdate();
            System.out.println("cabine modifiée!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
 public String CodePromo() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();

    return generatedString;
}
 public List<Cabine>listerCabineDispo(){
     List<Cabine>mylist=new ArrayList();
        try {
            String requete="SELECT* FROM res_cabine WHERE Dispo=0 ORDER BY  type ASC";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
          
         
            
            while(rs.next()){
            
            Cabine per=new Cabine();
            per.setNum(rs.getInt("num"));
           
            per.setType(rs.getString("type"));
           
            mylist.add(per);}
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   return mylist;}
}

