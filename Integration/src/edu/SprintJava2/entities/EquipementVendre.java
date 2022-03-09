/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

import edu.SprintJava2.utlis.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class EquipementVendre {
    private int idEquipement;
    private String nomEquipement;
    private String prixEquipement;
    private String descriptionEquipement;
    private String imageEquipement;
    private int idFournisseur;
    private String quantiteEquipement;
    private Double rating;

    public EquipementVendre() {
    }

    public EquipementVendre(int idEquipement, String nomEquipement, String prixEquipement, String descriptionEquipement, String imageEquipement,String quantiteEquipement,int idFournisseur) {
        this.idEquipement = idEquipement;
        this.nomEquipement = nomEquipement;
        this.prixEquipement = prixEquipement;
        this.descriptionEquipement = descriptionEquipement;
        this.imageEquipement = imageEquipement;
        this.quantiteEquipement = quantiteEquipement;
        this.idFournisseur = idFournisseur;
    }

    

    public EquipementVendre(int idEquipement, String nomEquipement, String prixEquipement, String descriptionEquipement, String imageEquipement, int idFournisseur, String quantiteEquipement, Double rating) {
        this.idEquipement = idEquipement;
        this.nomEquipement = nomEquipement;
        this.prixEquipement = prixEquipement;
        this.descriptionEquipement = descriptionEquipement;
        this.imageEquipement = imageEquipement;
        this.idFournisseur = idFournisseur;
        this.quantiteEquipement = quantiteEquipement;
        this.rating = rating;
    }

    public int getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    public String getNomEquipement() {
        return nomEquipement;
    }

    public void setNomEquipement(String nomEquipement) {
        this.nomEquipement = nomEquipement;
    }

    public String getPrixEquipement() {
        return prixEquipement;
    }

    public void setPrixEquipement(String prixEquipement) {
        this.prixEquipement = prixEquipement;
    }

    public String getDescriptionEquipement() {
        return descriptionEquipement;
    }

    public void setDescriptionEquipement(String descriptionEquipement) {
        this.descriptionEquipement = descriptionEquipement;
    }

    public String getImageEquipement() {
        return imageEquipement;
    }

    public void setImageEquipement(String imageEquipement) {
        this.imageEquipement = imageEquipement;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    
    public String getQuantiteEquipement() {
        return quantiteEquipement;
    }

    public void setQuantiteEquipement(String quantiteEquipement) {
        this.quantiteEquipement = quantiteEquipement;
    }
    
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    
    @Override
    public String toString() {
        return "Id de l'équipement:" + idEquipement + "Nom de l'équipement:" + nomEquipement +"Prix de l'équipement:" + prixEquipement + "Description de l'équipement:" + descriptionEquipement + "Image de l'équipement:" + imageEquipement + "Id du fournisseur:" + idFournisseur+ "Quantite des équipements:" + quantiteEquipement; 
    }

    
    
    
}
