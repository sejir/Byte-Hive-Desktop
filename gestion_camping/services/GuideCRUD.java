/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionCamping.services;

import edu.GestionCamping.entities.Guide;
import edu.GestionCamping.entities.upcomingevents;
import edu.GestionCamping.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class GuideCRUD {
    public void ajouterPersonne() {
        
        try {
            String requete="INSERT INTO Guide (nom,prenom,disponoibilte,lieux)"
                    + "VALUES ('Mhamdi','Moataz','11/02/2023','Tazarka')";
            
            Statement st = MyConnection.getInstance().getCnx().createStatement();
             st.executeUpdate(requete);
            System.out.println("Guide ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
}
       
            
            

        public List<Guide> listerGuide() {
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
           
        }
         public void  UpdateGuide (int id_g, String nom_g, String prenom_g, String disponibilte_g, String lieux_g) {
            
try {
   
   
             String requete = "UPDATE Guide SET " + "`nom`='"+nom_g+"' , `prenom`='"+prenom_g+"',`disponoibilte`='"+disponibilte_g+"',`lieux`='"+lieux_g+"' where `id`='"+id_g+"'";
             PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.executeUpdate();
             System.err.println("Profile Guide  modifié ! ");

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
 