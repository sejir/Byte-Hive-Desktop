/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.entites;

import java.sql.Date;

/**
 *
 * @author user
 */
public class EquipementLouer {
    private int idEquipement;
    private String nomEquipement;
    private float prixEquipement;
    private String descriptionEquipement;
    private String imageEquipement;
    private Date dateEmprunt;
    private Date dateRemise;
    private int idFournisseur;
    private int idClient;
    private int disponibilite;
    
    public EquipementLouer() {
    }

    public EquipementLouer(int idEquipement, String nomEquipement, float prixEquipement, String descriptionEquipement, String imageEquipement, int idFournisseur,int idClient,int disponibilite) {
        this.idEquipement = idEquipement;
        this.nomEquipement = nomEquipement;
        this.prixEquipement = prixEquipement;
        this.descriptionEquipement = descriptionEquipement;
        this.imageEquipement = imageEquipement;
        this.idFournisseur = idFournisseur;
        this.idClient = idClient;
        this.disponibilite = disponibilite;
    }

    public EquipementLouer(int idEquipement, String nomEquipement, float prixEquipement, String descriptionEquipement, String imageEquipement, Date dateEmprunt, Date dateRemise, int idFournisseur ,int idClient,int disponibilite) {
        this.idEquipement = idEquipement;
        this.nomEquipement = nomEquipement;
        this.prixEquipement = prixEquipement;
        this.descriptionEquipement = descriptionEquipement;
        this.imageEquipement = imageEquipement;
        this.dateEmprunt = dateEmprunt;
        this.dateRemise = dateRemise;
        this.idFournisseur = idFournisseur;
        this.idClient = idClient;
        this.disponibilite = disponibilite;
    }

    public EquipementLouer(int i, String ben_Salah, int i0, String hedi, String fd, int i1, Date date, Date date0, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(Date dateRemise) {
        this.dateRemise = dateRemise;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public String toString() {
        return "Id de l'équipement:" + idEquipement + "Nom de l'équipement:" + nomEquipement +"Prix de l'équipement:" + prixEquipement + "Description de l'équipement:" + descriptionEquipement + "Image de l'équipement:" + imageEquipement + "Date de l'emprunt :" + dateEmprunt + "Date de la remise :" + dateRemise +"Id du fournisseur:" + idFournisseur + "Id du client:" + idClient + "disponibilite" + disponibilite ; 
    }
    
    
    
}
