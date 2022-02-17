/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Feryel Derouich
 */
public class Localisation {
    
    private int id;
    
    public Localisation(int id){
        this.id = id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
}
