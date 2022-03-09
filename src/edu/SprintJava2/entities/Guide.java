/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Guide {
    private int id;
    public String nom;
    public String prenom;
    public String lieux;
    public Date disponoibilte;
    
    //public Guide {

    public Guide() {
    }

    public Guide(String nom, String prenom, Date disponoibilte, String lieux, int id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.disponoibilte = disponoibilte;
        this.lieux = lieux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public Date getDisponoibilte() {
        return disponoibilte;
    }

    public void setDisponoibilte(Date disponoibilte) {
        this.disponoibilte = disponoibilte;
    }

    @Override
    public String toString() {
        return "Guide{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", lieux=" + lieux + ", disponoibilte=" + disponoibilte + '}';
    }

    
   


    
  
    
    
    
}
