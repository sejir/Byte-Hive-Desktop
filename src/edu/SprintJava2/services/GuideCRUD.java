/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import edu.SprintJava2.entities.Guide;
import edu.SprintJava2.utlis.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author USER
 */
public class GuideCRUD {
    public void ajouterPersonne(Guide g) {
        
        try {
          String requete =" INSERT INTO Guide(nom,prenom,lieux,Disponoibilte) VALUES (?,?,?,?) ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, g.getNom());
            pst.setString(2, g.getPrenom());
            pst.setString(3, g.getLieux());
            pst.setDate(4, g.getDisponoibilte());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
}
       
            
            

    /*    public List<Guide> listerGuide() {
        List<Guide> myList = new ArrayList();
            try {            

            String requete ="SELECT * FROM Guide ";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
                ResultSet rs = st.executeQuery(requete);
                while(rs.next()){
                    Guide gui = new Guide();
                    gui.setId(rs.getInt(1));
                    gui.setNom(rs.getString("nom"));
                    gui.setPrenom(rs.getString("prenom"));
                    gui.setDisponoibilte(rs.getString("disponoibilte"));
                    gui.setLieux(rs.getString("lieux"));
                    myList.add(gui);
                }
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());   
        }
        return myList;
           
        } */
            public ObservableList <Guide> listerGuide () {
         ObservableList <Guide> List = FXCollections.observableArrayList();
            try {            

            String requete ="SELECT * FROM Guide ";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
                ResultSet rs = st.executeQuery(requete);
                while(rs.next()){
                    Guide gui = new Guide();
                    gui.setId(rs.getInt(1));
                    gui.setNom(rs.getString("nom"));
                    gui.setPrenom(rs.getString("prenom"));
                    gui.setDisponoibilte(rs.getDate("disponoibilte"));
                    gui.setLieux(rs.getString("lieux"));
                    List.add(gui);
                }
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());   
        }
        return List;
           
        }
      /*   public void  UpdateGuide (int id_g, String nom_g, String prenom_g, String disponibilte_g, String lieux_g) {
            
try {
   
   
             String requete = "UPDATE Guide SET " + "`nom`='"+nom_g+"' , `prenom`='"+prenom_g+"',`disponoibilte`='"+disponibilte_g+"',`lieux`='"+lieux_g+"' where `id`='"+id_g+"'";
             PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.executeUpdate();
             System.err.println("Profile Guide  modifié ! ");

         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }

        }*/
                    public void UpdateGuide (Guide g, int id_g) {
            
try {
   
   
                  String requete =  "UPDATE Guide SET nom = ?, prenom = ?, lieux = ?,disponoibilte = ? WHERE id ="+id_g;
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, g.getNom());
            pst.setString(2, g.getPrenom());
            pst.setString(3, g.getLieux());
            pst.setDate(4, g.getDisponoibilte());
           
             pst.executeUpdate();
             System.err.println("Guide modifié ! ");

         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }

        }
        public void SupprimerGuide (Guide g){
              try {
             String requete = "DELETE FROM Guide where id=?";
             PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.setInt(1,g.getId());
             pst.executeUpdate();
             System.err.println("Profile Guide supprimé ! ");
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
        }

}
 