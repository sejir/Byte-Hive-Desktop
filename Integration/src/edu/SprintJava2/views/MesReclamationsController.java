/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.Guide;
import edu.SprintJava2.entities.ReclamationGuide;
import edu.SprintJava2.entities.ReclamationLocation;
import edu.SprintJava2.entities.Users;
import edu.SprintJava2.services.ReclamationGuideCRUD;
import edu.SprintJava2.services.ReclamationLocationCRUD;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Feryel Derouich
 */
public class MesReclamationsController implements Initializable {
    private static int idguide;
    private static int idrecguide;
    private static int idloc;
    private static int idrecloc;
    private static int idrec;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button bnewrec;
    @FXML
    private Button boldrec;
    @FXML
    private Label labmyrec;
    @FXML
    private Button bretour;
    @FXML
    private Text recguidetext;
    @FXML
    private TableColumn<ReclamationGuide, Integer> col_id_recg;
    private TableColumn<ReclamationGuide, Integer> col_id_client_g;
    @FXML
    private TableColumn<ReclamationGuide, String> coldesc_recg;
    @FXML
    private TableView<ReclamationGuide> tablerecguide;
    @FXML
    private Text rec_loctext;
    @FXML
    private TableView<ReclamationLocation> tablerecloc;
    @FXML
    private TableColumn<ReclamationLocation, String> coldesc1;
    @FXML
    private HBox hbox;
    @FXML
    private TableColumn<ReclamationLocation, Integer> col_id_recl;
    @FXML
    private TextArea textdesc;
    @FXML
    private Button bupdate;
    @FXML
    private Button bdelete;
    @FXML
    private Text nomguidetext;
    @FXML
    private Text nomloctext;
    @FXML
    private Text recGuidetext;
    @FXML
    private Text recloctext;
    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show_guide();
        show_localisation();
        
        
    }    

    public void show_guide (){
       ReclamationGuide rg = new ReclamationGuide();
       rg.getId();
       rg.getDescription();
        Users u = new Users();
        col_id_recg.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , Integer>("id"));
        coldesc_recg.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , String>("description"));
        
        tablerecguide.getItems().clear();
         ObservableList<ReclamationGuide> myList = FXCollections.observableArrayList(ReclamationGuideCRUD.readReclamationUserG(u));
             tablerecguide.setItems(myList);
             
                        
             
    }
    
    public void show_localisation (){
    ReclamationLocation rl = new ReclamationLocation();
        Users uu = new Users();
        col_id_recl.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , Integer>("id"));
        coldesc1.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , String>("description"));
        
        tablerecloc.getItems().clear();
         ObservableList<ReclamationLocation> list = FXCollections.observableArrayList(ReclamationLocationCRUD.readReclamationUserL(uu));
        tablerecloc.setItems(list);
        
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
    private void myrecDetails(MouseEvent event) {
        
        ReclamationGuide rg = new ReclamationGuide();
        Users u = new Users();
        col_id_recg.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , Integer>("id"));
        coldesc_recg.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , String>("description"));
        
        tablerecguide.getItems().clear();
        ObservableList<ReclamationGuide> myList = FXCollections.observableArrayList(ReclamationGuideCRUD.readReclamationUserG(u));
        tablerecguide.setItems(myList);
        
        ReclamationLocation rl = new ReclamationLocation();
        Users uu = new Users();
        col_id_recl.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , Integer>("id"));
        coldesc1.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , String>("description"));
        
        tablerecloc.getItems().clear();
        ObservableList<ReclamationLocation> list = FXCollections.observableArrayList(ReclamationLocationCRUD.readReclamationUserL(uu));
        tablerecloc.setItems(list);
                
        recguidetext.setVisible(true);
        tablerecguide.setVisible(true);
        nomguidetext.setVisible(false);
        recGuidetext.setVisible(false);
        textdesc.setVisible(false);
        bupdate.setVisible(false);
        bdelete.setVisible(false);
        
        
        rec_loctext.setVisible(true);
        tablerecloc.setVisible(true);
        nomloctext.setVisible(false);
        recloctext.setVisible(false);
        textdesc.setVisible(false);
        bupdate.setVisible(false);
        bdelete.setVisible(false);
    }

    

    @FXML
    private void recUpdate(ActionEvent event) {
        /*String reclamation = textdesc.getText();
        ReclamationGuideCRUD rcg = new ReclamationGuideCRUD();
        ReclamationGuide rec = new ReclamationGuide(1,2,  idrec, textdesc.getText());
        rcg.updateReclamationUserG(rec);
        System.out.println(rcg.updateReclamationUserG(rec));
        
        idrec = 0;
        bupdate.setVisible(false);
        textdesc.setVisible(false);
        bdelete.setVisible(false);
        textdesc.clear();*/
        
        Notifications notificationBuilder = Notifications.create()
                .title("Message").text("Reclamation modifiée avec succés!").graphic(null)
                .hideAfter(javafx.util.Duration.seconds(4))
                .position(Pos.CENTER).onAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("clicked ON");
                
            }
        });
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    private void recDelete(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer réclamation");
        alert.setHeaderText("Suppression du réclamation");
        alert.setContentText("Voulez_vous vraiment supprimer votre réclamation?");
        if (alert.showAndWait().get() == ButtonType.OK ) {
            Notifications notificationBuilder = Notifications.create()
                .title("Message").text("Reclamation supprimée!").graphic(null)
                .hideAfter(javafx.util.Duration.seconds(4))
                .position(Pos.CENTER).onAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("clicked ON");
                
            }
        });
        notificationBuilder.darkStyle();
        notificationBuilder.show();
            ReclamationGuideCRUD rgc = new ReclamationGuideCRUD();
            ReclamationGuide rg = new ReclamationGuide();
            rgc.deleteReclamationG(rg.getId());
        }
    
    }

    @FXML
    private void recgDetails(MouseEvent event) {
        ReclamationGuide recg = tablerecguide.getSelectionModel().getSelectedItem();
        if (recg != null) {

            idrecguide = recg.getId();
            nomguidetext.setText(String.valueOf(idrecguide));
        }
        nomguidetext.setVisible(true);
        recGuidetext.setVisible(true);
        textdesc.setVisible(true);
        bupdate.setVisible(true);
        bdelete.setVisible(true);
        nomloctext.setVisible(false);
        recloctext.setVisible(false);
    }

    @FXML
    private void reclDetails(MouseEvent event) {
        ReclamationLocation recl = tablerecloc.getSelectionModel().getSelectedItem();
        if (recl != null) {

            idrecloc = recl.getId();
            nomloctext.setText(String.valueOf(idrecloc));
        }
        nomloctext.setVisible(true);
        recloctext.setVisible(true);
        textdesc.setVisible(true);
        bupdate.setVisible(true);
        bdelete.setVisible(true);
        nomguidetext.setVisible(false);
        recGuidetext.setVisible(false);
    }
    
}
