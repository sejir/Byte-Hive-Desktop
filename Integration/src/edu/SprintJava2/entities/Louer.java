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
public class Louer {
    private int idLouer;
    private Date dateEmprunt;
    private Date dateRemise;
    private int idEquipement;
    private int idClient;

    public Louer() {
    }

    public Louer(int idLouer, Date dateEmprunt, Date dateRemise,int idEquipement, int idClient) {
        this.idLouer = idLouer;
        this.dateEmprunt = dateEmprunt;
        this.dateRemise = dateRemise;
        this.idEquipement = idEquipement;
        this.idClient = idClient;
    }

    public int getIdLouer() {
        return idLouer;
    }

    public void setIdLouer(int idLouer) {
        this.idLouer = idLouer;
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

    public int getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Louer{" + "idLouer=" + idLouer + ", dateEmprunt=" + dateEmprunt + ", dateRemise=" + dateRemise + ", idEquipement=" + idEquipement + ", idClient=" + idClient + '}';
    }

}
