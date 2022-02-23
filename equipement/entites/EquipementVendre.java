/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.entites;

/**
 *
 * @author user
 */
public class EquipementVendre {
    private int idEquipement;
    private String nomEquipement;
    private float prixEquipement;
    private String descriptionEquipement;
    private String imageEquipement;
    private int idFournisseur;
    private int quantiteEquipement;

    public EquipementVendre() {
    }

    public EquipementVendre(int idEquipement, String nomEquipement, float prixEquipement, String descriptionEquipement, String imageEquipement,int quantiteEquipement,int idFournisseur) {
        this.idEquipement = idEquipement;
        this.nomEquipement = nomEquipement;
        this.prixEquipement = prixEquipement;
        this.descriptionEquipement = descriptionEquipement;
        this.imageEquipement = imageEquipement;
        this.quantiteEquipement = quantiteEquipement;
        this.idFournisseur = idFournisseur;
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

    public float getPrixEquipement() {
        return prixEquipement;
    }

    public void setPrixEquipement(float prixEquipement) {
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

    
    public int getQuantiteEquipement() {
        return quantiteEquipement;
    }

    public void setQuantiteEquipement(int quantiteEquipement) {
        this.quantiteEquipement = quantiteEquipement;
    }
    
    @Override
    public String toString() {
        return "Id de l'équipement:" + idEquipement + "Nom de l'équipement:" + nomEquipement +"Prix de l'équipement:" + prixEquipement + "Description de l'équipement:" + descriptionEquipement + "Image de l'équipement:" + imageEquipement + "Id du fournisseur:" + idFournisseur+ "Quantite des équipements:" + quantiteEquipement; 
    }
}
