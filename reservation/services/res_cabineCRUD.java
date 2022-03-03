/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.services;

import reservation.entities.res_cabine;
import reservation.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sejir
 */
public class res_cabineCRUD {
   
    public void ajouterCabine(res_cabine c){
        try {
            String requete="INSERT INTO res_cabine(num,nb_personnes,type,prix)Values(?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
        pst.setInt(1, c.getNum());
        pst.setInt(2, c.getNb_personnes());
        pst.setString(3, c.getType());
        pst.setFloat(4, c.getPrix());
        pst.executeUpdate();
            System.out.println("elemenT AJOUTEEEEE");
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }          
    }
    
    public List<res_cabine>listerCabine(){
     List<res_cabine>mylist=new ArrayList();
        try {
            
            String requete="SELECT *FROM res_cabine";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
            
            res_cabine per=new res_cabine();
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
     public void deleteCabine(int z) {
       try
       {
           String requete="DELETE FROM res_cabine WHERE id =" +z ;
          PreparedStatement pste=MyConnection.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("cabine supprimée");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
 }
 
           
 
    public void modifierCabine(res_cabine C, int z){
        try {
            String requete =  "UPDATE res_cabine SET num = ?, nb_personnes = ?, type = ?,prix= ? WHERE id="+z;
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, C.getNum());
            pst.setInt(2, C.getNb_personnes());
            pst.setString(3, C.getType());
            pst.setFloat(4, C.getPrix());
            pst.executeUpdate();
            System.out.println("cabine modifiée!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
 
}

