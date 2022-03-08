/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Guide;
import Entities.ReclamationGuide;
import Entities.ReclamationLocation;
import Entities.Utilisateur;
import Services.ReclamationGuideCRUD;
import Services.ReclamationLocationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Feryel Derouich
 */
public class MesReclamationsController implements Initializable {
    private static int idguide;
    private static int idloc;
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
    @FXML
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
    private TableColumn<ReclamationLocation, Integer> col_id1;
    @FXML
    private TableColumn<ReclamationLocation, Integer> col_id_client1;
    @FXML
    private TableColumn<ReclamationLocation, String> coldesc1;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ReclamationGuide rg = new ReclamationGuide();
        Utilisateur u = new Utilisateur();
        col_id_recg.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , Integer>("id"));
        col_id_client_g.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , Integer>("id_client"));
        coldesc_recg.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , String>("description"));
        
        tablerecguide.getItems().clear();
         ObservableList<ReclamationGuide> myList = FXCollections.observableArrayList(ReclamationGuideCRUD.readReclamationUserG(u));
        tablerecguide.setItems(myList);
        
        ReclamationLocation rl = new ReclamationLocation();
        Utilisateur uu = new Utilisateur();
        col_id1.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , Integer>("id"));
        col_id_client1.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , Integer>("id_client"));
        coldesc1.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , String>("description"));
        
        tablerecloc.getItems().clear();
        final ObservableList<ReclamationLocation> list = FXCollections.observableArrayList(ReclamationLocationCRUD.readReclamationUserL(uu));
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
        Utilisateur u = new Utilisateur();
        col_id_recg.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , Integer>("id"));
        col_id_client_g.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , Integer>("id_client"));
        coldesc_recg.setCellValueFactory(new PropertyValueFactory<ReclamationGuide , String>("description"));
        
        tablerecguide.getItems().clear();
        ObservableList<ReclamationGuide> myList = FXCollections.observableArrayList(ReclamationGuideCRUD.readReclamationUserG(u));
        tablerecguide.setItems(myList);
        
        ReclamationLocation rl = new ReclamationLocation();
        Utilisateur uu = new Utilisateur();
        col_id1.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , Integer>("id"));
        col_id_client1.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , Integer>("id_client"));
        coldesc1.setCellValueFactory(new PropertyValueFactory<ReclamationLocation , String>("description"));
        
        tablerecloc.getItems().clear();
        final ObservableList<ReclamationLocation> list = FXCollections.observableArrayList(ReclamationLocationCRUD.readReclamationUserL(uu));
        tablerecloc.setItems(list);
                
        recguidetext.setVisible(true);
        tablerecguide.setVisible(true);
        
        ReclamationLocation rlc = tablerecloc.getSelectionModel().getSelectedItem();
        
        rec_loctext.setVisible(true);
        tablerecloc.setVisible(true);
    }

    @FXML
    private void recDetails(MouseEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("RecUpdateDelete.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("Error:"+ex.getMessage());
        }
    }
    
    

}
