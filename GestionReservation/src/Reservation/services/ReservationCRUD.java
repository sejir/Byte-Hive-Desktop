/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reservation.entities.Reservation;
import reservation.utils.MyConnection;


/**
 *
 * @author Sejir
 */
public class ReservationCRUD {
      public void ajouterResevation(Reservation T){
        try {
            String requete="INSERT INTO res_act(NomClient,PrenomC,IdAct,Nbre_Perso,NumC)Values(?,?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
        pst.setString(1, T.getNomClient());
        pst.setString(2, T.getPrenomC());
        
        pst.setInt(3, T.getIdAct());
                     

        
        pst.setInt(4, T.getNbre_Perso());
         pst.setInt(5, T.getNumCabR());

        pst.executeUpdate();
            System.out.println("Reservation ajoutée");
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }          
    }
       public void Réserveractivité(Reservation T){
        try {
            String requete="INSERT INTO res_act(NomClient,PrenomC,IdAct,Nbre_Perso,NumC)Values(?,?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
        pst.setString(1, T.getNomClient());
        pst.setString(2, T.getPrenomC());
               

        pst.setInt(3, T.getIdAct());

        pst.setInt(4, T.getNbre_Perso());
         pst.setInt(5,T.getNumCabR());

       
        pst.executeUpdate();
            System.out.println("Reservation ajoutée");
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }          
    }
    
    public List<Reservation>listerResevation(){
     List<Reservation>mylist=new ArrayList();
        try {
            
            String requete="SELECT *FROM res_act";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
            
            Reservation per=new Reservation();
            per.setIdRes(rs.getInt(1));
            per.setNomClient(rs.getString("NomClient"));
            per.setPrenomC(rs.getString("PrenomC"));
            per.setIdAct(rs.getInt("IdAct"));   
            
            per.setNbre_Perso(rs.getInt("Nbre_Perso"));
        per.setNumCabR(rs.getInt("NumC"));
            
            
            mylist.add(per);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   return mylist;}
     public void deleteResevation(Reservation z) {
       try
       {            Reservation per=new Reservation();

           String requete="DELETE FROM res_act WHERE IdRes =?";
          PreparedStatement pste=MyConnection.getInstance().getCnx().prepareStatement(requete);
            pste.setInt(1,per.getIdRes());
            pste.executeUpdate();
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
       
 }
 
           
 
    public void modifierResevation(Reservation C){
        try {
            String requete =  "UPDATE res_act SET NomClient = ?,PrenomC = ?, IdAct = ?,Nbre_Perso= ?,NumC=? WHERE IdRes=?";
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, C.getNomClient());
            pst.setString(2, C.getPrenomC());
            pst.setInt(3, C.getIdAct());
 
            
            pst.setInt(4, C.getNbre_Perso());
            pst.setInt(5, C.getNumCabR());
       
            pst.setInt(6, C.getIdRes());
            

            pst.executeUpdate();
            System.out.println("Réservation modifiée!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
}
