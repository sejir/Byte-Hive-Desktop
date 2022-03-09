/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import edu.SprintJava2.entities.Guide;
import edu.SprintJava2.entities.Localisation;
import edu.SprintJava2.entities.ReclamationGuide;
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
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import edu.SprintJava2.utlis.MyConnection;

/**
 *
 * @author Feryel Derouich
 */
public class ReclamationGuideCRUD {

    public boolean insertReclamationG(ReclamationGuide rg) {
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("insert into reclamationguide (id_client,description,status,id_guide) values (?,?,?,?)");
            preparedStmt.setInt(1, rg.getId_client());
            preparedStmt.setString(2, rg.getDescription());
            preparedStmt.setInt(3, 0);
            preparedStmt.setInt(4, rg.getId_guide());
            preparedStmt.executeUpdate();
            preparedStmt.close();
            System.out.println("Reclamation Guide Inserted");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static List<ReclamationGuide> readReclamationUserG(Users u) {
        List<ReclamationGuide> list = new ArrayList();
        try{
            String requete = "SELECT * FROM reclamationguide where id_client=1";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            //pst.setInt(1, u.getId());
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                ReclamationGuide rg = new ReclamationGuide();
                rg.setId_client(u.getId());
                rg.setId((rs.getInt("id")));
                rg.setDescription((rs.getString("description")));
                rg.setRespond((rs.getString("reponse")));
                rg.setId_admin((rs.getInt("id_admin")));
                rg.setReclamationdate(rs.getDate("daterec"));
                rg.setId_guide(rs.getInt("id_guide"));

                list.add(rg);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<ReclamationGuide> readReclamationAdminG() {
        List<ReclamationGuide> myList = new ArrayList();
        
        try {

            String requete = "SELECT * FROM reclamationguide";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                ReclamationGuide rg =new ReclamationGuide();
                rg.setId((rs.getInt("id")));
                rg.setId_client(rs.getInt("id_client"));
                rg.setDescription((rs.getString("description")));
                rg.setRespond((rs.getString("reponse")));
                rg.setId_admin((rs.getInt("id_admin")));
                rg.setReclamationdate(rs.getDate("daterec"));
                rg.setStatus(rs.getInt("status") != 0);
                rg.setId_guide(rs.getInt("id_guide"));
                myList.add(rg);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;
    }

    public static boolean deleteReclamationG(int id) {
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("DELETE FROM reclamationguide WHERE ID = ? ");
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            System.out.println("RECLAMATION Guide number " + id + " has been deleted !");
            return true;
        } catch (SQLException ex) {
            System.err.println("Got an exception!");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean updateReclamationUserG(ReclamationGuide rg) {
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("UPDATE reclamationguide SET description = ? , id_guide= ?  where id= ?   ");
            preparedStmt.setString(1, rg.getDescription());
            preparedStmt.setInt(2, rg.getId_guide());
            preparedStmt.setInt(3, rg.getId());
            preparedStmt.executeUpdate();
            preparedStmt.close();
            System.out.println("Reclamation Guide Updated");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean updateReclamationAdminG(ReclamationGuide rg) {
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            PreparedStatement preparedStmt = cnx.prepareStatement("UPDATE reclamationguide SET reponse = ? , id_admin=? ,status= ?  where id= ?   ");
            preparedStmt.setString(1, rg.getRespond());
            preparedStmt.setInt(2, rg.getId_admin());
            preparedStmt.setInt(3, 1);
            preparedStmt.setInt(4, rg.getId());
            preparedStmt.executeUpdate();
            preparedStmt.close();
            System.out.println("Reclamation Responded");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static void statistiqueG() {
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            ResultSet rs;
            boolean stat = false;
            PreparedStatement ps = cnx.prepareStatement("select count(*), u.nom , r.status, g.description from reclamationguide r join utilisateur u join guide g  where (r.id_client = u.id and r.id_guide = l.id ) group by  r.id_guide , u.nom , r.status");
            rs = ps.executeQuery();
            while (rs.next()) {

                if (rs.getInt(3) == 0) {
                    stat = false;
                } else {
                    stat = true;
                }
                System.out.println("Nom du Client: " + rs.getString(2) + " Nombre de reclamation: " + rs.getInt(1) + " Traité: " + stat + "  Guide : " + rs.getString(4));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationGuideCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ReclamationGuide reclamationInfoG(int id) {
        ReclamationGuide rg = new ReclamationGuide();
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            ResultSet rs;
            PreparedStatement preparedStmt = cnx.prepareStatement("SELECT * from reclamationguide where id = ? ");
            preparedStmt.setInt(1, id);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                rg.setId(id);
                rg.setId_client(rs.getInt("id_client"));
                rg.setDescription(rs.getString("description"));
                rg.setReclamationdate(rs.getDate("daterec"));
                rg.setRespond(rs.getString("reponse"));
                rg.setId_admin(rs.getInt("id_admin"));
                rg.setId_guide(rs.getInt("id_guide"));
                rg.setStatus(rs.getInt("status") != 0);
            }
            preparedStmt.close();
            rs.close();
            return rg;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return rg;
        }
    }

    public static List<Guide> listerGuides() {
        List<Guide> listg = new ArrayList();
        try{

            String requete = "SELECT * FROM guide";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Guide g = new Guide();
                g.setId(rs.getInt(1));
                g.setNom(rs.getString("nom"));
                listg.add(g);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listg;
    }
}
