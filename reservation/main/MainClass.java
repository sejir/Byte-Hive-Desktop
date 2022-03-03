/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.main;
import reservation.entities.res_cabine;
import reservation.utils.MyConnection;
import reservation.services.res_cabineCRUD;
import reservation.services.res_transportCRUD;
import reservation.entities.res_transport;
import java.sql.Date;
/**
 *
 * @author Sejir
 */
public class MainClass {
   
    public static void main(String[] args) {
         Date d1= new Date(120,0,17);
        //MyConnection mc= new MyConnection();
        //res_cabineCRUD resc=new res_cabineCRUD();
      
      //  res_cabine M=new res_cabine(52,2,10,"bungalow",200);
        res_transport T=new res_transport("chiheb", 10, d1);                                                                                                                                                                               
        
        //res_transport T1=new res_transport("Mohsen", 10, new Date (2020,10,10));
        res_transportCRUD pcd = new res_transportCRUD() ;
        pcd.ajouterTransport(T);
        //pcd.deleteTransport(1);
        System.out.println(pcd.listerTransport());
        //pcd.modifierTransport(T1, 1);
                //res_cabine D=new res_cabine(52,2,10,"mediocre",200);
      //  resc.ajouterCabine(M);
        //  System.out.println(resc.listerCabine());
       //   resc.deleteCabine(1);
        //  resc.modifierCabine(D, 2);
    }
    
}
