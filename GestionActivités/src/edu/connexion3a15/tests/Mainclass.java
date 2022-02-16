/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.tests;

import edu.connexion3a15.entities.activites;
import edu.connexion3a15.services.activitescrud;
import edu.connexion3a15.utiles.Myconnection;
import java.sql.Date;
/**
 *
 * @author chiha
 */
public class Mainclass {
    public static void main(String[] args) {
        
// activites a = new activites("zza", "bla",new Date (20,20,20),new Date (20,20,21), "thinia");
          
    activitescrud pcd = new activitescrud();
   // pcd.ajouteractivites(a);
    // pcd.modifieractivites(a, 18);
        //pcd.delete(18);
        
   System.out.println (pcd.search(24));
        
      }}
