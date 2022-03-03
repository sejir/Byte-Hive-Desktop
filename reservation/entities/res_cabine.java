package reservation.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sejir
 */
public class res_cabine {
    private int id;
    private int num;
    private int nb_personnes;
    private String type;
    private float prix;
public res_cabine() {
    }
    public res_cabine(int id, int num, int nb_personnes, String type, float prix) {
        this.id = id;
        this.num = num;
        this.nb_personnes = nb_personnes;
        this.type = type;
        this.prix = prix;
    }

  

    @Override
    public String toString() {
        return "res_cabine{" + "id=" + id + ", num=" + num + ", nb_personnes=" + nb_personnes + ", type=" + type + ", prix=" + prix + '}';
    }

    

    public int getId() {
        return id;
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
