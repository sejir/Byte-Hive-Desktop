/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.entities;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class upcomingevents {
   public int event_number;
    public String event_name;
    public String location;
    public Date date_camping;
    public String guide;
    public int id_guide;
    public upcomingevents getEvent_number;
    
  public upcomingevents ( ){
      
  }   
    public upcomingevents (String event_name, String location,Date date_camping, String guide,int id_guide){
      this.event_number = event_number;
      this.event_name = event_name;
      this.location = location;
      this.date_camping = date_camping;
      this.guide = guide;
      this.id_guide = id_guide;
  }

    public upcomingevents(int id_guide) {
        this.id_guide = id_guide;
    }

    public upcomingevents(String rayen, String korba, Date date, String tarek, int i, List<Integer> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getId_guide() {
        return id_guide;
    }

    public void setId_guide(int id_guide) {
        this.id_guide = id_guide;
    }

    public int getEvent_number() {
        return event_number;
    }

    public void setEvent_number(int event_number) {
        this.event_number = event_number;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate_camping() {
        return date_camping;
    }

    public void setDate_camping(Date date_camping) {
        this.date_camping = date_camping;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return "upcomingevents{" + "event_number=" + event_number + ", event_name=" + event_name + ", location=" + location + ", date_camping=" + date_camping + ", guide=" + guide + ", id_guide=" + id_guide + ", getEvent_number=" + getEvent_number + '}';
    }

   

   


  
}