/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class Interface_CamperController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profile(ActionEvent event) {
        NewFXMain.setScene("Userprofile");
    }

    @FXML
    private void retourner(ActionEvent event) {
        NewFXMain.setScene("InterfaceLogin");
    }

    @FXML
    private void contact(ActionEvent event) {
        NewFXMain.setScene("ContactPage");
    }
    
}
