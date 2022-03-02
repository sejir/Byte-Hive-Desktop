/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.security.Timestamp;

/**
 *
 * @author chayma
 */
public class Users {
    private int id ; 
    private String name ;
    private String lastname;
    private String email ; 
    private String password;
    private String role;
    private String profilePicture;
    
    public Users() {
    }

    public Users(int id, String name, String lastname, String email, String password, String role, String profilePicture) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.profilePicture = profilePicture;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", role=" + role + ", profilePicture=" + profilePicture + '}';
    }
  
}
