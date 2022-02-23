/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava1.services;

import edu.SprintJava1.entities.Client;
import edu.SprintJava1.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chayma
 */
public class ClientCRUD {
    public void ajouterClient(Client c) {
       try {
           String requete = "INSERT INTO client( nom,prenom,numero_telephone,adresse,datedenaissance) VALUES (?,?,?,?,?)";
           PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
           pst.setString(1,c.getNom());
           pst.setString(2,c.getPrenom());
           pst.setInt(3, c.getNumero_telephone());
           pst.setString(4, c.getAdresse());
           pst.setString(5,c.getDatedenaissance());
           pst.executeUpdate();
           System.out.println("Client ajouteé avec succées !");
             
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
    }
    public List<Client>listerClients(){
        List<Client>myList= new ArrayList();
        try {
            String requete = "SELECT * FROM client";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()){
                Client cc = new Client();
                cc.setIdclient(rs.getInt(3));
                cc.setNom(rs.getString("nom"));
                cc.setPrenom(rs.getString("prenom"));
                cc.setNumero_telephone(rs.getInt(4));
                cc.setAdresse(rs.getString("adresse"));
                cc.setDatedenaissance(rs.getString("datedenaissance"));
                myList.add(cc); 
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList ;
    }
     public void modifierClient(String nom_e,String prenom_e,int idclient_e,int numero_telephone_e,String adresse_e,String datedenaissance_e ){
        try {
            String requete="UPDATE client SET"
                    + " `nom`='"+nom_e+"' ,`prenom`='"+prenom_e+"' , `idclient='"+idclient_e+"' , `numero_telephone`='"+numero_telephone_e+"',`adresse='"+adresse_e+"'"
                    + ",`datedenaissance` ='"+datedenaissance_e+"' , ' where `idclient`='"+idclient_e+"' ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Client modifié avec scuccés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public void supprimerClient(Client c){
        try {
            String requete="DELETE from client where idclient=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, c.getIdclient());
            pst.executeUpdate();
            System.err.println("Client supprimé avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
