/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

/**
 *
 * @author chiha
 */
public class emplacement {
    public int id_emplacement;
    public String nom_emplacement;
    public String d_emplacement;
     
    
    
    public emplacement () {}
    


 public emplacement( String nom_emplacement,String d_emplacement){
    
    //this.id_act=id_act;
    this.nom_emplacement=nom_emplacement;
    this.d_emplacement=d_emplacement;
    }

    public String getD_emplacement() {
        return d_emplacement;
    }

    public void setD_emplacement(String d_emplacement) {
        this.d_emplacement = d_emplacement;
    }

 
 
 
    public int getId_emplacement() {
        return id_emplacement;
    }

    public void setId_emplacement(int id_emplacement) {
        this.id_emplacement = id_emplacement;
    }

    public String getNom_emplacement() {
        return nom_emplacement;
    }

    public void setNom_emplacement(String nom_emplacement) {
        this.nom_emplacement = nom_emplacement;
    }
 
    @Override
 public String toString() {
        return "Id_emplacement: "+id_emplacement + " Nom_emplacement: "+nom_emplacement+"d_emplacement:"+d_emplacement; 
    }
 
 
 
 
 
 
 
 
 
 
}
