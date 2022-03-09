/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.services.UsersSession;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class Interface_UserController implements Initializable {

    @FXML
    private Circle profilepicture;
    @FXML
    private Label labe1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image im = new Image(UsersSession.getProfilepicture());
        ImagePattern pattern = new ImagePattern(im);
        profilepicture.setFill(pattern);
        profilepicture.setStroke(Color.SEAGREEN);
        profilepicture.setEffect(new DropShadow(20, Color.BLACK));
          labe1.setText("Welcome, "+ " "+UsersSession.getRole().toUpperCase()+ " "+UsersSession.getName().toUpperCase()+" "+UsersSession.getlastname().toUpperCase());
        // TODO
    }    

    @FXML
    private void profile(ActionEvent event) {
         NewFXMain.setScene("Userprofile");
    }


    @FXML
    private void logout(ActionEvent event) {
        
        Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout");
        alert.setContentText("Do you want to logout "+UsersSession.getName()+"?");
        if (alert.showAndWait().get() == ButtonType.OK ) {
       NewFXMain.setScene("InterfaceLogin");
    }
        
    }

    @FXML
    private void upcomingevents(ActionEvent event) {
        NewFXMain.setScene("FrontOffice");
    }

    @FXML
    private void hosts(ActionEvent event) {
        NewFXMain.setScene("GuideBackOffice");
    }

    @FXML
    private void activities(ActionEvent event) {
        NewFXMain.setScene("gactivitesuser");
        
    }

    @FXML
    private void equipments(ActionEvent event) {
        NewFXMain.setScene("FXMLMenuEquipementClient");
    }

    @FXML
    private void reclamation(ActionEvent event) {
        NewFXMain.setScene("Reclamation");
        
    }
    }
    
