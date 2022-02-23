/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.services;

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
public class EquipementVendreCRUD {
    public void ajouterEquipementVendre(EquipementVendre ev){
        try {
            String requete = "INSERT INTO equipementvendre(nomEquipement,prixEquipement,descriptionEquipement,imageEquipement,quantiteEquipement,idFournisseur) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, ev.getNomEquipement());
            pst.setFloat(2, ev.getPrixEquipement());
            pst.setString(3, ev.getDescriptionEquipement());
            pst.setString(4, ev.getImageEquipement());
            pst.setInt(5, ev.getQuantiteEquipement());
            pst.setInt(6, ev.getIdFournisseur());
            
            pst.executeUpdate();
            System.out.println("Element Ajouté!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    public List<EquipementVendre> listerEquipementVendre(){
        List<EquipementVendre> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM equipementvendre";
            Statement st= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                EquipementVendre ev = new EquipementVendre();
                ev.setIdEquipement(rs.getInt(1));
                ev.setNomEquipement(rs.getString(2));
                ev.setPrixEquipement(rs.getFloat(3));
                ev.setDescriptionEquipement(rs.getString(4));
                ev.setImageEquipement(rs.getString(5));
                ev.setQuantiteEquipement(rs.getInt(6));
                ev.setIdFournisseur(rs.getInt(7));
                myList.add(ev);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return myList;
       }
    
    public void modifierEquipementVendre(int id ,EquipementVendre ev)    {
     
 
        String requete = "UPDATE equipementvendre SET nomEquipement=?,prixEquipement=?,descriptionEquipement=?, imageEquipement=? , quantiteEquipement=? WHERE idEquipement =" + id;
    
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, ev.getNomEquipement());
            pst.setFloat(2, ev.getPrixEquipement());
            pst.setString(3, ev.getDescriptionEquipement());
            pst.setString(4, ev.getImageEquipement());
            pst.setInt(5, ev.getQuantiteEquipement());
             
            pst.executeUpdate();
            System.out.println("equipement modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public void supprimerEquipementVendre(int id )  {
      String requete = "DELETE FROM equipementvendre where idEquipement = ?";
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public float calculChiffreAffaire(){
        String requete = "select sum(quantiteEquipement*prixEquipement) from equipementvendre";
        float f = 0;
        try {
            PreparedStatement pst= MyConnetion.getInstance().getCnx().prepareStatement(requete);
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                f=rs.getFloat(1);
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        
        return f ;
        
    } 
}
