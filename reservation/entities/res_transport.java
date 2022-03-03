/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entities;

import java.sql.Date;

/**
 *
 * @author Sejir
 */
public class res_transport {
    private int id;
    private String type;
    private int nb_personnes;
    private Date dates;

    public res_transport() {
    }

 
    @Override
    public String toString() {
        return "res_transport{" + "id=" + id + ", type=" + type + ", nb_personnes=" + nb_personnes + ", date=" + dates + '}';
    }

    public res_transport( String type, int nb_personnes, Date dates) {
        //this.id = id;
        this.type = type;
        this.nb_personnes = nb_personnes;
        this.dates = dates;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getNb_personnes() {
        return nb_personnes;
    }

    public Date getDates() {
        return dates;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNb_personnes(int nb_personnes) {
        this.nb_personnes = nb_personnes;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    
}
