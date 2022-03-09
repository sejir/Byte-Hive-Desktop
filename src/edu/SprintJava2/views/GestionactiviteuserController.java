/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;
 
import com.notification.NotificationFactory;
import edu.SprintJava2.entities.activites;
import com.notification.NotificationFactory.Location;
import com.notification.NotificationManager;
import com.notification.manager.SimpleManager;
import com.notification.types.TextNotification;
import com.tfgco.pushnotification.PushNotification;
import com.theme.ThemePackagePresets;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.utils.Time;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
 import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import edu.SprintJava2.entities.activites;
import edu.SprintJava2.services.UsersSession;
import edu.SprintJava2.services.activitescrud;
import edu.SprintJava2.utlis.MyConnection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
 import org.controlsfx.control.textfield.AutoCompletionBinding;


/**
 * FXML Controller class
 *
 * @author chiha
 */
public class GestionactiviteuserController implements Initializable {

    
    
        public static final String ACCOUNT_SID = "AC692fa849b80bef1ce8d79f6fe8b04767";
    public static final String AUTH_TOKEN = "cfc6175f3e3ce1efab1268d1d549a1b8";
    
    
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
    @FXML
    private TableColumn<activites, String> tvdescact;
    @FXML
    private TableView<activites> tvactivites;
    @FXML
    private TableColumn<activites, String> tvemplacement;
    @FXML
    private TextField filterField;
  ObservableList<activites> listM;
    ObservableList<activites> dataList;
    private TextField nb_personne;
    @FXML
    private TextField tfnb_personne;
    @FXML
    private TableColumn<activites, Integer> tvnombrepers;
    @FXML
    private Button suggestionbtn;
    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
         showactivitesuser ();
        search_act();
       // rep();
        
                 // System.out.print("test");

        
        
     }    

    
    
    
    public void rep (){
    activitescrud act = new activitescrud();
    act.reporting();
    }
    
    
    
    
    
    @FXML
    private void modifieractivite(ActionEvent event) {
        
         activitescrud a =new activitescrud();
         activites z  =tvactivites.getSelectionModel().getSelectedItem();
        int selectedID = tvactivites.getSelectionModel().getSelectedIndex();
        String nom_act = txnomact.getText();
        String description = txdescirptionact.getText();
        String emplacament = txemplacement.getText() ; 
        Date  d_debut = Date.valueOf(calddebut.getValue());
        Date d_fin = Date.valueOf(caldfinal.getValue());
          int nb_personne = Integer.parseInt(tfnb_personne.getText());
                    int id_user = UsersSession.getId();

          
activites act = new activites(nom_act, description,d_debut,d_fin, emplacament,1,nb_personne,id_user);
   // Date now = Date.parse(today);  
          if ((calddebut.getValue() == null)&&( caldfinal.getValue()==null)&&(caldfinal.getValue()==null) && ( (act.d_debut).after(act.d_fin))/* || ( (act.d_debut).before(now))*/) {
              notif("erreur en modification ", "verifier vos champs svp");
            
        }else {
       a.modifieractivites(act,z.getId_act());
        showactivitesuser();
              notif("modification en succés", "votre modification a été affectuée en succés");
              
              
        /*
          Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21653940997"),
                new com.twilio.type.PhoneNumber("+16812486427"),
                "?")
            .create();
        /*
        
        */
        
            //  a.sms();

     }}

    @FXML
    private void ajouteractivite(ActionEvent event) {        
        
        String nom_act = txnomact.getText();
        String description = txdescirptionact.getText();
        String emplacament = txemplacement.getText() ; 
        Date  d_debut = Date.valueOf(calddebut.getValue());
        Date d_fin = Date.valueOf(caldfinal.getValue());
          int nb_personne = Integer.parseInt(tfnb_personne.getText());
                     int id_user = UsersSession.getId();

activites act = new activites(nom_act, description,d_debut,d_fin, emplacament,1,nb_personne,id_user);   
    
         if ((calddebut.getValue() == null)&&( caldfinal.getValue()==null)&& (caldfinal.getValue()==null)&& ( (act.d_debut).after(act.d_fin))) {
               notif("erreur","verifier votre champs svp");
  
        }else {  activitescrud a = new activitescrud() ;
      a.ajouteractivites(act);
       showactivitesuser ();
        notif("Activité","Activité Ajoutée");
        a.sms();
        }
   
  

    
    }
     
    void notif(String title, String subtitle){
        NotificationFactory factory = new NotificationFactory(ThemePackagePresets.cleanLight());
NotificationManager plain = new SimpleManager(Location.SOUTHEAST);

TextNotification notification = factory.buildTextNotification(title,subtitle);
notification.setCloseOnClick(true);
plain.addNotification(notification, Time.seconds(4));
    }
    

    @FXML
    private void supprimeractivite(ActionEvent event) {
         activitescrud a =new activitescrud();
         activites act  =tvactivites.getSelectionModel().getSelectedItem();
         a.delete(act.getId_act());
       int selectedID = tvactivites.getSelectionModel().getSelectedIndex();
        tvactivites.getItems().remove(selectedID);
         showactivitesuser ();
              notif("suppression","suppression avec succés ");

    }
 
    public void showactivitesuser (){
     activitescrud act = new activitescrud();
                          int id_user = UsersSession.getId();

      ObservableList <activites> list = act.listeruser(id_user);
        tvnomact.setCellValueFactory(new PropertyValueFactory<activites,String>("nom_act"));
        tvdebut.setCellValueFactory(new PropertyValueFactory<activites,Date>("d_debut"));
        tvdatefinal.setCellValueFactory(new PropertyValueFactory<activites,Date>("d_fin"));
        tvemplacement.setCellValueFactory(new PropertyValueFactory<activites,String>("emplacement"));
         tvdescact.setCellValueFactory(new PropertyValueFactory<activites,String>("description"));
                  tvnombrepers.setCellValueFactory(new PropertyValueFactory<activites,Integer>("nb_personne"));


        //System.out.print("test");
        tvactivites.setItems(list);
    }

    @FXML
    private void selectrow(MouseEvent event) {
        activites act  =tvactivites.getSelectionModel().getSelectedItem();
        System.out.println("id"+act.getId_act());
        
        txnomact.setText(act.nom_act);
        calddebut.setValue(LocalDate.parse(act.d_debut.toString()));
        caldfinal.setValue(LocalDate.parse(act.d_fin.toString()));
        txemplacement.setText(act.emplacement);
        txdescirptionact.setText(act.description);
        Date.valueOf(calddebut.getValue());
        tfnb_personne.setText( String.valueOf(act.nb_personne));
        
    }
    
    @FXML
    void suggestion(ActionEvent event){
        
        activitescrud ac = new activitescrud();
         txnomact.setText( ac.suggestion(Integer.parseInt(tfnb_personne.getText())));
                txemplacement.setText( ac.suggestion(Integer.parseInt(tfnb_personne.getText())));

 
    }
   
    public void reportingsms (){
            activitescrud ac = new activitescrud();
            String a=ac.reporting();
//.smsreporting( ac.reporting);
    
    }
    
    
    
    
    void search_act() {      
               activitescrud act = new activitescrud();
                               int id_user = UsersSession.getId();

      ObservableList <activites> list = act.listeruser(id_user);
        tvnomact.setCellValueFactory(new PropertyValueFactory<activites,String>("nom_act"));
        tvdebut.setCellValueFactory(new PropertyValueFactory<activites,Date>("d_debut"));
        tvdatefinal.setCellValueFactory(new PropertyValueFactory<activites,Date>("d_fin"));
        tvemplacement.setCellValueFactory(new PropertyValueFactory<activites,String>("emplacement"));
         tvdescact.setCellValueFactory(new PropertyValueFactory<activites,String>("description"));


        //System.out.print("test");
        tvactivites.setItems(list);
            dataList = act.listeruser(id_user);
        
         FilteredList<activites> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(activites -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (activites.getNom_act().toLowerCase().contains(lowerCaseFilter) ) {
     return true; // Filter matches username
    } else if (activites.getEmplacement().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    } 
         else  
          return false; // Does not match.
   });
  });  
  SortedList<activites> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(tvactivites.comparatorProperty());  
  tvactivites.setItems(sortedData);      
    }

    @FXML
    private void retourner(ActionEvent event) {
        NewFXMain.setScene("Interface_User");
    }

    @FXML
    private void book(ActionEvent event) {
        NewFXMain.setScene("GestionReservation");
        
    }
    
    
 
    
    
    
    
    
    
    
    }
    

   


