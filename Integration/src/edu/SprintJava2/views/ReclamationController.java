/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Feryel Derouich
 */
public class ReclamationController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button breclamation;
    @FXML
    private Button brecguide;
    @FXML
    private Button brecloc;
    @FXML
    private Label labrec;
    @FXML
    private HBox hbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void switchToMesRec(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MesReclamations.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("Error:"+ex.getMessage());
        }
    }
    
    @FXML
    public void switchToRecG(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ReclamationG.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("Error:"+ex.getMessage());
        }
    }
    
    @FXML
    public void switchToRecL(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ReclamationL.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("Error:"+ex.getMessage());
        }
    }
}
