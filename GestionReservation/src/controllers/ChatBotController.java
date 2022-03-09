/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Sejir
 */
public class ChatBotController implements Initializable {

    @FXML
    private VBox vbox_msg;
    @FXML
    private TextField text_field;
    @FXML
    private Button retour_btn;
    @FXML
    private Button envoi_msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleKeyPressed(KeyEvent event) {
    }

    @FXML
    private void handleRetourBtn(ActionEvent event) {
    }

    @FXML
    private void handleEnvoiMsg(ActionEvent event) {
    }
    
}
