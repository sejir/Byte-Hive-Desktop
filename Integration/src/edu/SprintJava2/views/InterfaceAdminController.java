/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.services.UsersSession;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class InterfaceAdminController implements Initializable {

    @FXML
    private Button userpagebtn;
    private Button homebtn;
    private Button campingbtn;
    private Button equipmentbtn;
    @FXML
    private Label pagelabel;
    @FXML
    private Button logoutbtn;
    @FXML
    private VBox vbox;
    private Button profilebtn;
    @FXML
    private AnchorPane adminpage;
    private Parent fxml ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /* Image im = new Image(UsersSession.getProfilepicture());
        ImagePattern pattern = new ImagePattern(im);
        profilepicture.setFill(pattern);
        profilepicture.setStroke(Color.SEAGREEN);
        profilepicture.setEffect(new DropShadow(20, Color.BLACK));*/
      
                }
  

    @FXML
    private void userpage(ActionEvent event) {
      
        NewFXMain.setScene("Usersmanagment");

    }




    @FXML
    private void logout(ActionEvent event) {
        Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout");
        alert.setContentText("Do you want to logout "+UsersSession.getName()+"?");
        if (alert.showAndWait().get() == ButtonType.OK ) {
        stage =(Stage) adminpage.getScene().getWindow();
        System.out.println("You logged out"+UsersSession.getName());
        UsersSession.cleanUserSession();
        stage.close();
       NewFXMain.setScene("InterfaceLogin");
    }
        
    }


    @FXML
    private void activities(ActionEvent event) {
        
        NewFXMain.setScene("gactivites");
    }

    @FXML
    private void locations(ActionEvent event) {
        NewFXMain.setScene("gestionemplacement");
    }

    @FXML
    private void ajouterevenement(ActionEvent event) {
        NewFXMain.setScene("Ajouter");
    }

    @FXML
    private void guide(ActionEvent event) {
         NewFXMain.setScene("Guide");
    }

    @FXML
    private void equipements(ActionEvent event) {
         NewFXMain.setScene("FXMLMenuEquipement");
    }

    @FXML
    private void cabine(ActionEvent event) {
        NewFXMain.setScene("GestionCabine"); 
    }

    @FXML
    private void reservation(ActionEvent event) {
        NewFXMain.setScene("GestionReservationback");
    }
    
}
