/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.services.UsersCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class UsersmanagmentController implements Initializable {

    @FXML
    private Label lbusers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficheruser(ActionEvent event) {
        UsersCRUD pc = new UsersCRUD(); 
                pc.listerUsers();
                lbusers.setText(pc.listerUsers().toString());
    }
    
}
