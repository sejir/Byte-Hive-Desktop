/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.naturecruise.entites.EquipementLouer;
import edu.naturecruise.entites.EquipementVendre;
import edu.naturecruise.entites.Louer;
import edu.naturecruise.services.EquipementLouerCRUD;
import edu.naturecruise.services.EquipementVendreCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLEquipementLouerController implements Initializable {

    @FXML
    private TextField TFId;
    @FXML
    private TextField TFIdEquipL;
    @FXML
    private TextField TFNomEquipL;
    @FXML
    private TextArea TADescriptionEquipL;
    @FXML
    private TextField TFPrixEquipL;
    @FXML
    private TextField TFImageEquipL;
    @FXML
    private TextField TFIdFEquipL;
    @FXML
    private TextField TFDisponibiliteEquipL;
    @FXML
    private Button BTNQuitterEquipL;
    private TableView<EquipementLouer> TVEquipV;
    @FXML
    private TableColumn<EquipementLouer, Integer> colIdEquipL;
    @FXML
    private TableColumn<EquipementLouer, String> colNomEquipL;
    @FXML
    private TableColumn<EquipementLouer, Float> colPrixEquipL;
    @FXML
    private TableColumn<EquipementLouer, String> colDescriptionEquipL;
    @FXML
    private TableColumn<EquipementLouer, String> colImageEquipL;
    @FXML
    private TableColumn<EquipementLouer, Integer> colIdFEquipL;
    @FXML
    private TableColumn<EquipementLouer, Integer> colDisponibiliteEquipL;
    @FXML
    private TableView<EquipementLouer> TVEquipL;
    @FXML
    private TableView<EquipementLouer> TVRetardCkient;
    @FXML
    private TableColumn<EquipementLouer, String> colNomClient;
    @FXML
    private TableColumn<EquipementLouer, String> colNomEquipL1;
    @FXML
    private TableColumn<EquipementLouer, Integer> colNbJours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherEquipementL();
    }  

    @FXML
    private void ajouterEquipementL(ActionEvent event) {
        
        String nom = TFNomEquipL.getText();
        float prix = Integer.parseInt(TFPrixEquipL.getText());
        String Description = TADescriptionEquipL.getText();
        String image = TFImageEquipL.getText();
        int idF = Integer.parseInt(TFIdFEquipL.getText());
        int disponibilite = Integer.parseInt(TFDisponibiliteEquipL.getText());
        EquipementLouer el = new EquipementLouer(0,nom,prix,Description,image,idF,disponibilite);
        EquipementLouerCRUD elc = new EquipementLouerCRUD();
        elc.ajouterEquipementLouer(el);
        
        JOptionPane.showMessageDialog(null,"l'equipement a été ajouté avec succes");
        afficherEquipementL();
        
        TFNomEquipL.setText("");
        TFPrixEquipL.setText("");
        TADescriptionEquipL.setText("");
        TFImageEquipL.setText("");
        TFIdFEquipL.setText("");
        TFDisponibiliteEquipL.setText("");
    }

    private void afficherEquipementL() {
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        ObservableList<EquipementLouer> listEqL = evc.listerEquipementLouer();
        colIdEquipL.setCellValueFactory(new PropertyValueFactory<EquipementLouer,Integer>("idEquipement"));
        colNomEquipL.setCellValueFactory(new PropertyValueFactory<EquipementLouer,String>("nomEquipement"));
        colPrixEquipL.setCellValueFactory(new PropertyValueFactory<EquipementLouer,Float>("prixEquipement"));
        colDescriptionEquipL.setCellValueFactory(new PropertyValueFactory<EquipementLouer,String>("descriptionEquipement"));
        colImageEquipL.setCellValueFactory(new PropertyValueFactory<EquipementLouer,String>("imageEquipement"));
        colIdFEquipL.setCellValueFactory(new PropertyValueFactory<EquipementLouer,Integer>("idFournisseur"));
        colDisponibiliteEquipL.setCellValueFactory(new PropertyValueFactory<EquipementLouer,Integer>("disponibilite"));
        TVEquipL.setItems(listEqL);
    }
    
    @FXML
    private void modifierEquipementL(ActionEvent event) {
        int id = Integer.parseInt(TFIdEquipL.getText());
        String nom = TFNomEquipL.getText();
        float prix = Integer.parseInt(TFPrixEquipL.getText());
        String Description = TADescriptionEquipL.getText();
        int idF = Integer.parseInt(TFIdFEquipL.getText());
        int disponibilite = Integer.parseInt(TFDisponibiliteEquipL.getText());
        
        EquipementLouer ev = new EquipementLouer(12,nom,prix,Description,"IMAGE",idF,disponibilite);
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        try{
        
         evc.modifierEquipementLouer(id,ev);
         afficherEquipementL();
        
        JOptionPane.showMessageDialog(null, "L'equipement à ete modifier avec succes");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        TFIdEquipL.setText("");
        TFNomEquipL.setText("");
        TFPrixEquipL.setText("");
        TADescriptionEquipL.setText("");
        TFImageEquipL.setText("");        
        TFIdFEquipL.setText("");
        TFDisponibiliteEquipL.setText("");
    
    
    }

    @FXML
    private void supprimerEquipementL(ActionEvent event) {
        int id = Integer.parseInt(TFIdEquipL.getText());
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        evc.supprimerEquipementLouer(id);
        afficherEquipementL();
        JOptionPane.showMessageDialog(null,"l'equipement a été supprimer avec succes");
        TFIdEquipL.setText("");
        TFNomEquipL.setText("");
        TFPrixEquipL.setText("");
        TADescriptionEquipL.setText("");
        TFImageEquipL.setText("");        
        TFIdFEquipL.setText("");
        TFDisponibiliteEquipL.setText("");
    }

    @FXML
    private void Quitter(ActionEvent event) {
        
    }

    @FXML
    private void selectionner(MouseEvent event) {
        
        int index =TVEquipL.getSelectionModel().getSelectedIndex();
        if(index <= -1){
         return ;
         }
        TFIdEquipL.setText(colIdEquipL.getCellData(index).toString());
        TFNomEquipL.setText(colNomEquipL.getCellData(index));
        TFPrixEquipL.setText(colPrixEquipL.getCellData(index).toString());
        TADescriptionEquipL.setText(colDescriptionEquipL.getCellData(index));
        TFImageEquipL.setText(colImageEquipL.getCellData(index));
        TFIdFEquipL.setText(colIdFEquipL.getCellData(index).toString());
        TFDisponibiliteEquipL.setText(colDisponibiliteEquipL.getCellData(index).toString());

    }
    
    private void afficherClientRetard() {
        EquipementLouerCRUD elc = new EquipementLouerCRUD();
        ObservableList<EquipementLouer> listEqV = elc.duree();
        colNomClient.setCellValueFactory(new PropertyValueFactory<EquipementLouer,String>("c.nomClient"));
        colNomEquipL1.setCellValueFactory(new PropertyValueFactory<EquipementLouer,String>("nomEquipement"));
        

        TVRetardCkient.setItems(listEqV);
    }

    
    
    
}
