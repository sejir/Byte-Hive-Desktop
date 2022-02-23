/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.services;

import edu.naturecruise.entites.EquipementLouer;
import edu.naturecruise.entites.EquipementVendre;
import edu.naturecruise.utils.MyConnetion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class EquipementLouerCRUD {
    public void ajouterEquipementLouer(EquipementLouer el){
        try {
            String requete = "INSERT INTO equipementlouer(nomEquipement,prixEquipement,descriptionEquipement,imageEquipement,dateEmprunt,dateRemise,idFournisseur,idClient,disponibilite) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, el.getNomEquipement());
            pst.setFloat(2, el.getPrixEquipement());
            pst.setString(3, el.getDescriptionEquipement());
            pst.setString(4, el.getImageEquipement());
            pst.setDate(5, el.getDateEmprunt());
            pst.setDate(6, el.getDateRemise());
            pst.setInt(7, el.getIdFournisseur());
            pst.setInt(8, el.getIdClient());
            pst.setInt(9, el.getDisponibilite());
            pst.executeUpdate();
            System.out.println("Element Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    public List<EquipementLouer> listerEquipementLouer(){
        List<EquipementLouer> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM equipementlouer";
            Statement st= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementLouer el = new EquipementLouer();
                el.setIdEquipement(rs.getInt(1));
                el.setNomEquipement(rs.getString(2));
                el.setPrixEquipement(rs.getFloat(3));
                el.setDescriptionEquipement(rs.getString(4));
                el.setImageEquipement(rs.getString(5));
                el.setDateEmprunt(rs.getDate(6));
                el.setDateRemise(rs.getDate(7));
                el.setIdFournisseur(rs.getInt(8)); 
                el.setIdClient(rs.getInt(9));
                el.setDisponibilite(rs.getInt(10));
                myList.add(el);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    public void modifierEquipementLouer(int id ,EquipementLouer el)    {
     
 
        String requete = "UPDATE equipementlouer SET nomEquipement=?, prixEquipement=?,descriptionEquipement=?,imageEquipement=? , dateEmprunt=? , dateRemise=? , idFournisseur=? ,idClient=? , disponibilite=? WHERE idEquipement = " + id;
    
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, el.getNomEquipement());
            pst.setFloat(2, el.getPrixEquipement());
            pst.setString(3, el.getDescriptionEquipement());
            pst.setString(4, el.getImageEquipement());
            pst.setDate(5, el.getDateEmprunt());
            pst.setDate(6, el.getDateRemise());
            pst.setInt(7, el.getIdFournisseur());
            pst.setInt(8, el.getIdFournisseur());

             
            pst.executeUpdate();
            System.out.println("equipement modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public void supprimerEquipementLouer(int id )  {
      String requete = "DELETE FROM equipementlouer where idEquipement = ?";
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    
    }
    public void duree(){
       String requete = "select c.nomClient,el.prixEquipement FROM equipementlouer el inner join client c on el.idClient=c.idClient where dateRemise > sysdate() "; 
        
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                String s =rs.getString(1);
                float f = rs.getFloat(2);
                System.out.println("le nom du client est:" + s);
                System.out.println("le prix est:" + f);

             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        
       
    }
}
