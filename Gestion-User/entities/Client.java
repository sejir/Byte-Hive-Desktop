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
public class Client {
    private String nom; 
    private String prenom ;
    private int idclient;
    private int numero_telephone;
    private String adresse;
    private String datedenaissance ;
  
    public Client () {
        
    }

    public Client(String nom, String prenom, int idclient, int numero_telephone, String adresse, String datedenaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.idclient = idclient;
        this.numero_telephone = numero_telephone;
        this.adresse = adresse;
        this.datedenaissance = datedenaissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIdclient() {
        return idclient;
    }

    public int getNumero_telephone() {
        return numero_telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setNumero_telephone(int numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", prenom=" + prenom + ", idclient=" + idclient + ", numero_telephone=" + numero_telephone + ", adresse=" + adresse + ", datedenaissance=" + datedenaissance + '}';
    }
    
}

        
        
