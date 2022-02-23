/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava1.entities;

/**
 *
 * @author chayma
 */
public class Host {
    private int idhost;
    private String nom;
    private String prenom ;
    private String region ; 
    private String etat;
public Host(){
    
}
    public Host(int idhost, String nom, String prenom, String region, String etat) {
        this.idhost = idhost;
        this.nom = nom;
        this.prenom = prenom;
        this.region = region;
        this.etat = etat;
    }

    public int getIdhost() {
        return idhost;
    }

    public void setIdhost(int idhost) {
        this.idhost = idhost;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Host{" + "idhost=" + idhost + ", nom=" + nom + ", prenom=" + prenom + ", region=" + region + ", etat=" + etat + '}';
    }
  
    
}
