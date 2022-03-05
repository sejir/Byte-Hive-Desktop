/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

import java.util.Date;

/**
 *
 * @author chayma
 */
public class Contact {
    private int id ;
    private String name;
    private String Email;
    private String date;
    private String description;

    public Contact() {
    }

    public Contact(int id, String name, String Email, String date, String description) {
        this.id = id;
        this.name = name;
        this.Email = Email;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", name=" + name + ", Email=" + Email + ", date=" + date + ", description=" + description + '}';
    }
    
}
