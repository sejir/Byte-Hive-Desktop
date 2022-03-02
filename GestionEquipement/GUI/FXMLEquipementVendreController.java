/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.org.glassfish.gmbal.Description;
import edu.naturecruise.entites.EquipementVendre;
import edu.naturecruise.services.EquipementVendreCRUD;
import edu.naturecruise.utils.MyConnetion;
import java.awt.Desktop;
import static java.awt.SystemColor.text;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLEditorKit;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLEquipementVendreController implements Initializable {

    @FXML
    private TableView<EquipementVendre> TVEquipV;
    @FXML
    private javafx.scene.control.TextField TFNomEquipV;
    @FXML
    private javafx.scene.control.TextField TFPrixEquipV;
    @FXML
    private javafx.scene.control.TextField TFQuantiteEquipV;
    @FXML
    private Button BTNAjouterEquipV;
    @FXML
    private javafx.scene.control.TextArea TADescriptionEquipV;
    @FXML
    private Button BTNModifierEquipV;
    @FXML
    private Button BTNSupprimerEquipV;
    @FXML
    private javafx.scene.control.TextField TFIdFEquipV;
    @FXML
    private TableColumn<EquipementVendre, Integer> colIdEquipV;
    @FXML
    private TableColumn<EquipementVendre, String> colNomEquipV;
    @FXML
    private TableColumn<EquipementVendre, Float> colPrixEquipV;
    @FXML
    private TableColumn<EquipementVendre, String> colDescriptionEquipV;
    @FXML
    private TableColumn<EquipementVendre, String> colImageEquipV;
    @FXML
    private TableColumn<EquipementVendre, Integer> colQuantiteEquipV;
    @FXML
    private javafx.scene.control.TextField TFIdEquipV;

    @FXML
    private TableColumn<EquipementVendre,Integer> colIdFEquipV;
    @FXML
    private javafx.scene.control.TextField TFImageEquipV;
    @FXML
    private javafx.scene.control.TextField TFId;
    @FXML
    private TableColumn<EquipementVendre,Float> colPrixTotalEquipV;
    @FXML
    private TableColumn<EquipementVendre, String> colNomEquipV1;
    @FXML
    private Button BTNquitterEquipV;
    @FXML
    private TableView<EquipementVendre> TVPrixEquipV;
    @FXML
    private javafx.scene.control.TextField TFRechercheEquipV;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherEquipementV();
        afficherChiffreAffaire();
        searchProduit();
    }  

    @FXML
    private void ajouterEquipementV(javafx.event.ActionEvent event) {
                
        String nom = TFNomEquipV.getText();
        float prix = Integer.parseInt(TFPrixEquipV.getText());
        String Description = TADescriptionEquipV.getText();
        String image = TFImageEquipV.getText();
        int quantite = Integer.parseInt(TFQuantiteEquipV.getText());
        int idF = Integer.parseInt(TFIdFEquipV.getText());
        if(TFIdEquipV.getText().matches("^[0-9]+$")&&TFNomEquipV.getText().matches("^[a-zA-Z]+$")&&TFPrixEquipV.getText().matches("^[0-9]+$")&&TADescriptionEquipV.getText().matches("^[a-z A-Z 0-9]+$")&&TFImageEquipV.getText().matches("^[a-z A-Z]+$")&&TFQuantiteEquipV.getText().matches("^[0-9]+$") && TFIdFEquipV.getText().matches("^[0-9]+$"))
        {
            EquipementVendre ev = new EquipementVendre(0,nom,prix,Description,image,quantite,idF);
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        evc.ajouterEquipementVendre(ev);
        JOptionPane.showMessageDialog(null,"l'equipement a été ajouté avec succes");
        afficherEquipementV();
        afficherChiffreAffaire();
        TFIdEquipV.setText("");
        TFNomEquipV.setText("");
        TFPrixEquipV.setText("");
        TADescriptionEquipV.setText("");
        TFImageEquipV.setText("");
        TFQuantiteEquipV.setText("");
        TFIdFEquipV.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null,"verifier les donnees");
        }
        
        
    }

    private void afficherEquipementV() {
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        ObservableList<EquipementVendre> listEqV = evc.listerEquipementVendre();
        colIdEquipV.setCellValueFactory(new PropertyValueFactory<EquipementVendre,Integer>("idEquipement"));
        colNomEquipV.setCellValueFactory(new PropertyValueFactory<EquipementVendre,String>("nomEquipement"));
        colPrixEquipV.setCellValueFactory(new PropertyValueFactory<EquipementVendre,Float>("prixEquipement"));
        colDescriptionEquipV.setCellValueFactory(new PropertyValueFactory<EquipementVendre,String>("descriptionEquipement"));
        colImageEquipV.setCellValueFactory(new PropertyValueFactory<EquipementVendre,String>("imageEquipement"));
        colQuantiteEquipV.setCellValueFactory(new PropertyValueFactory<EquipementVendre,Integer>("quantiteEquipement"));
        colIdFEquipV.setCellValueFactory(new PropertyValueFactory<EquipementVendre,Integer>("idFournisseur"));

        TVEquipV.setItems(listEqV);
    }
    
    @FXML
    private void modifierEquipementV(javafx.event.ActionEvent event) {
        int id = Integer.parseInt(TFIdEquipV.getText());
        String nom = TFNomEquipV.getText();
        float prix = Integer.parseInt(TFPrixEquipV.getText());
        String Description = TADescriptionEquipV.getText();
        int quantite = Integer.parseInt(TFQuantiteEquipV.getText());
        int idF = Integer.parseInt(TFIdFEquipV.getText());
        
        EquipementVendre ev = new EquipementVendre(12,nom,prix,Description,"IMAGE",quantite,idF);
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        try{
            if(TFIdEquipV.getText().matches("^[0-9]+$")&&TFNomEquipV.getText().matches("^[a-zA-Z]+$")&&TFPrixEquipV.getText().matches("^[0-9]+$")&&TADescriptionEquipV.getText().matches("^[a-z A-Z 0-9]+$")&&TFImageEquipV.getText().matches("^[a-z A-Z]+$")&&TFQuantiteEquipV.getText().matches("^[0-9]+$") && TFIdFEquipV.getText().matches("^[0-9]+$"))
            {
                evc.modifierEquipementVendre(id,ev);
                afficherEquipementV();
                afficherChiffreAffaire();
                JOptionPane.showMessageDialog(null, "L'equipement à ete modifier avec succes");
                TFIdEquipV.setText("");
                TFNomEquipV.setText("");
                TFPrixEquipV.setText("");
                TADescriptionEquipV.setText("");
                TFImageEquipV.setText("");        
                TFQuantiteEquipV.setText("");
                TFIdFEquipV.setText("");
            }else{
                JOptionPane.showMessageDialog(null,"verifier les donnees");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    @FXML
    private void supprimerEquipementV(javafx.event.ActionEvent event) {
        int id = Integer.parseInt(TFIdEquipV.getText());
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        evc.supprimerEquipementVendre(id);
        afficherEquipementV();
        afficherChiffreAffaire();
        JOptionPane.showMessageDialog(null,"l'equipement a été supprimer avec succes");
        TFIdEquipV.setText("");
        TFNomEquipV.setText("");
        TFPrixEquipV.setText("");
        TADescriptionEquipV.setText("");
        TFImageEquipV.setText("");        
        TFQuantiteEquipV.setText("");
        TFIdFEquipV.setText("");
        
    }
    
    @FXML
    private void selectionner(MouseEvent event) {
        int index =TVEquipV.getSelectionModel().getSelectedIndex();
        if(index <= -1){
         return ;
         }
        TFIdEquipV.setText(colIdEquipV.getCellData(index).toString());
        TFNomEquipV.setText(colNomEquipV.getCellData(index));
        TFPrixEquipV.setText(colPrixEquipV.getCellData(index).toString());
        TADescriptionEquipV.setText(colDescriptionEquipV.getCellData(index));
        TFImageEquipV.setText(colImageEquipV.getCellData(index));
        TFQuantiteEquipV.setText(colQuantiteEquipV.getCellData(index).toString());
        TFIdFEquipV.setText(colIdFEquipV.getCellData(index).toString());
    
    }

    private void afficherChiffreAffaire() {
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        ObservableList<EquipementVendre> listEqV = evc.calculChiffreAffaire();
        colNomEquipV1.setCellValueFactory(new PropertyValueFactory<EquipementVendre,String>("nomEquipement"));
        colPrixTotalEquipV.setCellValueFactory(new PropertyValueFactory<EquipementVendre,Float>("prixEquipement"));
        

        TVPrixEquipV.setItems(listEqV);
    }

    public void searchProduit(){
        EquipementVendreCRUD evc = new EquipementVendreCRUD();

        ObservableList<EquipementVendre> listEqV = evc.listerEquipementVendre();
         try{
        
          TVEquipV.setItems(listEqV);
          FilteredList<EquipementVendre> filtredData = new FilteredList<>(listEqV, b -> true);
          TFRechercheEquipV.textProperty().addListener((observable, olValue, newValue)->{
             filtredData.setPredicate(person-> {
                 if(newValue == null|| newValue.isEmpty()){
                     return true;
                 }
                 String lowerCaseFilter= newValue.toLowerCase();
                
                 if(person.getNomEquipement().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                     return true;
                 }
                 else if(String.valueOf(person.getIdEquipement()).indexOf(lowerCaseFilter)!=-1)
                     return true;
                     else
                     return false;
                 });
             });
         SortedList<EquipementVendre> sortedData = new SortedList<EquipementVendre>(filtredData);
         sortedData.comparatorProperty().bind(TVEquipV.comparatorProperty());
         TVEquipV.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }          
          
          
     }
    
}
