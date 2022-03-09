/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.main;
import Reservation.entities.Cabine;
import reservation.utils.MyConnection;
import reservation.services.ReservationCRUD;
import reservation.services.CabineCRUD;
import reservation.entities.Reservation;
import java.sql.Date;
/**
 *
 * @author Sejir
 */
public class MainClass {
   
    public static void main(String[] args) {
      
        //MyConnection mc= new MyConnection();
        //res_cabineCRUD resc=new res_cabineCRUD();
      
      //  res_cabine M=new res_cabine(52,2,10,"bungalow",200);
         //Reservation T=new Reservation("dsds","ssd", 10, 5,5);                                                                                                                                                                               
        
        //res_transport T1=new res_transport("Mohsen", 10, new Date (2020,10,10));
        ReservationCRUD pcd = new ReservationCRUD();
       
        CabineCRUD a=new CabineCRUD();
        Cabine ab=new Cabine();
        CabineCRUD c=new CabineCRUD();
       float x=c.recupererPrixCabine(ab,54);
         float m = 0;
         
        System.out.println(x);
//pcd.deleteTransport(1);
       //System.out.println(pcd.listerResevation());
        //pcd.modifierTransport(T1, 1);
                //res_cabine D=new res_cabine(52,2,10,"mediocre",200);
      //  resc.ajouterCabine(M);
        //  System.out.println(resc.listerCabine());
       //   resc.deleteCabine(1);
        //  resc.modifierCabine(D, 2);
    }
    
}
