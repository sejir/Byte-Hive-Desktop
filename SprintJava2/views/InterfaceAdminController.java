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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class InterfaceAdminController implements Initializable {

    @FXML
    private Button userpagebtn;
    @FXML
    private Button homebtn;
    @FXML
    private Button campingbtn;
    @FXML
    private Button equipmentbtn;
    @FXML
    private Label pagelabel;
    @FXML
    private Button logoutbtn;
    @FXML
    private VBox vbox;
    @FXML
    private Button profilebtn;
    @FXML
    private AnchorPane adminpage;
    private Parent fxml ;
    @FXML
    private Button homebtn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        homepage();
    }   
    private void enableBtns(){
        userpagebtn.setDisable(false);
        homebtn.setDisable(false);
        campingbtn.setDisable(false);
        equipmentbtn.setDisable(false);
        profilebtn.setDisable(false);  
    }
    private void selectbtn(Button b){
        enableBtns();
        b.setDisable(true);
    }

    @FXML
    private void userpage(ActionEvent event) {
       /* pagelabel.setText("Users Managment");
        selectbtn(userpagebtn);
        homebtn.setDisable(false);
        try{
            fxml=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/Usersmanagment.fxml")));
        }catch (IOException e) {
            e.printStackTrace();
        }
        vbox.getChildren().removeAll();
        vbox.getChildren().setAll(fxml);*/
        NewFXMain.setScene("Usersmanagment");

    }

    @FXML
    private void homepage() {
        pagelabel.setText("Welcome Home " + UsersSession.getName());
        selectbtn(homebtn);
        userpagebtn.setDisable(false);
        
    }

    @FXML
    private void campingpage(ActionEvent event) {
        pagelabel.setText("campings page");
    }

    @FXML
    private void equipmentpage(ActionEvent event) {
        NewFXMain.setScene("Userprofile");
    }

    @FXML
    private void profilepage(ActionEvent event) {
        //NewFXMain.setScene("Userprofile");
      
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
    }
        
    }
    
}
