/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
 import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import edu.connexion3a15.entities.activites;
import edu.connexion3a15.entities.emplacement;
import edu.connexion3a15.services.activitescrud;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
 import org.controlsfx.control.textfield.AutoCompletionBinding;
import edu.connexion3a15.entities.emplacement;
import edu.connexion3a15.services.emplacementcrud;
/**
 * FXML Controller class
 *
 * @author chiha
 */
public class GestionemplacementController implements Initializable {

    @FXML
    private TextField tfnemplacement;
    @FXML
    private TextField tfdemplacement;
    @FXML
    private TableColumn<emplacement, String> tvlemplacement;
    @FXML
    private TableColumn<emplacement, String> tvldescription;
    @FXML
    private TableColumn<emplacement, String> tvnact;
    @FXML
    private TableView<emplacement> tvemplacement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        showemplacement ();
        
    }    

    @FXML
    private void selectrow(MouseEvent event) {
        
         emplacement emp  =tvemplacement.getSelectionModel().getSelectedItem();
        System.out.println("id"+emp.getId_emplacement());
        
        tfnemplacement.setText(emp.nom_emplacement);
        tfdemplacement.setText(emp.d_emplacement);
         
        
    }

    @FXML 
    private void modifieremplacement(ActionEvent event) {
        emplacement z  =tvemplacement.getSelectionModel().getSelectedItem();
 String nom_emplacement = tfnemplacement.getText();
        String description = tfdemplacement.getText();
         emplacement emp = new emplacement(nom_emplacement, description);
          emplacementcrud a = new emplacementcrud();
       
       a.modifieremplacement(emp,z.getId_emplacement());
        showemplacement ();
      

        
        
    }
 
    @FXML
    private void ajouteremplacement(ActionEvent event) {
 String nom_emplacement = tfnemplacement.getText();
        String description = tfdemplacement.getText();
         emplacement emp = new emplacement(nom_emplacement, description);
          emplacementcrud a = new emplacementcrud();
      a.ajouteremplacement(emp);
       showemplacement();
    }

    @FXML
    private void supprimeremplacement(ActionEvent event) {
        emplacementcrud a =new emplacementcrud();
        emplacement emp  =tvemplacement.getSelectionModel().getSelectedItem();
         a.supprimeremplacement(emp.getId_emplacement());
       int selectedID = tvemplacement.getSelectionModel().getSelectedIndex();
        tvemplacement.getItems().remove(selectedID);
         showemplacement();
    }
    
    
     public void showemplacement (){
     emplacementcrud  emp = new emplacementcrud();
     
      ObservableList <emplacement> list = emp.listeremplacement();
        tvlemplacement.setCellValueFactory(new PropertyValueFactory<emplacement,String>("nom_emplacement"));
         tvldescription.setCellValueFactory(new PropertyValueFactory<emplacement,String>("d_emplacement"));
         

        //System.out.print("test");
        tvemplacement.setItems(list);
    }
    
    
    
    
    
}

 