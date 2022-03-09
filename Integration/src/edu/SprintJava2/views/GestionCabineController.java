/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;
import javafx.scene.control.ComboBox;

import edu.SprintJava2.entities.Cabine;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import edu.SprintJava2.services.CabineCRUD;
import edu.SprintJava2.views.ControleSaisie;

/**
 * FXML Controller class
 *
 * @author Sejir
 */
public class GestionCabineController implements Initializable {

    @FXML
    private TextField NumeroC;
    @FXML
    //private TextField TypeC;
   
    private TextField NbrpC;
    @FXML
    private TextField PrixC;
    @FXML
    private Button AjoutC;
    private Label promo;
    @FXML
    private TableView<Cabine> tablec;
    @FXML
    private TableColumn<Cabine, Integer> idColumn;
    @FXML
    private TableColumn<Cabine, Integer> numColumn;
    @FXML
    private TableColumn<Cabine, Integer> nbrpColumn;
    @FXML
    private TableColumn<Cabine, Float> prixColumn;
    @FXML
    private TableColumn<Cabine, String> typeColumn;
    @ FXML
    private Button afficheC;
    @FXML
    private ComboBox<String> TypeCh;
    ObservableList<String> list = FXCollections.observableArrayList("Bungalow", "Cottage", "standard");
    @FXML
    private Label Controle;
    @FXML
    private Label CTRLN;
    @FXML
    private Label CTRLP;
    @FXML
    private Label prixlabel;

   
    
    
    

    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        TypeCh.setItems(list);
         
        CabineCRUD resc=new CabineCRUD();
     ActionEvent event= new ActionEvent();
      //ObservableList <Participation> list = (ObservableList <Participation>) resc.listerCabine();//List<res_cabine>listerCabine
         idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        numColumn.setCellValueFactory(new PropertyValueFactory<>("num"));
        nbrpColumn.setCellValueFactory(new PropertyValueFactory<>("nb_personnes"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
         typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
         AfficherParticipation(event);
      //resc.listerCabine();
       tablec.setEditable(true);
       
        tablec.getSelectionModel().setCellSelectionEnabled(true);
        
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        numColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nbrpColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        prixColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }    

    @FXML
    private void AjouterCabine(ActionEvent event) {
         ControleSaisie u =new ControleSaisie();
                if (!u.Num(NumeroC.getText()))
        {
            Controle.setText("Erreur ! Veuillez insérer un Num valide");
        }        else    {             Controle.setText("");
       }
        if (!u.Num(NbrpC.getText()))
        {
            CTRLN.setText("Erreur ! Veuillez insérer un Nombre valide");
        }
        else 
        {
            CTRLN.setText("");
        }
    if (!u.Num(PrixC.getText()))
        {
            CTRLP.setText("Erreur ! Veuillez insérer un Prix valide");
        }
        else 
        {
            CTRLP.setText("");
        }        
        String TypeC =TypeCh.getValue();
            int numeroo = Integer.parseInt(NumeroC.getText());
        int nbrpe = Integer.parseInt(NbrpC.getText());
        String Typec = TypeC;
        float Prix = Float.parseFloat(PrixC.getText());
        Cabine D=new Cabine(52,numeroo,nbrpe,TypeC,Prix,0);
       
       
    
    
        CabineCRUD resc=new CabineCRUD();
        resc.ajouterCabine(D);
    }
@FXML
    private void onEditnum(TableColumn.CellEditEvent<Cabine,  Integer> event) {
         Cabine re=tablec.getSelectionModel().getSelectedItem();       
        re.setNum(event.getNewValue());
        CabineCRUD reService = new CabineCRUD();
        reService.modifierCabine(re);
    }
    @FXML
    private void onEditNbrp(TableColumn.CellEditEvent<Cabine,  Integer> event) {
        Cabine re=tablec.getSelectionModel().getSelectedItem();       
        re.setNb_personnes(event.getNewValue());
        CabineCRUD reService = new CabineCRUD();
        reService.modifierCabine(re);
    }
    @FXML
    private void onEditPrix(TableColumn.CellEditEvent<Cabine,  Float> event) {
        Cabine re=tablec.getSelectionModel().getSelectedItem();       
        re.setPrix(event.getNewValue());
        CabineCRUD reService = new CabineCRUD();
        reService.modifierCabine(re);
    }
    @FXML
    private void onEditType(TableColumn.CellEditEvent<Cabine, String> event) {
          Cabine re=tablec.getSelectionModel().getSelectedItem();       
        re.setType(event.getNewValue());
        CabineCRUD reService = new CabineCRUD();
        reService.modifierCabine(re);
    }

    @FXML
    private void SupprimerPar(ActionEvent event) {
        Cabine re=tablec.getSelectionModel().getSelectedItem();  
        CabineCRUD vService = new CabineCRUD();
        vService.deleteCabine(re);
        
      AfficherParticipation(event);
    }

    @FXML
    private void AfficherParticipation(ActionEvent event) {
         CabineCRUD reService = new CabineCRUD();
        List<Cabine> liste = reService.listerCabine();
        ObservableList<Cabine> olist = FXCollections.observableArrayList(liste);
        
        tablec.setItems(olist);
    }

   
    @FXML
    private void prixtot(ActionEvent event) {
        CabineCRUD reService = new CabineCRUD();
     float   x=reService.Prixtotal();
     String s=String.valueOf(x);  
        prixlabel.setText(s);
    }

  

   
}
