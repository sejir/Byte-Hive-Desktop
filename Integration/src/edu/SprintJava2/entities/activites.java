/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;
import java.sql.Date;

/**
 *
 * @author chiha
 */
public class activites  {
     
    public int id_act;
    public int id_user;
    public int nb_personne;
    public String nom_act;
    public String description;
    public  Date d_debut ;
    public Date d_fin ;
    public String emplacement;
    public int idemplacement;
   public  String count ;
    
    
    public activites(){
    
    }
    
    /**
     * @param id_user
     * @param nom_act
     * @param description
     * @param d_debut
     * @param d_fin
     * @param emplacement
     *  @param idemplacement
     */
    
 
    public activites( String nom_act,String description,Date d_debut ,Date d_fin,String emplacement,int idemplacement, int nb_personne,int id_user){
    
    //this.id_act=id_act;
    this.id_user=id_user;
    this.nom_act=nom_act;
    this.d_debut=d_debut;
    this.d_fin=d_fin;
    this.description=description;
    this.emplacement=emplacement;
    this.idemplacement=idemplacement;
    this.nb_personne=nb_personne;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    
    
    
    
    
    public int getNb_personne() {
        return nb_personne;
    }

    public void setNb_personne(int nb_personne) {
        this.nb_personne = nb_personne;
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
        return "Id_act: "+id_act + "Id_user: "+id_user + " Nom_act: "+nom_act +" Emplacement:"+emplacement+"Description:"+description+"D_debut:"+d_debut+"D_fin:"+d_fin+"idemplacement:"+idemplacement;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
 
    
}
