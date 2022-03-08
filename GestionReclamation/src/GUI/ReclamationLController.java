/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Guide;
import Entities.Localisation;
import Entities.ReclamationGuide;
import Entities.ReclamationLocation;
import Services.ReclamationGuideCRUD;
import Services.ReclamationLocationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Feryel Derouich
 */
public class ReclamationLController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private static int idloc = 0 ;
    @FXML
    private Label lablistel;
    @FXML
    private Button bretour;
    @FXML
    private TableView<Localisation> tableloc;
    @FXML
    private TableColumn<Localisation, Integer> col_id_l;
    @FXML
    private TableColumn<Localisation, String> col_desc;
    @FXML
    private Text recloctext;
    @FXML
    private Text locidtext;
    @FXML
    private TextArea textDescriptionRec;
    @FXML
    private Button validerRecBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Localisation gg = new Localisation();
        col_id_l.setCellValueFactory(new PropertyValueFactory<Localisation , Integer>("id"));
        col_desc.setCellValueFactory(new PropertyValueFactory<Localisation , String>("description"));
        
        tableloc.getItems().clear();
        final ObservableList<Localisation> listl = FXCollections.observableArrayList(ReclamationLocationCRUD.listerLocalisations());
        tableloc.setItems(listl);
    }    

    @FXML
    private void retour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("Error:"+ex.getMessage());
        }
    }
    
    @FXML
    private void recDetails(MouseEvent event) {
         Localisation guide = tableloc.getSelectionModel().getSelectedItem();
        if (guide != null) {
            
            idloc = guide.getId();
            locidtext.setText(String.valueOf(idloc));
            
        
         
     }
        locidtext.setVisible(true);
        recloctext.setVisible(true);
       validerRecBtn.setVisible(true);
        textDescriptionRec.setVisible(true);
    }

    @FXML
    private void validerRec(ActionEvent event) {
        
         String reclamation = textDescriptionRec.getText();
       ReclamationLocationCRUD rcl = new ReclamationLocationCRUD();
       ReclamationLocation rec = new ReclamationLocation(1,idloc,textDescriptionRec.getText());
        System.out.println(rcl.insertReclamationL(rec));
        idloc=0;
        validerRecBtn.setVisible(false);
        textDescriptionRec.setVisible(false);
        textDescriptionRec.clear();
        locidtext.setVisible(false);
        recloctext.setVisible(false);
        Notifications notificationBuilder = Notifications.create()
                .title("Message").text("Reclamation Ajouté avec succés!").graphic(null)
                .hideAfter(javafx.util.Duration.seconds(4))
                .position(Pos.CENTER).onAction(new EventHandler<ActionEvent>(){
                 public void handle(ActionEvent event)
                 {
                     System.out.println("clicked ON");
                 }
                });
        notificationBuilder.darkStyle();
        notificationBuilder.show();
             /*Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setContentText("Reclamation Ajouté!");
                a.show();*/
    }
    
    
}
