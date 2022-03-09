/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.EquipementVendre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLEquipV1Controller implements Initializable {

    @FXML
    private ImageView IVEquipV;
    @FXML
    private Label labelNomEquipV;
    @FXML
    private Label labelDescriptionEquipV;
    @FXML
    private Label labelPrixEquipV;
    @FXML
    private Label labelQuantiteEquipV;
    @FXML
    private Label labelIdEquipV;
    @FXML
    private Label labelIdFournisseur;
    @FXML
    private Rating ratingEquipV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
     public void afficher(EquipementVendre ev){
            labelNomEquipV.setText(ev.getNomEquipement());
            labelPrixEquipV.setText(ev.getPrixEquipement());
            labelQuantiteEquipV.setText(ev.getQuantiteEquipement());
            labelDescriptionEquipV.setText(ev.getDescriptionEquipement());
            javafx.scene.image.Image im =new javafx.scene.image.Image(ev.getImageEquipement());
            IVEquipV.setImage(im);
            labelIdEquipV.setText(Integer.toString(ev.getIdEquipement()));
            labelIdFournisseur.setText(Integer.toString(ev.getIdFournisseur()));
            ratingEquipV.setRating(ev.getRating());
    }  
     
}
