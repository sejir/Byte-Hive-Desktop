/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionCamping.entities;

/**
 *
 * @author USER
 */
public class upcomingevents {
   public int event_number;
    public String event_name;
    public String location;
    public String date;
    public String guide;
    
  public upcomingevents ( ){
      
  }   
    public upcomingevents (int event_number,String event_name, String location, String date, String guide){
      this.event_number = event_number;
      this.event_name = event_name;
      this.location = location;
      this.date = date;
      this.guide = guide;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return "upcomingevents{" + "event_number=" + event_number + ", event_name=" + event_name + ", location=" + location + ", date=" + date + ", guide=" + guide + '}';
    }
  
}