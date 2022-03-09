/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.ClientLouer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLClientLouerController implements Initializable {

    @FXML
    private ImageView IVEquip;
    @FXML
    private Label labelNomClient;
    @FXML
    private Label labelNomEquip;
    @FXML
    private Label labelDateRemise;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void afficher(ClientLouer cl){
            labelNomClient.setText(cl.getNomEquipement());
            labelNomEquip.setText(cl.getNomClient());
            //labelDateRemise.setText((cl.getDateRemise()).toString());
            javafx.scene.image.Image im =new javafx.scene.image.Image(cl.getImage());
            IVEquip.setImage(im);
            
    }
    
       
    
    
}
