/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation.Views;
import Reservation.entities.Cabine;
import reservation.services.ReservationCRUD;
import reservation.entities.Reservation;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.ComboBox;




import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import reservation.services.CabineCRUD;

/**
 * FXML Controller class
 *
 * @author Sejir
 */
public class GestionReservationController implements Initializable {

    @FXML
    private TextField NomR;
    @FXML
    private DatePicker DateR;
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
        

    @FXML
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
         afficherCabs(event);
         
      //reService.listerCabine();
    }    

    @FXML
    private void Réservationa(ActionEvent event) {
           String NomClient = NomR.getText();
           String PrenomClient = PrénomR.getText();
        int nbrpe = Integer.parseInt(Nbre_PersoR.getText());
        //String dateRes = DateR.getValue().toString();
              java.sql.Date dateRes = java.sql.Date.valueOf(DateR.getValue());
 int numeroo = Integer.parseInt(numCchoisi.getText());
            
        
        
        
        Reservation D=new Reservation(NomClient,PrenomClient,0,dateRes,nbrpe,numeroo);
        ReservationCRUD resc =new ReservationCRUD();
        resc.Réserveractivité(D);
        Cabine ab=new Cabine();
        CabineCRUD c=new CabineCRUD();
        c.Dispo(ab,numeroo);
    }


    @FXML
    private void promx(ActionEvent event) {
    }

    private void settt(ActionEvent event) {
        CabineCRUD resc =new CabineCRUD();
         String z =Typecab.getValue();
        ObservableList<String> liste = FXCollections.observableArrayList(resc.recupererCabine(z));
         listecab.setItems(liste);
    }

    @FXML
    private void afficherCabs(ActionEvent event) {
        CabineCRUD reService = new CabineCRUD();
        List<Cabine> liste = reService.listerCabineDispo();
        ObservableList<Cabine> olist = FXCollections.observableArrayList(liste);
        
        CabProp.setItems(olist);
    }
    
}
    