/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.EquipementLouer;
import edu.SprintJava2.entities.EquipementVendre;
import edu.SprintJava2.services.EquipementVendreCRUD;
import edu.SprintJava2.utlis.MyConnection;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLEquipementVCController implements Initializable {

    @FXML
    private GridPane gridEquipV;
    @FXML
    private Button btnAjouterEquipV;
    @FXML
    private Button btnModifierEquipV;
    @FXML
    private Button btnSupprimerequipV;
    @FXML
    private TextField TFNomEquipV;
    @FXML
    private TextField TFPrixEquipV;
    @FXML
    private TextField TFQuantiteEquipV;
    @FXML
    private TextField TFIdFournisseur;
    @FXML
    private TextArea TADescriptionEquipV;
    @FXML
    private TextField TFImageEquipV;
    @FXML
    private LineChart<?, ?> lineChartEquiV;
    @FXML
    private TextField TFIdEquipV;

    private final int MAX_COLUMNS = 5;
    @FXML
    private Button btnQuitter;
    @FXML
    private Label labelChiffreAffaire;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherEquipV();
       // Statistique();
        String f=chiffreAffaire();
        labelChiffreAffaire.setText(f);

    }

    @FXML
    private void ajouterEquipV(ActionEvent event) {
        String nom = TFNomEquipV.getText();
        String prix = TFPrixEquipV.getText();
        String Description = TADescriptionEquipV.getText();
        String image = TFImageEquipV.getText();
        String quantite = TFQuantiteEquipV.getText();
        int idF = Integer.parseInt(TFIdFournisseur.getText());

        if ((TFNomEquipV.getText().matches("^[a-zA-Z]+$")|| !TFNomEquipV.getText().isEmpty())&&(TFPrixEquipV.getText().matches("^[0-9]+$") || !TFPrixEquipV.getText().isEmpty())&&(TADescriptionEquipV.getText().matches("^[a-z A-Z 0-9]+$") || !TADescriptionEquipV.getText().isEmpty())&& TFIdFournisseur.getText().matches("^[0-9]+$") && (TFQuantiteEquipV.getText().matches("^[0-9]+$") || !TFQuantiteEquipV.getText().isEmpty())) {
            EquipementVendre ev = new EquipementVendre(0, nom, prix, Description, image, quantite, idF);
            EquipementVendreCRUD evc = new EquipementVendreCRUD();
            evc.ajouterEquipementVendre(ev);
            
            JOptionPane.showMessageDialog(null, "l'equipement a été ajouté avec succes");
            
            gridEquipV.getChildren().clear();
            afficherEquipV();
            
            TFNomEquipV.setText("");
            TFPrixEquipV.setText("");
            TADescriptionEquipV.setText("");
            TFImageEquipV.setText("");
            TFQuantiteEquipV.setText("");
            TFIdFournisseur.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "verifier les donnees");
        }

    }

    private void afficherEquipV() {
        int row = 0;
        int column = 0;
        List<EquipementVendre> list;
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        
        list = evc.listerEquipementVendre();
        try {
            for (int i = 0; i < list.size(); i++) {
                System.err.println("size " + list.size());
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipV1.fxml"));

                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);

                vbox.setId("Equipement_" + i);
                System.err.println(i);
                FXMLEquipV1Controller itemController = itemFxmlLoader.getController();
                itemController.afficher(list.get(i));
                if (column == MAX_COLUMNS) {
                    column = 0;
                    row++;
                }
                gridEquipV.add(vbox, column++, row);
                GridPane.setMargin(vbox, new Insets(10));
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modifierEquipV(ActionEvent event) {
        int id = Integer.parseInt(TFIdEquipV.getText());
        String nom = TFNomEquipV.getText();
        String prix = TFPrixEquipV.getText();
        String Description = TADescriptionEquipV.getText();
        String image = TFImageEquipV.getText();
        String quantite = TFQuantiteEquipV.getText();
        int idF = Integer.parseInt(TFIdFournisseur.getText());

        EquipementVendre ev = new EquipementVendre(id, nom, prix, Description, image, quantite, idF);
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        try {
            if ((TFNomEquipV.getText().matches("^[a-zA-Z]+$")|| !TFNomEquipV.getText().isEmpty())&&(TFPrixEquipV.getText().matches("^[0-9]+$") || !TFPrixEquipV.getText().isEmpty())&&(TADescriptionEquipV.getText().matches("^[a-z A-Z 0-9]+$") || !TADescriptionEquipV.getText().isEmpty())&& TFIdFournisseur.getText().matches("^[0-9]+$") && (TFQuantiteEquipV.getText().matches("^[0-9]+$") || !TFQuantiteEquipV.getText().isEmpty())){
                evc.modifierEquipementVendre(id, ev);

                gridEquipV.getChildren().clear();
                afficherEquipV();

                JOptionPane.showMessageDialog(null, "L'equipement à ete modifier avec succes");

                TFIdEquipV.setText("");
                TFNomEquipV.setText("");
                TFPrixEquipV.setText("");
                TADescriptionEquipV.setText("");
                TFImageEquipV.setText("");
                TFQuantiteEquipV.setText("");
                TFIdFournisseur.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "verifier les donnees");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void supprimerEquipV(ActionEvent event) {       
        int id = Integer.parseInt(TFIdEquipV.getText());
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        evc.supprimerEquipementVendre(id);
        
        gridEquipV.getChildren().clear();
        afficherEquipV();
        
        JOptionPane.showMessageDialog(null, "l'equipement a été supprimé avec succès");
        
        TFIdEquipV.setText("");
        TFNomEquipV.setText("");
        TFPrixEquipV.setText("");
        TADescriptionEquipV.setText("");
        TFImageEquipV.setText("");
        TFQuantiteEquipV.setText("");
        TFIdFournisseur.setText("");
    }
    
    @FXML
    private void selectionner(MouseEvent event) {
        ObservableList<Node> children = gridEquipV.getChildren();
        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode != gridEquipV) {
            // click on descendant node
            Node parent = clickedNode.getParent();
            while (parent != gridEquipV) {
                clickedNode = parent;
                parent = clickedNode.getParent();
            }
            Integer colIndex = GridPane.getColumnIndex(clickedNode);
            Integer rowIndex = GridPane.getRowIndex(clickedNode);
            //System.out.println("Mouse clicked on : " + colIndex + "  and " + rowIndex);
            int targetNodePosition = colIndex + MAX_COLUMNS * rowIndex;
            VBox targetItem = (VBox) children.get(targetNodePosition);
            
            TFNomEquipV.setText(((Label) targetItem.getChildren().get(2)).getText());
            TADescriptionEquipV.setText(((Label) targetItem.getChildren().get(4)).getText());
            TFPrixEquipV.setText(((Label) targetItem.getChildren().get(6)).getText());
            TFQuantiteEquipV.setText(((Label) targetItem.getChildren().get(8)).getText());
            TFIdEquipV.setText(((Label) targetItem.getChildren().get(10)).getText());
            TFIdFournisseur.setText(((Label) targetItem.getChildren().get(11)).getText());
            //TFImageEquipV.setText( ((Label)targetItem.getChildren().get(0)).getText());   
        }
    }

    private void Statistique() {        
        XYChart.Series series = new XYChart.Series();
        String requete = "select nomEquipement,quantiteEquipement from equipementvendre";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                series.getData().add(new XYChart.Data(rs.getString(1), Integer.parseInt(rs.getString(2))));
                lineChartEquiV.getData().add(series);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Quitter(ActionEvent event) {
        try{
            btnQuitter.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("FXMLMenuEquipement.fxml"));
                Stage mainStage = new Stage();
                Scene scene= new Scene(root);
                mainStage.setScene(scene);
                 mainStage.setTitle("Equipements à Vendre");
                mainStage.show();
                JOptionPane.showMessageDialog(null, "Bienvenue dans votre interface Equipements à Vendre");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }

    @FXML
    private void clickImage(ActionEvent event) {
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
            TFImageEquipV.setText(TempprofilePicture);
            
    }
    }
    
    private String chiffreAffaire(){
        String f="";
        try {
            String requete = "SELECT sum(prixEquipement) FROM vendre";
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                f=rs.getString(f);
                return f;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return null;
       
    }
}
