/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import edu.SprintJava2.entities.Localisation;
import edu.SprintJava2.entities.ReclamationLocation;
import edu.SprintJava2.entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.SprintJava2.utlis.MyConnection;

/**
 *
 * @author Feryel Derouich
 */
public class ReclamationLocationCRUD {
    
    
    public boolean insertReclamationL(ReclamationLocation rl) {
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("insert into reclamationlocalisation (id_client,description,status,id_localisation) values (?,?,?,?)");
            preparedStmt.setInt(1, rl.getId_client());
            preparedStmt.setString(2, rl.getDescription());
            preparedStmt.setInt(3, 0);
            preparedStmt.setInt(4,rl.getId_localisation());
            preparedStmt.executeUpdate();
            preparedStmt.close();
            System.out.println("Reclamation Localisation Inserted");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static List<ReclamationLocation> readReclamationUserL(Users u) {
        List<ReclamationLocation> list= new ArrayList() ;
        ReclamationLocation rl =new ReclamationLocation();
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("SELECT * FROM reclamationlocalisation where id_client = 1");
            //preparedStmt.setInt(1, u.getId());
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                rl.setId_client(u.getId());
                rl.setId((rs.getInt("id")));
                rl.setDescription((rs.getString("description")));
                rl.setRespond((rs.getString("reponse")));
                rl.setId_admin((rs.getInt("id_admin")));
                rl.setReclamationdate(rs.getDate("daterec"));
                rl.setId_localisation(rs.getInt("id_localisation"));
                if(rs.getInt("status") == 0 ){
                    rl.setStatus(false);
                }
                else {
                    rl.setStatus(true);
                }
                list.add(rl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.print(list);
        return list;
    }
    
    public List<ReclamationLocation> readReclamationAdminL() {
        List<ReclamationLocation> myList = new ArrayList();
        
        try {

            String requete = "SELECT * FROM reclamationlocalisation";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                ReclamationLocation rl =new ReclamationLocation();
                rl.setId((rs.getInt("id")));
                rl.setId_client(rs.getInt("id_client"));
                rl.setDescription((rs.getString("description")));
                rl.setRespond((rs.getString("reponse")));
                rl.setId_admin((rs.getInt("id_admin")));
                rl.setReclamationdate(rs.getDate("daterec"));
                rl.setStatus(rs.getInt("status") != 0);
                rl.setId_localisation(rs.getInt("id_localisation"));
                myList.add(rl);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;
    }
    
    public static boolean deleteReclamationL(int id)  {
        try{
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("DELETE FROM reclamationlocalisation WHERE ID = ? ");
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            System.out.println("RECLAMATION Location number "+id+" has been deleted !");
            return true;
        }
        catch (SQLException ex)
        {
            System.err.println("Got an exception!");
            System.out.println(ex.getMessage());
            return false ;
        }

    }
    
    public static boolean updateReclamationUserL(ReclamationLocation rl){
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("UPDATE reclamationlocalisation SET description = ? , id_localisation= ?  where id= ?   ");
            preparedStmt.setString(1, rl.getDescription());
            preparedStmt.setInt(2,rl.getId_localisation());
            preparedStmt.setInt(3, rl.getId());
            preparedStmt.executeUpdate();
            preparedStmt.close();
            System.out.println("Reclamation Localisation Updated");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    
    public static boolean updateReclamationAdminL(ReclamationLocation rl){
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("UPDATE reclamationlocalisation SET reponse = ? , id_admin=? ,status= ?  where id= ?   ");
            preparedStmt.setString(1, rl.getRespond());
            preparedStmt.setInt(2, rl.getId_admin());
            preparedStmt.setInt(3,1);
            preparedStmt.setInt(4,rl.getId());
            preparedStmt.executeUpdate();
            preparedStmt.close();
            System.out.println("Reclamation Responded");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static void statistiqueL(){
        try{
            Connection cnx = MyConnection.getInstance().getCnx();
            ResultSet rs ;
            boolean stat = false;
            PreparedStatement ps =cnx.prepareStatement("select count(*), u.nom , r.status, l.description from reclamationlocalisation r join utilisateur u join localisation l  where (r.id_client = u.id and r.id_localisation = l.id ) group by  r.id_localisation , u.nom , r.status");
             rs = ps.executeQuery();
            while (rs.next()) {
                
                if(rs.getInt(3)== 0){
                    stat = false;
                }
                else {
                    stat = true;
                }
                System.out.println("Nom du Client: " + rs.getString(2)+" / Nombre de reclamation: "+rs.getInt(1)+" / Traité: "+stat+" / Localisation : "+rs.getString(4));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
             Logger.getLogger(ReclamationLocationCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static ReclamationLocation reclamationInfoL(int id){
        ReclamationLocation rl = new ReclamationLocation();
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            ResultSet rs;
            PreparedStatement preparedStmt = cnx.prepareStatement("SELECT * from reclamationlocalisation where id = ? ");
            preparedStmt.setInt(1, id);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                rl.setId(id);
                rl.setId_client(rs.getInt("id_client"));
                rl.setDescription(rs.getString("description"));
                rl.setReclamationdate(rs.getDate("daterec"));
                rl.setRespond(rs.getString("reponse"));
                rl.setId_admin(rs.getInt("id_admin"));
                rl.setId_localisation(rs.getInt("id_localisation"));
                rl.setStatus(rs.getInt("status") != 0);
            }
            preparedStmt.close();
            rs.close();
            return rl;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return rl;
        }
    }
    
    public static List<Localisation> listerLocalisations() {
        List<Localisation> listl = new ArrayList();
        try{

            String requete = "SELECT * FROM localisation";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Localisation l = new Localisation();
                l.setId(rs.getInt(1));
                l.setDescription(rs.getString("description"));
                listl.add(l);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listl;
    }
}
