/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLMenuEquipementClientController implements Initializable {

    @FXML
    private Button BTNEquipL;
    @FXML
    private Button BTNEquipV;
    @FXML
    private Button BTNQuitterEquip;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void interfaceGestionEquipL(ActionEvent event) {
        try{
            BTNEquipL.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("FXMLEquipLouerC.fxml"));
                Stage mainStage = new Stage();
                Scene scene= new Scene(root);
                mainStage.setScene(scene);
                 mainStage.setTitle("Equipements à Louer");
                mainStage.show();
                JOptionPane.showMessageDialog(null, "Bienvenue dans votre interface Equipements à Louer");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }

    @FXML
    private void interfaceGestionEquipV(ActionEvent event) {
        try{
            BTNEquipV.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("FXMLEquipementVendre.fxml"));
                Stage mainStage = new Stage();
                Scene scene= new Scene(root);
                mainStage.setScene(scene);
                 mainStage.setTitle("Equipements à Vendre");
                mainStage.show();
                JOptionPane.showMessageDialog(null, "Bienvenue dans votre interface Equipements à Vendre");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }

    @FXML
    private void Quitter(ActionEvent event) {
        Stage stage = (Stage) BTNQuitterEquip.getScene().getWindow();
        stage.close();
    }
    
}
