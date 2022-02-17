/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Entities.Guide;
import Entities.Localisation;
import Entities.ReclamationGuide;
import Entities.ReclamationLocation;
import Entities.Utilisateur;
import Services.ReclamationGuideCRUD;
import Services.ReclamationLocationCRUD;
import java.util.List;

/**
 *
 * @author Feryel Derouich
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ReclamationLocationCRUD rec1= new ReclamationLocationCRUD();
        Utilisateur u1 = new Utilisateur(1);
        Localisation loc1 = new Localisation(1);
        ReclamationLocation rl = new ReclamationLocation(u1.getId(),loc1.getId(),"This place rocks!");
        boolean test = rec1.insertReclamationL(rl);
        if (test){
            System.out.println("yay");
        }
        else{
            System.out.println("nayy");
        }
        //List<ReclamationLocation> list = rec1.readReclamationUserL(u1);
        //System.out.println(list);
        //System.out.println(rec1.readReclamationAdminL());
        //System.out.println(rec1.deleteReclamationL(1));
        //ReclamationLocation rll = new ReclamationLocation(2,u1.getId(),"awwah",null,0,false,null,loc1.getId());
        //System.out.println(rec1.updateReclamationUserL(rll));
        // ReclamationLocation forAdmin = new ReclamationLocation("Allah ghaleb cnx tayha",2,2);
        // System.out.println(rec1.updateReclamationAdminL(forAdmin));
        // rec1.deleteReclamationL(8);
        //System.out.println(rec1.reclamationInfoL(2));
        //rec1.statistiqueL();
    
        ReclamationGuideCRUD rec2= new ReclamationGuideCRUD();
        Utilisateur u2 = new Utilisateur(1);
        Guide guide1 = new Guide(1);
        ReclamationGuide rg = new ReclamationGuide(u2.getId(),guide1.getId(),"Professional guide!");
        /*boolean test = rec2.insertReclamationG(rg);
        if (test){
            System.out.println("yes");
        }
        else{
            System.out.println("nahh");
        }*/
        
        /*List<ReclamationGuide> list2 = rec2.readReclamationUserG(u2);
        System.out.println(list2);*/
        
        //System.out.println(rec2.readReclamationAdminG());
        
        //System.out.println(rec2.deleteReclamationG(1));
        
        /*ReclamationGuide rgg = new ReclamationGuide(3,u2.getId(),0,guide1.getId(),"noope",null,false,null);
        System.out.println(rec2.updateReclamationUserG(rgg));*/
        
        /*ReclamationGuide forAdmin1 = new ReclamationGuide("thank you",2,2);
        System.out.println(rec2.updateReclamationAdminG(forAdmin1));*/
        
        //System.out.println(rec2.reclamationInfoG(2));
       
    }
    
}
