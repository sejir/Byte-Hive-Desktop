/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionCamping.tests;

import edu.GestionCamping.entities.Guide;
import edu.GestionCamping.services.GuideCRUD;
import edu.GestionCamping.entities.upcomingevents;
import edu.GestionCamping.services.upcomingeventCRUD;
import java.sql.Date;
/**
 *
 * @author USER
 */
public class MainClass {
    public static void main (String[] args ) {
    //MyConnection mc = new MyConnection();
    GuideCRUD gu = new GuideCRUD();
    Guide g = new Guide("tarek", "sami", new Date(20, 20, 21), "korba", 0);
    upcomingeventCRUD upe = new upcomingeventCRUD();
        upcomingevents u;
        u = new upcomingevents("afkkr", "korba", new Date(20, 20, 20), "tarek", 0);
    gu.ajouterPersonne(g);
   // gu.UpdateGuide(g, 0);
    //gu.SupprimerGuide(g);
   // upe.ajouterupcomingevents(u);
    //upe.Updateupcomingevents(u, 0);
    //upe.SupprimerUpcomingevents(u);
      System.out.println(gu.listerGuide());
      //System.out.println(upe.listerupcomingevents());
    } 


 
    
}
