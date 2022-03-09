/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.ClientLouer;
import edu.SprintJava2.entities.EquipementLouer;
import edu.SprintJava2.entities.EquipementVendre;
import edu.SprintJava2.entities.Louer;
import edu.SprintJava2.services.EquipementLouerCRUD;
import edu.SprintJava2.services.EquipementVendreCRUD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLEquipementLouerController implements Initializable {

    private TableView<EquipementLouer> TVEquipV;
    @FXML
    private Button btnImage;
    @FXML
    private TextField TFImageEquipL;
    @FXML
    private TextField TFNomEquipL;
    @FXML
    private TextArea TADescriptionEquipL;
    @FXML
    private TextField TFPrixEquipL;
    @FXML
    private TextField TFidEquipL;
    @FXML
    private Button btnAjouterEquipL;
    @FXML
    private Button btnModifierEquipL;
    @FXML
    private Button btnSupprimerEquipL;
  
    private final int MAX_COLUMNS = 5 ; 
    @FXML
    private GridPane gridEquipL;
    @FXML
    private TextField TFIdFournisseur;
    @FXML
    private Button btnQuitter;
    @FXML
    private GridPane gridLouer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherEquipL();
        afficherLouer();
    }  
    @FXML
    private void selectionnerImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        fileChooser.setInitialDirectory(new File("C:\\Users\\chayma\\Desktop\\image"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            String TempprofilePicture = file.toURI().toString();
            System.out.println(TempprofilePicture);
            //Image image = new Image(TempprofilePicture);
            TFImageEquipL.setText(TempprofilePicture);
            
        }
    }

    @FXML
    private void ajouterEquipL(ActionEvent event) {
        String nom = TFNomEquipL.getText();
        String prix = TFPrixEquipL.getText();
        String Description = TADescriptionEquipL.getText();
        String image = TFImageEquipL.getText();
        int idF = Integer.parseInt(TFIdFournisseur.getText());//[a-zA-Z0-9]+\\.[a-zA-Z]
        if((TFNomEquipL.getText().matches("^[a-zA-Z]+$")|| !TFNomEquipL.getText().isEmpty())&&(TFPrixEquipL.getText().matches("^[0-9]+$") || !TFPrixEquipL.getText().isEmpty())&&(TADescriptionEquipL.getText().matches("^[a-z A-Z 0-9]+$") || !TADescriptionEquipL.getText().isEmpty())&& TFIdFournisseur.getText().matches("^[0-9]+$")){
            EquipementLouer el = new EquipementLouer(0, nom, prix, Description, image, idF, 1);
            EquipementLouerCRUD evc = new EquipementLouerCRUD();
            evc.ajouterEquipementLouer(el);
            JOptionPane.showMessageDialog(null,"l'equipement a été ajouté avec succes");
            gridEquipL.getChildren().clear();
            afficherEquipL();
        //afficherChiffreAffaire();

            TFNomEquipL.setText("");
            TFPrixEquipL.setText("");
            TADescriptionEquipL.setText("");
            TFImageEquipL.setText("");

            TFIdFournisseur.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null,"verifier les donnees");
        }
    }

    private void afficherEquipL(){
       int row = 0;
        int column = 0;
        List<EquipementLouer> list = new ArrayList();
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        list = evc.listerEquipementLouer1();
        try {
            for (int i = 0; i < list.size(); i++) {
                
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipementL.fxml"));
                                
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id "+ i);                
                vbox.setId("Equipement_"+i);                                                
                
                FXMLEquipementLController itemController = itemFxmlLoader.getController();
                itemController.afficher(list.get(i));
                if (column == MAX_COLUMNS) {
                    column = 0;
                    row++;
                }
                gridEquipL.add(vbox, column++, row);
                GridPane.setMargin(vbox, new Insets(10));
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private void afficherLouer(){
       int row = 0;
        int column = 0;
        List<ClientLouer> list = new ArrayList();
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        list = evc.clientEquip();
        try {
            for (int i = 0; i < list.size(); i++) {
                
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLClientLouer.fxml"));
                                
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id "+ i);                
                vbox.setId("Equipement_"+i);                                                
                
                FXMLClientLouerController itemController = itemFxmlLoader.getController();
                itemController.afficher(list.get(i));
                if (column == MAX_COLUMNS) {
                    column = 0;
                    row++;
                }
                gridLouer.add(vbox, column++, row);
                GridPane.setMargin(vbox, new Insets(10));
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    @FXML
    private void modifierEquipL(ActionEvent event) {
        int id = Integer.parseInt(TFidEquipL.getText());
        String nom = TFNomEquipL.getText();
        String prix = TFPrixEquipL.getText();
        String Description = TADescriptionEquipL.getText();
        String image = TFImageEquipL.getText();
        int idF = Integer.parseInt(TFIdFournisseur.getText());
        
        EquipementLouer el = new EquipementLouer(id,nom,prix,Description,image,idF,1);
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        try{
            if((TFNomEquipL.getText().matches("^[a-zA-Z]+$")|| !TFNomEquipL.getText().isEmpty())&&(TFPrixEquipL.getText().matches("^[0-9]+$") || !TFPrixEquipL.getText().isEmpty())&&(TADescriptionEquipL.getText().matches("^[a-z A-Z 0-9]+$") || !TADescriptionEquipL.getText().isEmpty())&& TFIdFournisseur.getText().matches("^[0-9]+$"))
            {
                evc.modifierEquipementLouer(id,el);
                gridEquipL.getChildren().clear();
                afficherEquipL();
                JOptionPane.showMessageDialog(null, "L'equipement à ete modifier avec succes");
                TFidEquipL.setText("");
                TFNomEquipL.setText("");
                TFPrixEquipL.setText("");
                TADescriptionEquipL.setText("");
                TFImageEquipL.setText("");  
                TFIdFournisseur.setText("");
            }else{
                JOptionPane.showMessageDialog(null,"verifier les donnees");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void supprimerEquipL(ActionEvent event) {
        int id = Integer.parseInt(TFidEquipL.getText());
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        evc.supprimerEquipementLouer(id);
        gridEquipL.getChildren().clear();
        afficherEquipL();
        JOptionPane.showMessageDialog(null,"l'equipement a été supprimé avec succès");        
        TFidEquipL.setText("");
        TFNomEquipL.setText("");
        TFPrixEquipL.setText("");
        TADescriptionEquipL.setText("");
        TFImageEquipL.setText("");  
        TFIdFournisseur.setText("");
    }

    @FXML
    private void selectionner(MouseEvent event) {
        ObservableList<Node> children= gridEquipL.getChildren();                        

        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode != gridEquipL) {                        
                // click on descendant node
                Node parent = clickedNode.getParent();
                while (parent != gridEquipL) {
                    clickedNode = parent;
                    parent = clickedNode.getParent();
                }
                Integer colIndex = GridPane.getColumnIndex(clickedNode);
                Integer rowIndex = GridPane.getRowIndex(clickedNode);
                //System.out.println("Mouse clicked on : " + colIndex + "  and " + rowIndex);
      
                int targetNodePosition = colIndex + MAX_COLUMNS * rowIndex; 
                                
                VBox targetItem = (VBox) children.get(targetNodePosition) ;                 
                
                TFNomEquipL.setText( ((Label)targetItem.getChildren().get(2)).getText()  );
                TADescriptionEquipL.setText( ((Label)targetItem.getChildren().get(4)).getText());
                TFPrixEquipL.setText( ((Label)targetItem.getChildren().get(6)).getText() );
                TFIdFournisseur.setText( ((Label)targetItem.getChildren().get(9)).getText());
                TFidEquipL.setText( ((Label)targetItem.getChildren().get(8)).getText());
                //TFImageEquipV.setText( ((Label)targetItem.getChildren().get(0)).getText());   
                 
        }
    }

    @FXML
    private void quitter(ActionEvent event) {
         try{
            btnQuitter.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("FXMLMenuEquipement.fxml"));
                Stage mainStage = new Stage();
                Scene scene= new Scene(root);
                mainStage.setScene(scene);
                 mainStage.setTitle("Equipements à Vendre");
                mainStage.show();
               // JOptionPane.showMessageDialog(null, "Bienvenue dans votre interface Equipements à Vendre");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    
}
