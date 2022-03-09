/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.Guide;
import edu.SprintJava2.entities.ReclamationGuide;
import edu.SprintJava2.services.ReclamationGuideCRUD;
import doryan.windowsnotificationapi.fr.Notification;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
import edu.SprintJava2.utlis.MyConnection;

/**
 * FXML Controller class
 *
 * @author Feryel Derouich
 */
public class ReclamationGController implements Initializable {
    private static int idguide = 0 ;
    private static String nomguide = null ;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label lablisteg;
    @FXML
    private TableView<Guide> tableguide;
    @FXML
    private TableColumn<Guide, String> col_nom;
    @FXML
    private Button bretour;
    @FXML
    private TextArea textDescriptionRec;
    @FXML
    private Button validerRecBtn;
    @FXML
    private Text recGuidetext;
    @FXML
    private Text nomguidetext;
    @FXML
    private HBox hbox;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Guide gg = new Guide();
        col_nom.setCellValueFactory(new PropertyValueFactory<Guide , String>("nom"));
        
        tableguide.getItems().clear();
        final ObservableList<Guide> myList = FXCollections.observableArrayList(ReclamationGuideCRUD.listerGuides());
        tableguide.setItems(myList);
        
    }

    @FXML
    private void Retour(ActionEvent event) {
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
         Guide guide = tableguide.getSelectionModel().getSelectedItem();
        if (guide != null) {
            
            nomguide = guide.getNom();
            nomguidetext.setText(String.valueOf(nomguide)); 
     }
        nomguidetext.setVisible(true);
        recGuidetext.setVisible(true);
       validerRecBtn.setVisible(true);
        textDescriptionRec.setVisible(true);
    }

    @FXML
    private void validerRec(ActionEvent event) {
       String reclamation = textDescriptionRec.getText();
       ReclamationGuideCRUD rcg = new ReclamationGuideCRUD();
       ReclamationGuide rec = new ReclamationGuide(1, idguide, textDescriptionRec.getText());
        System.out.println(rcg.insertReclamationG(rec));
        //idguide=0;
        validerRecBtn.setVisible(false);
        textDescriptionRec.setVisible(false);
        textDescriptionRec.clear();
        nomguidetext.setVisible(false);
        recGuidetext.setVisible(false);
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
             /*Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("Reclamation Ajouté!");
                a.show();*/
             
    }
   
}
