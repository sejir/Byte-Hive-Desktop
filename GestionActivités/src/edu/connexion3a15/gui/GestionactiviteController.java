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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import edu.connexion3a15.entities.activites;
import edu.connexion3a15.services.activitescrud;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author chiha
 */
public class GestionactiviteController implements Initializable {

    @FXML
    private TextField txnomact;
    @FXML
    private DatePicker calddebut;
    @FXML
    private DatePicker caldfinal;
    @FXML
    private TextField txemplacement;
    @FXML
    private TextField txdescirptionact;
    @FXML
    private Button btnajouteract;
    @FXML
    private Button btnmodifieract;
    @FXML
    private Button btnsupprimeract;
    @FXML
    private TableColumn<activites, String> tvnomact;
    @FXML
    private TableColumn<activites, Date> tvdebut;
    @FXML
    private TableColumn<activites, Date> tvdatefinal;
    private TableColumn<activites, String> tvdescact;
    @FXML
    private TableView<activites> tvactivites;
    @FXML
    private TableColumn<activites, String> tvemplacement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showactivites ();
        
                System.out.print("test");

        
        
     }    

    @FXML
    private void modifieractivite(ActionEvent event) {
    }

    @FXML
    private void ajouteractivite(ActionEvent event) {        
        String nom_act = txnomact.getText();
        String description = txdescirptionact.getText();
        String emplacament = txemplacement.getText() ; 
        Date  d_debut = Date.valueOf(calddebut.getValue());
        Date d_fin = Date.valueOf(caldfinal.getValue());
         
activites act = new activites(nom_act, description,d_debut,d_fin, emplacament,1);   
      activitescrud a = new activitescrud() ;
      a.ajouteractivites(act);
      
      
    
    
    
    
    }

    @FXML
    private void supprimeractivite(ActionEvent event) {
    }
 
    public void showactivites (){
     activitescrud act = new activitescrud();
      ObservableList <activites> list = act.listeract();
        tvnomact.setCellValueFactory(new PropertyValueFactory<activites,String>("nom_act"));
        tvdebut.setCellValueFactory(new PropertyValueFactory<activites,Date>("d_debut"));
        tvdatefinal.setCellValueFactory(new PropertyValueFactory<activites,Date>("d_fin"));
        tvemplacement.setCellValueFactory(new PropertyValueFactory<activites,String>("emplacement"));
         //    tvdescact.setCellValueFactory(new PropertyValueFactory<activites,String>("description"));

        //System.out.print("test");
        tvactivites.setItems(list);
    }
   
    }
    

   


