/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionCamping.tests;

import com.teamdev.jxmaps.v;
import edu.GestionCamping.entities.Guide;
import edu.GestionCamping.services.GuideCRUD;
import edu.GestionCamping.entities.upcomingevents;
import edu.GestionCamping.services.upcomingeventCRUD;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author USER
 */
public class MainClass {
    public static void main (String[] args ) throws SQLException {
    //MyConnection mc = new MyConnection();
    GuideCRUD gu = new GuideCRUD();
    Guide g = new Guide("mounir", "sami", new Date(20, 20, 21), "korba", 0);
    upcomingeventCRUD upe = new upcomingeventCRUD();
        //List<Integer> id = upe.verife("tarek");
        //System.out.println(id.get(0));
        upcomingevents u;
        u = new upcomingevents("yen", "ko", new Date(20, 20, 20), "tarek",47);
  //  gu.ajouterPersonne(g);
   // gu.UpdateGuide(g, 0);
    //gu.SupprimerGuide(g);
     //  upe.ajouterupcomingevents(u);
    //upe.Updateupcomingevents(u, 0);
    //upe.SupprimerUpcomingevents(u);
      System.out.println(gu.listerGuide());
      System.out.println(upe.listerupcomingevents());
    } 


 
    
}
