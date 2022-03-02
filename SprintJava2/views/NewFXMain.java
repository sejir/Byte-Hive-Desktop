/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import java.io.IOException;
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
 * @author chayma
 */
public class NewFXMain extends Application {
    
    public static Stage _stage;
    public static NewFXMain _self;
    @Override
    public void start(Stage primaryStage) {
          _stage = primaryStage;
          _self = this;
          setScene("InterfaceLogin");
    }
    public static void setScene(String sceneName)
    {
        try {
            Parent root = FXMLLoader.load(_self.getClass().getResource(sceneName + ".fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("InterfaceAdmin.fxml"));

            Scene scene = new Scene(root);
            _stage.setScene(scene);
            _stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
