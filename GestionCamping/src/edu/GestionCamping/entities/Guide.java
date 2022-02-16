/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionCamping.entities;

/**
 *
 * @author USER
 */
public class Guide {
    private int id;
    private String nom;
    private String prenom;
    public String lieux;
    public String disponoibilte;
    
    //public Guide {

    public Guide() {
    }

    public Guide(int id, String nom, String prenom, String disponoibilte, String lieux) {
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

    public String getDisponoibilte() {
        return disponoibilte;
    }

    public void setDisponoibilte(String disponoibilte) {
        this.disponoibilte = disponoibilte;
    }

    @Override
    public String toString() {
        return "Guide{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", lieux=" + lieux + ", disponoibilte=" + disponoibilte + '}';
    }



    
  
    
    
    
}
