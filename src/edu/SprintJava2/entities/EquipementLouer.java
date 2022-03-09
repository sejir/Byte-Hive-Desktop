/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

import java.sql.Date;

/**
 *
 * @author user
 */
public class EquipementLouer {
    private int idEquipement;
    private String nomEquipement;
    private String prixEquipement;
    private String descriptionEquipement;
    private String imageEquipement;
    private int idFournisseur;
    private int disponibilite;
    private Double rating;


    
    
    public EquipementLouer() {
    }

    public EquipementLouer(int idEquipement, String nomEquipement, String prixEquipement, String descriptionEquipement, String imageEquipement, int idFournisseur,int disponibilite) {
        this.idEquipement = idEquipement;
        this.nomEquipement = nomEquipement;
        this.prixEquipement = prixEquipement;
        this.descriptionEquipement = descriptionEquipement;
        this.imageEquipement = imageEquipement;
        this.idFournisseur = idFournisseur;
        this.disponibilite = disponibilite;
    }

    public EquipementLouer(int idEquipement, String nomEquipement, String prixEquipement, String descriptionEquipement, String imageEquipement, int idFournisseur, int disponibilite, Double rating) {
        this.idEquipement = idEquipement;
        this.nomEquipement = nomEquipement;
        this.prixEquipement = prixEquipement;
        this.descriptionEquipement = descriptionEquipement;
        this.imageEquipement = imageEquipement;
        this.idFournisseur = idFournisseur;
        this.disponibilite = disponibilite;
        this.rating = rating;
    }

//    public EquipementLouer(int i, String ben_Salah, int i0, String hedi, String fd, int i1, Date date, Date date0, int i2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


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

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }
    
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Id de l'équipement:" + idEquipement + "Nom de l'équipement:" + nomEquipement +"Prix de l'équipement:" + prixEquipement + "Description de l'équipement:" + descriptionEquipement + "Image de l'équipement:" + imageEquipement + "Id du fournisseur:" + idFournisseur + "disponibilite" + disponibilite ; 
    }
    
    
    
}
