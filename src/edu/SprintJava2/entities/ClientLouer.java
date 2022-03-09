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
public class ClientLouer {
    private String nomClient;
    private String nomEquipement;
    private Date dateRemise;
    private String image;

    public ClientLouer() {
    }

    public ClientLouer(String nomClient, String nomEquipement, Date dateRemise,String image) {
        this.nomClient = nomClient;
        this.nomEquipement = nomEquipement;
        this.dateRemise = dateRemise;
        this.image=image;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getNomEquipement() {
        return nomEquipement;
    }

    public void setNomEquipement(String nomEquipement) {
        this.nomEquipement = nomEquipement;
    }

    public Date getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(Date dateRemise) {
        this.dateRemise = dateRemise;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
