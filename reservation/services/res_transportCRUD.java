/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reservation.entities.res_transport;
import reservation.utils.MyConnection;

/**
 *
 * @author Sejir
 */
public class res_transportCRUD {
      public void ajouterTransport(res_transport T){
        try {
            String requete="INSERT INTO res_transport(type,nb_personnes,date)Values(?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
        pst.setString(1, T.getType());
        pst.setInt(2, T.getNb_personnes());
        pst.setDate(3, T.getDates());
        pst.executeUpdate();
            System.out.println("Transport ajouté");
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }          
    }
    
    public List<res_transport>listerTransport(){
     List<res_transport>mylist=new ArrayList();
        try {
            
            String requete="SELECT *FROM res_transport";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
            
            res_transport per=new res_transport();
            per.setId(rs.getInt("id"));
            per.setType(rs.getString("type"));
            per.setNb_personnes(rs.getInt("nb_personnes"));
            per.setDates(rs.getDate("date"));
            
            mylist.add(per);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   return mylist;}
     public void deleteTransport(int z) {
       try
       {
           String requete="DELETE FROM res_transport WHERE id =" +z ;
          PreparedStatement pste=MyConnection.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("transport supprimée");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
 }
 
           
 
    public void modifierTransport(res_transport C, int z){
        try {
            String requete =  "UPDATE res_cabine SET type = ?, nb_personnes = ?, date = ? WHERE id="+z;
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, C.getType());
            pst.setInt(2, C.getNb_personnes());
            pst.setDate(3, C.getDates());
            pst.executeUpdate();
            System.out.println("Transport modifiée!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
}
