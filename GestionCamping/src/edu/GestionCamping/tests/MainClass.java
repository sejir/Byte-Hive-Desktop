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
/**
 *
 * @author USER
 */
public class MainClass {
    public static void main (String[] args ) {
    //MyConnection mc = new MyConnection();
    GuideCRUD gu = new GuideCRUD();
    Guide g = new Guide (1,"Mhamdi","Moataz","11/02/2023","Tazarka");
    upcomingeventCRUD upe = new upcomingeventCRUD();
        upcomingevents u;
        u = new upcomingevents(1,"ByteHive","Tazarka","11/02/2023","moataz mhamdi");
    gu.ajouterPersonne();
    gu.UpdateGuide(1,"Mhamdi","Moataz","11/01/2024","Tazarka");
    gu.SupprimerGuide(g);
    upe.ajouteupcomingeventCRUD();
    upe.Updateupcomingevents (1, "ByteHive", "Tazarka", "11/01/2024","Chiheb Aroua");
    upe.SupprimerUpcomingevents(u);
      System.out.println(gu.listerGuide());
      System.out.println(upe.listerupcomingevents());
    } 


 
    
}
