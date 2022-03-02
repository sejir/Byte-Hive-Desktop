/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCamping.gui;


import edu.GestionCamping.entities.upcomingevents;
import edu.GestionCamping.services.upcomingeventCRUD;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterController implements Initializable {

   
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfLocalisation;
    @FXML
    private Button BtnValider;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfGuide;
    @FXML
    private TableView<upcomingevents> tevenement;
    @FXML
    private TableColumn<upcomingevents,String> tname;
    @FXML
    private TableColumn<upcomingevents,String> tlocation;
    @FXML
    private TableColumn<upcomingevents,String> tdate;
    @FXML
    private TableColumn<upcomingevents,String> tguide;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterevenement(ActionEvent event) {
    String event_name = tfNom.getText();
    String location = tfLocalisation.getText();
    String Date = tfDate.getText();
    String Guide = tfGuide.getText();
  
        upcomingevents u = new upcomingevents(1, event_name, location, Date, Guide);
        upcomingeventCRUD ue = new upcomingeventCRUD();
        ue.ajouterupcomingevents(u);
         afficherevenemtn();
    }

    @FXML
    private void modifierevenement(ActionEvent event) {
        upcomingeventCRUD uce =new upcomingeventCRUD();
        upcomingevents u  =tevenement.getSelectionModel().getSelectedItem();
        int selectedID = tevenement.getSelectionModel().getSelectedIndex();
        String event_name = tfNom.getText();
        String Location = tfLocalisation.getText();
        String Date = tfDate.getText() ; 
        String Guide = tfGuide.getText();
        
         
         upcomingevents ue = new upcomingevents(1, event_name, Location, Date, Guide);
         uce.Updateupcomingevents(ue, u.getEvent_number());
         afficherevenemtn();
         
         
     }

    

  @FXML
    private void supprimevenement(ActionEvent event) {
        upcomingeventCRUD uce =new upcomingeventCRUD();
         upcomingevents ue  =tevenement.getSelectionModel().getSelectedItem(); 
         uce.SupprimerUpcomingevents(ue);
         int selectedID = tevenement.getSelectionModel().getSelectedIndex();
         tevenement.getItems().remove(selectedID);
        afficherevenemtn();
    }
 public void afficherevenemtn (){
     upcomingeventCRUD uc = new upcomingeventCRUD();
     
        ObservableList <upcomingevents> List = uc.listerupcomingevents();
        tname.setCellValueFactory(new PropertyValueFactory<>("event_name"));
        tlocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        tdate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tguide.setCellValueFactory(new PropertyValueFactory<>("Guide"));
         


        //System.out.print("test");
        tevenement.setItems(List);
    }

    @FXML
    private void selectrow(MouseEvent event) {
           upcomingevents uc  = tevenement.getSelectionModel().getSelectedItem();
        System.out.println("id"+uc.getEvent_number());
        
        tfNom.setText(uc.event_name);
        tfLocalisation.setText(uc.location);
        tfDate.setText(uc.date);
        tfGuide.setText(uc.guide);

    }
    
}
