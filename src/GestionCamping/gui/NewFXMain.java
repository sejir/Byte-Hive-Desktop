/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCamping.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage Stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Guide.fxml"));
            Scene scene = new Scene(root);
            
            Stage.setTitle("Ajouter!");
            Stage.setScene(scene);
            Stage.show();
        } catch (IOException ex) {
   ex.printStackTrace();
        }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
