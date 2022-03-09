package edu.SprintJava2.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sejir
 */
public class Cabine {
    private int id;
    private int num;
    private int nb_personnes;
    private String type;
    private float prix;
    private int Dispo;
public Cabine() {
    }
    public Cabine(int id, int num, int nb_personnes, String type, float prix,int Dispo) {
        this.id = id;
        this.num = num;
        this.nb_personnes = nb_personnes;
        this.type = type;
        this.prix = prix;
        this.Dispo =Dispo;
    }

  

    @Override
    public String toString() {
        return "res_cabine{" + "id=" + id + ", num=" + num + ", nb_personnes=" + nb_personnes + ", type=" + type + ", prix=" + prix +", Dispo=" + Dispo + '}';
    }

    

    public int getId() {
        return id;
    }

    public int getDispo() {
        return Dispo;
    }

    public void setDispo(int Dispo) {
        this.Dispo = Dispo;
    }

    public int getNum() {
        return num;
    }

    public int getNb_personnes() {
        return nb_personnes;
    }

    public String getType() {
        return type;
    }

    public float getPrix() {
        return prix;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNb_personnes(int nb_personnes) {
        this.nb_personnes = nb_personnes;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
      public void setId(int id) {
        this.id = id;
    }
}
