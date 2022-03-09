/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import edu.SprintJava2.entities.upcomingevents;
import edu.SprintJava2.utlis.MyConnection;
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
 * @author USER
 */
public class upcomingeventCRUD {

public void ajouterupcomingevents(upcomingevents e) {
        try {
            String requete = "INSERT INTO upcomingevents(event_name,location,date_camping,guide,id_guide) VALUES(?,?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, e.getEvent_name());
            pst.setString(2, e.getLocation());
            pst.setDate(3, e.getDate_camping());
            pst.setString(4, e.getGuide());
            pst.setInt(5, e.getId_guide());
            
            pst.executeUpdate();
            System.out.println("Element Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
      
            

         public ObservableList <upcomingevents> listerupcomingevents () {
         ObservableList <upcomingevents> List = FXCollections.observableArrayList();
            try {            

            String requete ="SELECT * FROM upcomingevents ";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
                ResultSet rs = st.executeQuery(requete);
                while(rs.next()){
                    upcomingevents up = new upcomingevents();
                    up.setEvent_number(rs.getInt(1));
                    up.setEvent_name(rs.getString("event_name"));
                    up.setLocation(rs.getString("location"));
                    up.setDate_camping(rs.getDate("date_camping"));
                    up.setGuide(rs.getString("guide"));
                    up.setId_guide(rs.getInt("id_guide"));
                    List.add(up);
                }
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());   
        }
        return List;
           
        }
        public void  Updateupcomingevents (upcomingevents u, int event_nu) {
            
try {
   
   
                  String requete =  "UPDATE upcomingevents SET event_name = ?, location = ?, date_camping = ?,guide = ?,id_guide = ? WHERE event_number ="+event_nu;
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, u.getEvent_name());
            pst.setString(2, u.getLocation());
            pst.setDate(3, u.getDate_camping());
            pst.setString(4, u.getGuide());
            pst.setInt(5, u.getId_guide());
           
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
        public   List <upcomingevents> search(int event_number){
        
      List <upcomingevents> List = new ArrayList<>();
        try{
            
            String requete = "SELECT event_number FROM upcomingevents WHERE event_number=?"  ;
            Statement pste = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs =  pste.executeQuery(requete);
            while (rs.next()){
                
            upcomingevents u = new upcomingevents();
            u.setEvent_number(rs.getInt("event_number"));
            u.setEvent_name(rs.getString("event_name"));
            u.setLocation(rs.getString("location"));
            u.setDate_camping(rs.getDate("date_caming"));
            u.setGuide(rs.getString("guide"));
            
                
                     List.add(u);

            }
         
        }

        catch(SQLException k){
System.out.println(k.getMessage());         }
        return List;
        
    } 
        public List<Integer> verife(String v) throws SQLException {
        List<Integer> l = new ArrayList();
         int id=0;
        try {
       String query2="select id from guide where nom="+v;
                Statement smt = MyConnection.getInstance().getCnx().createStatement();
                ResultSet rs= smt.executeQuery(query2);
               while(rs.next()){
                   id = rs.getInt("id");
                   l.add(id);
                           }
                //System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;


    }
}

  
    

