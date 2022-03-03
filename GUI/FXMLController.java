/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import reservation.entities.res_cabine;
import reservation.services.res_cabineCRUD;


/**
 * FXML Controller class
 *
 * @author Sejir
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField idCabine;
    @FXML
    private TextField nbrpC;
    @FXML
    private TextField TypeC;
    
    @FXML
    private TextField prixC;
    @FXML
    private Button AjoutC;
    @FXML
    private TableView<?> tablec;
    @FXML
    private ComboBox<String> cbx;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }    

    public FXMLController() {
    }

    @FXML
    private void AjouterCabine(ActionEvent event) {
        
            int id = Integer.parseInt(idCabine.getText());
        int nbrp = Integer.parseInt(nbrpC.getText());
        String Typec = TypeC.getText();
        float Prix = Float.parseFloat(nbrpC.getText());
        res_cabine D=new res_cabine(52,id,nbrp,Typec,Prix);
        res_cabineCRUD resc=new res_cabineCRUD();
        resc.ajouterCabine(D);
            
    }
    
}
