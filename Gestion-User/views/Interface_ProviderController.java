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
public class Interface_ProviderController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profile1(ActionEvent event) {
     NewFXMain.setScene("Userprofile");
    }

    @FXML
    private void contact1(ActionEvent event) {
        NewFXMain.setScene("ContactPage");
    }

    @FXML
    private void logout(ActionEvent event) {
          NewFXMain.setScene("InterfaceLogin");
    }
    
}
