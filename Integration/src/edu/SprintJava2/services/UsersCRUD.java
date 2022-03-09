/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

import edu.SprintJava2.entities.Users;
import edu.SprintJava2.utlis.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;
import edu.SprintJava2.services.UsersSession;
import javax.swing.JFrame;

/**
 *
 * @author chayma
 */

public class UsersCRUD {
    
    public static int cUserId;
    public static ResultSet cUserRow;
    public boolean ajouteruser(Users u) {
        try {
            String requete = "INSERT into users(name,lastname,email,password,role,profilepicture) values(?,?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,u.getName());
            pst.setString(2,u.getLastname() );
            pst.setString(3,u.getEmail());
            pst.setString(4,u.getPassword());
            pst.setString(5,u.getRole());
            pst.setString(6,u.getProfilePicture());
           pst.executeUpdate();
           System.out.println("Client ajouteé avec succées !");
           return true;
                    
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
        return false;
    }
     public static  List<Users>listerUsers(){
        List<Users>myList= new ArrayList();
        String role="";
        try {
            String requete = "SELECT * FROM users";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()){
                Users c = new Users();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setLastname(rs.getString("lastname"));
                c.setEmail(rs.getString("email"));
                c.setProfilePicture(rs.getString("profilepicture"));
               if (rs.getString("role").equals("ROLE_ADMIN")){
                   role="Admin";
               }else if (rs.getString("role").equals("ROLE_CAMPER")) {
                   role="Camper";
               }else if(rs.getString("role").equals("ROLE_HOST")){
                   role="Host";
               }else if (rs.getString("role").equals("ROLE_Fournisseur")){
                   role="Fournisseur";
               }
               c.setRole(role);
                myList.add(c); 
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList ;
    }
     public static void modifierUsers(int id_e ,String name_e,String lastname_e,String email_e,String password_e,String role_e,String profilepicture_e){
        try {
             String requete="UPDATE users SET"
                    + " `id`="+id_e+" ,`name`='"+name_e+"' , `lastname`='"+lastname_e+"' , `email`='"+email_e+"',`password`='"+password_e+"'"
                    + ",`role` ='"+role_e+"' ,`profilepicture`='"+profilepicture_e+"'      where `id`="+id_e+" ";
             System.out.println("query = " + requete);
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("user modifié avec scuccés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
      

      public static void supprimerUser(Users u){
        try {
            String requete="DELETE from users where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, u.getId());
            pst.executeUpdate();
            System.err.println("user supprimé avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
  public static boolean Login(String email, String password) throws Exception {
        boolean checkUser = true;
        Users u = new Users();


        try {
            String requete = "SELECT * FROM users where email=? AND password=? AND status =1 ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {  
                 JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                 frame.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(frame, "EMAIL AND PASSWORD MATCHED 🙂", "Login Valid", JOptionPane.INFORMATION_MESSAGE);
                cUserId = rs.getInt("id");
                cUserRow = rs;
                UsersSession.addUserLogin(cUserRow);
            } else {
                checkUser = false;
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    frame.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(frame, "EMAIL OR PASSWORD DO NOT MATCH OR YOUR ACCOUNT HAS BEEN DESACTIVATED!", "Login Invalid", JOptionPane.ERROR_MESSAGE);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersCRUD.class.getName()).log(Level.SEVERE, null, ex);
            checkUser = false;
        }
        
        return checkUser;
    }   
     public static boolean validateEmail(String email)  {
        try {
            String requete = "SELECT id from  users where email=?  ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            int Login =0;
            ResultSet rs ;
            pst.setString(1, email);
            rs=pst.executeQuery();
            while(rs.next()){
                Login = rs.getInt("id");
            }
            rs.close();
            pst.close();
            if (Login>0){
                System.out.println("Error user same email found !");
                
                JOptionPane.showMessageDialog(null, "email not valid");

                return false;
            }else {
                System.out.println("Email is valid");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            return false;
            
        }
        
     } 
   

}

      
       
              
               
                        
                           
               
