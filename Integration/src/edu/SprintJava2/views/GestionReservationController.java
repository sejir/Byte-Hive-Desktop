/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;
import edu.SprintJava2.entities.Cabine;
import java.io.IOException;
import edu.SprintJava2.services.ReservationCRUD;
import edu.SprintJava2.entities.Reservation;
import java.net.URL;
import java.util.Date;
//import com.jfoenix.controls.JFXComboBox;
//import com.jfoenix.controls.JFXDatePicker;
//import com.jfoenix.controls.JFXTextField;
//import com.jfoenix.controls.JFXTimePicker;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.text.SimpleDateFormat;  
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;




import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import edu.SprintJava2.services.CabineCRUD;

/**
 * FXML Controller class
 *
 * @author Sejir
 */
public class GestionReservationController implements Initializable {

    @FXML
    private TextField NomR;
    @FXML
    private Button Réserver;
    @FXML
    private TextField PrénomR;
    @FXML
    private TextField Nbre_PersoR;
    private ComboBox<String> Typecab;
    ObservableList<String> list = FXCollections.observableArrayList("Bungalow", "Cottage", "standard");
    private ComboBox<String> listecab;
       // ObservableList<String> liste = FXCollections.observableArrayList("Bungalow", "Cottage", "standard");
        

    private Label promlabel;
    @FXML
    private TextField numCchoisi;
    @FXML
    private TableView<Cabine> CabProp;
    @FXML
    private TableColumn<Cabine,Integer> NumCabP;
    @FXML
        private TableColumn<Cabine,String> TypeCabP;
    @FXML
    private Button AffC;
    @FXML
    private TableColumn<Cabine, Float> PrixCab;
    @FXML
    private Label ctrlnom;
    @FXML
    private Label ctrlprenom;
    @FXML
    private Label ctrlnum;
    @FXML
    private Label ctrlnbre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               //Typecab.setItems(list);
   ActionEvent event= new ActionEvent();
      //ObservableList <Participation> list = (ObservableList <Participation>) resc.listerCabine();//List<res_cabine>listerCabine
        
        NumCabP.setCellValueFactory(new PropertyValueFactory<>("num"));
        
         TypeCabP.setCellValueFactory(new PropertyValueFactory<>("type"));
         PrixCab.setCellValueFactory(new PropertyValueFactory<>("prix"));
         afficherCabs(event);
         
      //reService.listerCabine();
      float prix;
    }    

    @FXML
    public void Réservationa(ActionEvent event) {
                 ControleSaisie u =new ControleSaisie();

          if (!u.testnomprenom(NomR.getText()))
        {
            ctrlnom.setText("Erreur ! Veuillez insérer un Nom valide");
        }
        else 
        {
             ctrlnom.setText("");
        }
        if (!u.testnomprenom(PrénomR.getText()))
        {
            ctrlprenom.setText("Erreur ! Veuillez insérer un Prénom valide");
        }
        else 
        {
            ctrlprenom.setText("");
        }
    if (!u.Num(Nbre_PersoR.getText()))
        {
            ctrlnbre.setText("Erreur ! Veuillez insérer un nbre valide");
        }
        else 
        {
            ctrlnbre.setText("");
        }       
      if (!u.Num(numCchoisi.getText()))
        {
            ctrlnum.setText("Erreur ! Veuillez insérer un num valide");
        }
        else 
        {
            ctrlnum.setText("");
        }      
           String NomClient = NomR.getText();
           String PrenomClient = PrénomR.getText();
        int nbrpe = Integer.parseInt(Nbre_PersoR.getText());
 int numeroo = Integer.parseInt(numCchoisi.getText());
 //int x = Integer.parseInt(prixxx.getText());
            
        
        
       
          Cabine ab=new Cabine();
        CabineCRUD c=new CabineCRUD();
       //float x=c.recupererPrixCabine(ab,numeroo);
    
        Reservation D=new Reservation(NomClient,PrenomClient,0,nbrpe,numeroo);
        ReservationCRUD resc =new ReservationCRUD();
        resc.Réserveractivité(D);
       
        c.Dispo(ab,numeroo);
    }



    

    @FXML
    private void afficherCabs(ActionEvent event) {
        CabineCRUD reService = new CabineCRUD();
        List<Cabine> liste = reService.listerCabineDispo();
        ObservableList<Cabine> olist = FXCollections.observableArrayList(liste);
        
        CabProp.setItems(olist);
    }

    public int genererCodeP(ActionEvent event) {
          int x;
        CabineCRUD reService = new CabineCRUD();
        x=reService.CodePromo();
        String s="CodePromo:"+x;
        promlabel.setText(s);
    return x;}

    @FXML
    private void gotomap(ActionEvent event) throws IOException {
          FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("Mapreservation.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();}
    }

  
    

    