/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
 import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import edu.SprintJava2.entities.activites;
import edu.SprintJava2.entities.emplacement;
import edu.SprintJava2.services.activitescrud;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
 import org.controlsfx.control.textfield.AutoCompletionBinding;
import edu.SprintJava2.entities.emplacement;
import edu.SprintJava2.services.emplacementcrud;
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
    private TableView<emplacement> tvemplacement;
    @FXML
    private TableColumn<activites, String> empcount;
    @FXML
    private TableColumn<activites, String> count;
    @FXML
    private TableView<activites> tvcount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        showemplacement ();
        count ();
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
    
    public void count (){
        
     activitescrud  act = new activitescrud();
     
      ObservableList <activites> list = act.dupli();
        empcount.setCellValueFactory(new PropertyValueFactory<activites,String>("emplacement"));
         count.setCellValueFactory(new PropertyValueFactory<activites,String>("count"));
         

        //System.out.print("test");
        tvcount.setItems(list);
        
    }

    @FXML
    private void retourner(ActionEvent event) {
        NewFXMain.setScene("InterfaceAdmin");
    }
    
    
    
    
}

 