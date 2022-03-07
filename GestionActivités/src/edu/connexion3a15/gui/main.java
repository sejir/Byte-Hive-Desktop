/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.gui;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author chiha
 */

public class main extends Application {
    @Override
    public void start(Stage stage) {
  try {
      Parent root = FXMLLoader.load(getClass().getResource("gactivites.fxml"));
   //Parent root = FXMLLoader.load(getClass().getResource("gestionemplacement.fxml"));
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.show();
   
   
  } catch(Exception e) {
   e.printStackTrace();
  }
 } 

 public static void main(String[] args) {
  launch(args);
 }
}
