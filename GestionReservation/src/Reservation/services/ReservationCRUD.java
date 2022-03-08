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
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Sejir
 */
public class ReservationCRUD {
      public void ajouterResevation(Reservation T){
        try {
            String requete="INSERT INTO res_act(NomClient,PrenomC,IdAct ,date,Nbre_Perso,NumCab)Values(?,?,?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
        pst.setString(1, T.getNomClient());
        pst.setString(2, T.getPrenomC());
        
        pst.setInt(3, T.getIdAct());
                         //   java.sql.Date d_debut = new java.sql.Date(T.getDates().getTime());

        //pst.setDate(4, T.d_debut);
        pst.setInt(5, T.getNbre_Perso());
         pst.setInt(6, T.getNumCabR());
        pst.executeUpdate();
            System.out.println("Reservation ajoutée");
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }          
    }
       public void Réserveractivité(Reservation T){
        try {
            String requete="INSERT INTO res_act(NomClient,PrenomC,IdAct ,date,Nbre_Perso,NumCab)Values(?,?,?,?,?,?)";
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
        pst.setString(1, T.getNomClient());
        pst.setString(2, T.getPrenomC());
                    //java.sql.Date d_debut = new java.sql.Date(T.getDates().getTime());

        pst.setInt(3, T.getIdAct());
        pst.setDate(4,T.getDates());
        pst.setInt(5, T.getNbre_Perso());
         pst.setInt(6, T.getNumCabR());
        //NumCabR
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
            per.setIdRes(rs.getInt("IdRes"));
            per.setNomClient(rs.getString("NomClient"));
            per.setNomClient(rs.getString("PrenomC"));
            per.setIdAct(rs.getInt("IdAct"));
            per.setDates(rs.getDate("date"));
            per.setIdAct(rs.getInt("Nbre_Perso"));
            per.setIdAct(rs.getInt("NumCabR"));
            
            mylist.add(per);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   return mylist;}
     public void deleteResevation(int z) {
       try
       {
           String requete="DELETE FROM res_act WHERE IdRes =" +z ;
          PreparedStatement pste=MyConnection.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("transport supprimée");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
 }
 
           
 
    public void modifierResevation(Reservation C, int z){
        try {
            String requete =  "UPDATE res_act SET NomClient = ?,PrenomC = ?, nb_personnes = ?, date = ?,Nbre_Perso= ?,NumCabR=? WHERE IdRes="+z;
           
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, C.getNomClient());
            pst.setString(2, C.getPrenomC());
            pst.setInt(3, C.getIdAct());
                            //  java.sql.Date = new java.sql.Date(C.getDates().getTime());
//pst.setDate(4,C.);
            
            pst.setInt(5, C.getNbre_Perso());
            pst.setInt(6, C.getNumCabR());

            pst.executeUpdate();
            System.out.println("Réservation modifiée!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
}
