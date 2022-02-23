/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava1.services;

import edu.SprintJava1.entities.Host;
import edu.SprintJava1.utils.MyConnection;
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
 * @author chayma
 */
public class HostCRUD {
    public void ajouterHost(Host h){
        try {
            String requete = "INSERT INTO host (nom,prenom,region,etat) VALUES(?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,h.getNom());
            pst.setString(2,h.getPrenom());
            pst.setString(3,h.getRegion());
            pst.setString(4,h.getEtat());
            pst.executeUpdate();
            System.out.println("host ajouteé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
      public List<Host>listerHosts(){
          List<Host>myList = new ArrayList();
        try {
            
            String requete = "SELECT * FROM host";
            Statement st =MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Host hos = new Host();
                hos.setIdhost(rs.getInt(1));
                hos.setNom(rs.getString("nom"));
                hos.setPrenom(rs.getString("prenom"));
                hos.setRegion(rs.getString("region"));
                hos.setEtat(rs.getString("etat"));
                myList.add(hos);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
       } 
      public void  modifierHost(int idhost_e , String nom_e , String prenom_e ,String region_e , String etat_e) {
        try {
            String requete = "UPDATE host SET " + "`idhost`='"+idhost_e+"' , `nom`='"+nom_e+"' , `prenom`='"+prenom_e+"',`region`='"+region_e+"',`etat`='"+etat_e+"' where `idhost`='"+idhost_e+"'";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("element modifié avec succeés !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      }
     public void supprimerHost(Host h) {
        try {
            String requete = "DELETE FROM host where idhost=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
          pst.setInt(1,h.getIdhost());
            pst.executeUpdate();
            System.err.println("Host supprimé avec succées ! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
     }
}
