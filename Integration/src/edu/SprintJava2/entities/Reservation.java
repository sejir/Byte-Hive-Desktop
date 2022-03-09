/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

import java.util.Date;

/**
 *
 * @author Sejir
 */
public class Reservation {
    private int IdRes;
    private String NomClient;
    private String PrenomC;
    private int IdAct;
    
    private int Nbre_Perso;
    private int NumCabR;

    

  
    public Reservation() {
    }

 
    @Override
    public String toString() {
        return "res_Act{" + "IdRes=" + IdRes + ", NomClient=" + NomClient + ", PrenomC="+ PrenomC + ", IdAct=" + IdAct +",Nbre_Perso="+ Nbre_Perso +",NumC="+ NumCabR+"}";
    }

    public Reservation(String NomClient,String PrenomC,int IdAct, int Nbre_Perso,int NumCabR) {
        //this.id = id;
        this.NomClient = NomClient;
        this.PrenomC = PrenomC;
        this.IdAct = IdAct;
        
        this.Nbre_Perso=Nbre_Perso;
         this.NumCabR=NumCabR;
         
    }

  
    public int getNumCabR() {
        return NumCabR;
    }

    public void setNumCabR(int NumCabR) {
        this.NumCabR = NumCabR;
    }

    public void setIdRes(int IdRes) {
        this.IdRes = IdRes;
    }

    public void setPrenomC(String PrenomC) {
        this.PrenomC = PrenomC;
    }

    public int getIdRes() {
        return IdRes;
    }

    public String getNomClient() {
        return NomClient;
    }

    public int getIdAct() {
        return IdAct;
    }

   

    public String getPrenomC() {
        return PrenomC;
    }

    public void setNomClient(String NomClient) {
        this.NomClient = NomClient;
    }

    public void setIdAct(int IdAct) {
        this.IdAct = IdAct;
    }

    
    
      public void setNbre_Perso(int Nbre_Perso) {
        this.Nbre_Perso = Nbre_Perso;
    }

    public int getNbre_Perso() {
        return Nbre_Perso;
    }

    
    
}
