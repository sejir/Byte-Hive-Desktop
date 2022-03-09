/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

/**
 *
 * @author Feryel Derouich
 */
public class Localisation {
    
    private int id;
    private String description;

    public Localisation() {
    }

    
    public Localisation(int id, String description) {
        this.id = id;
        this.description = description;
    }
    
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
       
        return " { Localisation : " +
                "Number =" + id +
                ", Description=" + description +
                " }";
    }
}
