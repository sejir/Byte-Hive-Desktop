/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Feryel Derouich
 */
public class Guide {
    
    private int id;
    public String nom;

    public Guide() {
    }
    
    public Guide(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
    @Override
    public String toString() {
       
        return " { Guide : " +
                "Number = " + id +
                ", Nom = " + nom +
                " }";
    }
}
