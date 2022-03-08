/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.Users;
import edu.SprintJava2.services.UsersCRUD;
import edu.SprintJava2.utlis.MyConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class UsersmanagmentController implements Initializable {

    private Label lbusers;
    @FXML
    private TableView<Users> tableusers;
    @FXML
    private TableColumn<Users,String> colname;
    @FXML
    private TableColumn<Users, String> collastname;
    @FXML
    private TableColumn<Users, String> colemail;
    private TableColumn<Users, String> colprofilepic;
    private TableColumn<Users, String> colrole;
   private final ObservableList<Users> dataList = FXCollections.observableArrayList();



    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
 

    @FXML
    private void resfreshuser() {
           UsersCRUD pp = new UsersCRUD();
        //colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        collastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        //colprofilepic.setCellValueFactory(new PropertyValueFactory<>("profilepicture"));
        //colrole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colname.setCellFactory(TextFieldTableCell.forTableColumn());
        collastname.setCellFactory(TextFieldTableCell.forTableColumn());
        colemail.setCellFactory(TextFieldTableCell.forTableColumn());
       // colprofilepic.setCellFactory(TextFieldTableCell.forTableColumn());
        //colrole.setCellFactory(TextFieldTableCell.forTableColumn());
       
        
       tableusers.getItems().clear();
        final ObservableList<Users> myList = FXCollections.observableArrayList(UsersCRUD.listerUsers());
        tableusers.setItems(myList);
        
    }
    @FXML
    private void retourner (ActionEvent event){
        NewFXMain.setScene("InterfaceAdmin");
    }

    @FXML
    private void remove(ActionEvent event) {
     int   myIndex = tableusers.getSelectionModel().getSelectedIndex();
     int   id = Integer.parseInt(String.valueOf(tableusers.getItems().get(myIndex).getId()));
                    
 
        try
        {
           String requete="DELETE from users where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Users details");
            
 
alert.setHeaderText("Users setails");
alert.setContentText("Deletedd!");
 
alert.showAndWait();
             resfreshuser();  
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Activate(ActionEvent event) {
         try {
            int   myIndex = tableusers.getSelectionModel().getSelectedIndex();
            int   id = Integer.parseInt(String.valueOf(tableusers.getItems().get(myIndex).getId()));
            String requete="UPDATE users  SET status = 1 WHERE id =?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.setInt(1, id);
            pst.executeUpdate();
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Users details");
            
 
alert.setHeaderText("Users details");
alert.setContentText("This user session is activated ");
 
alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @FXML
    private void desactivate(ActionEvent event) {
         try {
            int   myIndex = tableusers.getSelectionModel().getSelectedIndex();
            int   id = Integer.parseInt(String.valueOf(tableusers.getItems().get(myIndex).getId()));
            String requete="UPDATE users  SET status = 0 WHERE id =?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.setInt(1, id);
            pst.executeUpdate();
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Users details");
            
 
alert.setHeaderText("Users details");
alert.setContentText("This user is banned!");
 
alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

  

}
