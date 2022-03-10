/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.naturecruise.entites.EquipementLouer;
import edu.naturecruise.entites.EquipementVendre;
import edu.naturecruise.services.EquipementLouerCRUD;
import edu.naturecruise.services.EquipementVendreCRUD;
import edu.naturecruise.utils.MyConnetion;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Rating;


/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLEquipLouerCController implements Initializable {

    @FXML
    private Rating ratinigEquipL;
    @FXML
    private Label labelNomEquipL;
    @FXML
    private Label labelDescriptionEquipL;
    @FXML
    private Label labelPrixEquipL;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private DatePicker dateFin;
    @FXML
    private Label labelIdEquipL;
    @FXML
    private GridPane gridEquipL;
    @FXML
    private TextField TFRecherche;

    private final int MAX_COLUMNS = 5;
    @FXML
    private Button btnQuitter;
    @FXML
    private ImageView IVEquipL;
    @FXML
    private TextField TFIdClient;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherEquipL();
    }

    private void afficherEquipL() {
        int row = 0;
        int column = 0;
        List<EquipementLouer> list = new ArrayList();
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        list = evc.listerEquipementLouer1();
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipementL.fxml"));
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);
                vbox.setId("Equipement_" + i);
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

    @FXML
    private void rating(ActionEvent event) throws SQLException {
        Double f = ratinigEquipL.getRating();
        System.out.println(f);
        String requete2 = "SELECT rating from equipementlouer where idEquipement=" + Integer.parseInt(labelIdEquipL.getText());
        PreparedStatement pst = MyConnetion.getInstance().getCnx().prepareStatement(requete2);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Double F = rs.getDouble(1);
            System.out.println(F);
            String requete = "UPDATE equipementlouer SET rating=? WHERE idEquipement =" + Integer.parseInt(labelIdEquipL.getText());
            PreparedStatement pst1 = MyConnetion.getInstance().getCnx().prepareStatement(requete);
            Double K = (F + f) / 2;
            pst1.setDouble(1, K);
            pst1.executeUpdate();
            System.out.println("equipement modifier");
        }
        gridEquipL.getChildren().clear();
        afficherEquipL();
    }

    @FXML
    private void louer(ActionEvent event) throws SQLException {
       if(dateDebut.getValue().isAfter(dateSaisie()) && dateFin.getValue().isAfter(dateSaisie()) && dateFin.getValue().isAfter((ChronoLocalDate) dateDebut)){
        String requete1 = "INSERT INTO louer(dateEmprunt,dateRemise,idEquipement,idClient) VALUES(?,?,?,?)";
        PreparedStatement pst1 = MyConnetion.getInstance().getCnx().prepareStatement(requete1);
        pst1.setDate(1, java.sql.Date.valueOf(dateDebut.getValue()));
        pst1.setDate(2, java.sql.Date.valueOf(dateFin.getValue()));
        pst1.setInt(3, Integer.parseInt(labelIdEquipL.getText()));
        pst1.setInt(4, Integer.parseInt(TFIdClient.getText()));
        pst1.executeUpdate();

        String requete3 = "UPDATE equipementlouer SET disponibilite=0  WHERE idEquipement =" + Integer.parseInt(labelIdEquipL.getText());
        PreparedStatement pst3 = MyConnetion.getInstance().getCnx().prepareStatement(requete3);
        pst3.executeUpdate();

        System.out.println("Element Ajouté!");
        JOptionPane.showMessageDialog(null, "verifier les donnees");
        gridEquipL.getChildren().clear();
        afficherEquipL();
        TFIdClient.setText("");
        labelDescriptionEquipL.setText("");
        labelNomEquipL.setText("");
        labelPrixEquipL.setText("");
       }else
           JOptionPane.showMessageDialog(null, "verifier les donnees");
        
    }
    
     private LocalDate dateSaisie() throws SQLException{
         Date date = null ;
         String requete = "SELECT sysdate() from dual";
            Statement st= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
               date=rs.getDate(1);
               LocalDate ld =Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                return ld;
            }
        return null;
     }

    @FXML
    private void selectionner(MouseEvent event) throws SQLException {
        ObservableList<Node> children = gridEquipL.getChildren();
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
            VBox targetItem = (VBox) children.get(targetNodePosition);
            
            ratinigEquipL.setRating(((Rating) targetItem.getChildren().get(7)).getRating());
            labelNomEquipL.setText(((Label) targetItem.getChildren().get(2)).getText());
            labelDescriptionEquipL.setText(((Label) targetItem.getChildren().get(4)).getText());
            labelPrixEquipL.setText(((Label) targetItem.getChildren().get(6)).getText());
            labelIdEquipL.setText(((Label) targetItem.getChildren().get(8)).getText());
            //TFImageEquipV.setText( ((Label)targetItem.getChildren().get(0)).getText());  
            String img = imageAfficher(Integer.parseInt(((Label) targetItem.getChildren().get(8)).getText()));
            javafx.scene.image.Image image =new javafx.scene.image.Image(img);
            IVEquipL.setImage(image);
        }
    }
    
    private String imageAfficher(int id) throws SQLException{
         String img="";
         String requete = "SELECT imageEquipement FROM equipementLouer where idEquipement="+id;
            Statement st= MyConnetion.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                img=rs.getString("imageEquipement");
            }
         return img;
     }

    @FXML
    private void rechercher(ActionEvent event) {
        int row = 0;
        int column = 0;
        List<EquipementLouer> list = new ArrayList();
        gridEquipL.getChildren().clear();
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        list = evc.rechercher(TFRecherche.getText());
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipementL.fxml"));
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);
                vbox.setId("Equipement_" + i);
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

    @FXML
    private void quitter(ActionEvent event) {
        try{
            btnQuitter.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("FXMLMenuEquipementClient.fxml"));
                Stage mainStage = new Stage();
                Scene scene= new Scene(root);
                mainStage.setScene(scene);
                 mainStage.setTitle("Equipements à Vendre");
                mainStage.show();
//                JOptionPane.showMessageDialog(null, "Bienvenue dans votre interface Equipements à Vendre");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }

    @FXML
    private void TrierNom(ActionEvent event) {
         int row = 0;
        int column = 0;
        List<EquipementLouer> list = new ArrayList();
        gridEquipL.getChildren().clear();
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        list = evc.trierNom();
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipementL.fxml"));
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);
                vbox.setId("Equipement_" + i);
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

    @FXML
    private void TrierPrix(ActionEvent event) {
        int row = 0;
        int column = 0;
        List<EquipementLouer> list = new ArrayList();
        gridEquipL.getChildren().clear();
        EquipementLouerCRUD evc = new EquipementLouerCRUD();
        list = evc.trierPrix();
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipementL.fxml"));
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);
                vbox.setId("Equipement_" + i);
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

}
