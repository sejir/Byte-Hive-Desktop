/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.entities;

import java.sql.Date;

/**
 *
 * @author chiha
 */
public class activites  {
     
    public int id_act;
    public String nom_act;
    public String description;
    public  Date d_debut ;
    public Date d_fin ;
    public String emplacement;
    public int idemplacement;
    
    
    public activites(){
    
    }
    
    /**
     *
     * @param nom_act
     * @param description
     * @param d_debut
     * @param d_fin
     * @param emplacement
     *  @param idemplacement
     */
    
 
    public activites( String nom_act,String description,Date d_debut ,Date d_fin,String emplacement,int idemplacement){
    
    //this.id_act=id_act;
    this.nom_act=nom_act;
    this.d_debut=d_debut;
    this.d_fin=d_fin;
    this.description=description;
    this.emplacement=emplacement;
    this.idemplacement=idemplacement;
    }

    public int getIdemplacement() {
        return idemplacement;
    }

    public void setIdemplacement(int idemplacement) {
        this.idemplacement = idemplacement;
    }
    
 
    

    public void setD_debut(Date d_debut) {
        this.d_debut = d_debut;
    }

    public void setD_fin(Date d_fin) {
        this.d_fin = d_fin;
    }

   

     

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public void setNom_act(String nom_act) {
        this.nom_act = nom_act;
    }

    public Date getD_debut() {
        return d_debut;
    }

    public Date getD_fin() {
        return d_fin;
    }

   

    public String getDescription() {
        return description;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public int getId_act() {
        return id_act;
    }

    public String getNom_act() {
        return nom_act;
    }
    
    @Override
    public String toString() {
        return "Id_act: "+id_act + " Nom_act: "+nom_act +" Emplacement:"+emplacement+"Description:"+description+"D_debut:"+d_debut+"D_fin:"+d_fin+"idemplacement:"+idemplacement;
    }

   
    
    
    
}
