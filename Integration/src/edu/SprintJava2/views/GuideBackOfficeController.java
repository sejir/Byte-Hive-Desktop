/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.Guide;
import edu.SprintJava2.services.GuideCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GuideBackOfficeController implements Initializable {

    @FXML
    private TextField gfnom;
    @FXML
    private TextField gfprenom;
    @FXML
    private Button BtnVa;
    @FXML
    private TextField gflieux;
    @FXML
    private DatePicker gfdispo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void ajouterguide(ActionEvent event){
         String nom = gfnom.getText();
    String prenom = gfprenom.getText();
    String lieux = gflieux.getText();
         java.sql.Date getDatePickerDate = java.sql.Date.valueOf(gfdispo.getValue());

    
    
    if(gfnom.getText().length()<2){
        JOptionPane.showMessageDialog(null, "enter a valid name");
    }else if (gfprenom.getText().length()<2){
        JOptionPane.showConfirmDialog(null, "enter a valid location");
 
    }else if (gflieux.getText().length()<2){
        JOptionPane.showInputDialog(null, "not exist");
    }
      

   
        Guide g = new Guide(nom, prenom, getDatePickerDate, lieux, 0);
        GuideCRUD ge = new GuideCRUD();
                ge.ajouterPersonne(g);
         
    }

    @FXML
    private void retourner(ActionEvent event) {
        NewFXMain.setScene("InterfaceAdmin");
    }
    
}
