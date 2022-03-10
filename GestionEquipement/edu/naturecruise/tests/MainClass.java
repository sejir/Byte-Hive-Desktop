/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.tests;

import edu.naturecruise.entites.EquipementLouer;
import edu.naturecruise.entites.EquipementVendre;
//import edu.naturecruise.entites.JavaMail;
import edu.naturecruise.services.EquipementLouerCRUD;
import edu.naturecruise.services.EquipementVendreCRUD;
import java.sql.Date;

/**
 *
 * @author user
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       // JavaMail.sendMail("behija.benghorbel@esprit.tn");
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        EquipementLouerCRUD elc = new EquipementLouerCRUD();
        System.out.println(elc.clientEquip()+"                               ");

        /// EquipementLouer el1 = new EquipementLouer(1,"tezdazdazdnte",33,"pour camping","url image",1,1);
        //EquipementLouer el2 = new EquipementLouer(1,"sac de couchage",20,"pour homme","url image",2,1);
        EquipementVendre ev1 = new EquipementVendre(0, "tente", "100","pour camping","url image", "9", 9);
        EquipementVendre ev2 = new EquipementVendre(0, "sac ", "50"," pour homme","url image", "9", 20);
        
//        evc.ajouterEquipementVendre(ev1);
//        evc.ajouterEquipementVendre(ev2);
//elc.ajouterEquipementLouer(el1);
//        elc.ajouterEquipementLouer(el2);

        
        
//    //    System.out.println(elc.listerEquipementLouer());
  //      elc.duree();
//        System.out.println(evc.listerEquipementVendre()); 
//        
        evc.modifierEquipementVendre(5,ev2);
//        elc.modifierEquipementLouer(,el2);
//        
//        System.out.println(elc.listerEquipementLouer());
//        System.out.println(evc.listerEquipementVendre());        
//        
      // System.out.println(evc.calculChiffreAffaire());
//        
       evc.supprimerEquipementVendre(5);        
//        elc.supprimerEquipementLouer(1);        

       

    }
    
}
