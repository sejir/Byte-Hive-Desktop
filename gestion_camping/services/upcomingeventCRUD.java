/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionCamping.services;

import edu.GestionCamping.entities.upcomingevents;
import edu.GestionCamping.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class upcomingeventCRUD {

    public void ajouteupcomingeventCRUD() {
             try {
            String requete="INSERT INTO upcomingevents (event_number,event_name,location,date,guide)"
                    + "VALUES ('1','ByteHive','Tazarka','11/02/2023','moataz mhamdi')";
            
            Statement st = MyConnection.getInstance().getCnx().createStatement();
             st.executeUpdate(requete);
            System.out.println("Evenement ajoutée!");
        } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
        }
            
        
}
      
            

        public List<upcomingevents> listerupcomingevents () {
        List<upcomingevents> myList = new ArrayList();
            try {            

            String requete ="SELECT * FROM upcomingevents ";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
                ResultSet rs = st.executeQuery(requete);
                while(rs.next()){
                    upcomingevents up = new upcomingevents();
                    up.setEvent_number(rs.getInt(1));
                    up.setEvent_name(rs.getString("event_name"));
                    up.setLocation(rs.getString("location"));
                    up.setDate(rs.getString("date"));
                    up.setGuide(rs.getString("guide"));
                    myList.add(up);
                }
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());   
        }
        return myList;
           
        }
        public void  Updateupcomingevents (int event_nu, String event_n, String location_n, String date_n, String guide_n) {
            
try {
   
   
             String requete = "UPDATE upcomingevents SET " + "`event_name`='"+event_n+"' , `location`='"+location_n+"',`date`='"+date_n+"',`guide`='"+guide_n+"' where `event_number`='"+event_nu+"'";
             PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.executeUpdate();
             System.err.println("Evenement modifié ! ");

         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }

        }
        public void SupprimerUpcomingevents (upcomingevents uce){
              try {
             String requete = "DELETE FROM upcomingevents where event_number=?";
             PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.setInt(1,uce.getEvent_number());
             pst.executeUpdate();
             System.err.println("evenement supprimé ! ");
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
        }



    }

  
    

