/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.EquipementLouer;
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
public class FXMLEquipementLController implements Initializable {

    @FXML
    private Label labelNomEquipL;
    @FXML
    private Label LabelDescriptionEquipL;
    @FXML
    private Label labelPrixEquipL;
    @FXML
    private ImageView IVEquipL;
    @FXML
    private Label labelIdEquipL;
    @FXML
    private Label labelIdFEquipL;
    private Rating ratinigEquipL;
    @FXML
    private Rating ratingEquipL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void afficher(EquipementLouer el){  
            labelNomEquipL.setText(el.getNomEquipement());
            labelPrixEquipL.setText(el.getPrixEquipement());
            LabelDescriptionEquipL.setText(el.getDescriptionEquipement());
            javafx.scene.image.Image im =new javafx.scene.image.Image(el.getImageEquipement());
            IVEquipL.setImage(im);
            labelIdEquipL.setText(Integer.toString(el.getIdEquipement()));
            labelIdFEquipL.setText(Integer.toString(el.getIdFournisseur()));
            ratingEquipL.setRating(el.getRating());
    }  
    
}
