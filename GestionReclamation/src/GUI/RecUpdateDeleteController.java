/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.ReclamationGuide;
import Services.ReclamationGuideCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Feryel Derouich
 */
public class RecUpdateDeleteController implements Initializable {

    private static int idrec = 0 ;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label labvotrerec;
    @FXML
    private Button bretour;
    @FXML
    private TextArea textdesc;
    @FXML
    private Button bupdate;
    @FXML
    private Button bdelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void recUpdate(ActionEvent event) {

        String reclamation = textdesc.getText();
        ReclamationGuideCRUD rcg = new ReclamationGuideCRUD();
        ReclamationGuide rec = new ReclamationGuide(1, idrec, textdesc.getText());
        System.out.println(rcg.updateReclamationUserG(rec));
        idrec = 0;
        bupdate.setVisible(false);
        textdesc.setVisible(false);
        textdesc.clear();
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
        /*Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setContentText("Reclamation mise à jour!");
                a.show();*/
    }

    @FXML
    private void recDelete(ActionEvent event) {
        /*activitescrud a =new activitescrud();
         activites act  =tvactivites.getSelectionModel().getSelectedItem();
         a.delete(act.getId_act());
       int selectedID = tvactivites.getSelectionModel().getSelectedIndex();
        tvactivites.getItems().remove(selectedID);
         showactivites ();*/
        
    }
    
}
