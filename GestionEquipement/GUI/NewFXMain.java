/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import java.awt.Image;
import edu.naturecruise.entites.EquipementVendre;
import edu.naturecruise.utils.MyConnetion;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.io.File;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
 
 import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
//import javax.swing.text.html.ImageView;

/**
 *
 * @author user
 */
public class NewFXMain extends Application {
     private void playSound() {
        AudioClip audio= new AudioClip(getClass().getResource("song.mp3").toString());
        audio.play();

    }
    @Override
    public void start(Stage primaryStage) throws SQLException  {
        
 
            Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLMenuEquipement.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestion des Equipments");
            primaryStage.show();
            playSound();
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        
        
        
//             final FlowPane container = new FlowPane();
//             ScrollPane scrollPane = new ScrollPane();
//        scrollPane.setContent(container);
//       
//         Pannable.
//        scrollPane.setPannable(true);
//
//
////        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
//textField.setTextFormatter(integerOnlyFormatter);