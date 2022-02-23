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
public class Admin {
    private int idadmin;
    private String nom;
    private String prenom ;
    private int cin;
    private String email;
 public Admin(){
     
 }

    public Admin(int idadmin, String nom, String prenom, int cin, String email) {
        this.idadmin = idadmin;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
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

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" + "idadmin=" + idadmin + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", email=" + email + '}';
    }
 
}
