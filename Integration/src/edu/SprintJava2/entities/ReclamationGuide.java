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
public class ReclamationGuide {
    
    private int id;
    private int id_client;
    private int id_admin;
    private int id_guide;
    private String nom_guide;
    private String description;
    private String respond;
    private boolean status;
    private Date reclamationdate;

    public ReclamationGuide() {
    }

    public ReclamationGuide(int id, int id_client, int id_admin, int id_guide, String description, String respond, boolean status, Date reclamationdate) {
        this.id = id;
        this.id_client = id_client;
        this.id_admin = id_admin;
        this.id_guide = id_guide;
        this.description = description;
        this.respond = respond;
        this.status = status;
        this.reclamationdate = reclamationdate;
    }
    
    // constructeur pour le client
    public ReclamationGuide(int id_client, int id_guide, String description) {
        this.id_client = id_client;
        this.id_guide = id_guide;
        this.description = description;
    }
    
    
    
    // modification pour le client
    public ReclamationGuide(int id,int id_client, int id_guide, String description) {
        this.id_client = id_client;
        this.id_guide = id_guide;
        this.description = description;
        this.id=id;
    }
     
    // constructeur pour l'admin
    public ReclamationGuide(int id_admin, String respond) {
        this.id_admin = id_admin;
        this.respond = respond;
    }
    
    // modification pour l'admin
    public ReclamationGuide(String respond,int id,int id_admin) {
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

    public int getId_guide() {
        return id_guide;
    }

    public void setId_guide(int id_guide) {
        this.id_guide = id_guide;
    }
    
    @Override
    public String toString() {
       
        return " { ReclamationG : " +
                "Number = " + id +
                ", Client Id = " + id_client +
                ", Guide Id = " + id_guide +
                ", Description = '" + description + '\'' +
                ", Admin Respond = '" + respond + '\'' +
                ", Admin ID = " + id_admin +
                ", Treated = " + status +" \n"+
                ", Reclamation Date = " + reclamationdate +
                " }";
    }
}
