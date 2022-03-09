/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

import java.sql.Date;

/**
 *
 * @author Feryel Derouich
 */
public class ReclamationLocation {
    
    private int id;
    private int id_client;
    private int id_admin;
    private int id_localisation;
    private String description;
    private String respond;
    private boolean status;
    private Date reclamationdate;
    
    public ReclamationLocation() {
    }

    public ReclamationLocation(int id, int id_client, String description, String respond, int id_admin, boolean status,Date date,int id_localisation) {
        this.id = id;
        this.id_client = id_client;
        this.description = description;
        this.respond = respond;
        this.id_admin = id_admin;
        this.status = status;
        this.reclamationdate=date;
        this.id_localisation = id_localisation;
    }
    
    // constructeur pour le client
    public ReclamationLocation(int id_client, int id_localisation, String description) {
        this.id_client = id_client;
        this.id_localisation = id_localisation;
        this.description = description;
    }
    
    // modification pour le client
     public ReclamationLocation(int id,int id_client, int id_localisation, String description) {
        this.id_client = id_client;
        this.id_localisation = id_localisation;
        this.description = description;
        this.id=id;
    }
     
       // constructeur pour l'admin
      public ReclamationLocation(int id_admin, String respond) {
        this.id_admin = id_admin;
        this.respond = respond;
    }
      
      // modification pour l'admin
       public ReclamationLocation(String respond,int id,int id_admin) {
        this.id=id;
        this.id_admin = id_admin;
        this.respond = respond;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRespond() {
        return respond;
    }

    public void setRespond(String respond) {
        this.respond = respond;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public Date getReclamationdate() {
        return reclamationdate;
    }

    public void setReclamationdate(Date reclamationdate) {
        this.reclamationdate = reclamationdate;
    }
    
    public int getId_localisation() {
        return id_localisation;
    }

    public void setId_localisation(int id_localisation) {
        this.id_localisation = id_localisation;
    }


    @Override
    public String toString() {
       
        return " { ReclamationL : " +
                " Number = " + id +
                ", Client Id = " + id_client +
                ", Location Id = " + id_localisation +
                ", Description = '" + description + '\'' +
                ", Admin Respond = '" + respond + '\'' +
                ", Admin ID = " + id_admin +
                ", Treated = " + status +" \n"+
                ", Reclamation Date = " + reclamationdate +
                " }";
    }
    
}
