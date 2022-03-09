/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import com.sun.org.glassfish.gmbal.Description;
import edu.SprintJava2.entities.EquipementLouer;
import edu.SprintJava2.entities.EquipementVendre;
import edu.SprintJava2.services.EquipementLouerCRUD;
import edu.SprintJava2.services.EquipementVendreCRUD;
import edu.SprintJava2.utlis.MyConnection;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import static java.awt.SystemColor.text;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLEditorKit;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLEquipementVendreController implements Initializable {

    @FXML
    private GridPane gridEquipV;
    @FXML
    private ImageView IVEquipV;
    @FXML
    private Label labelNomEquipV;
    @FXML
    private Label labelDescriptionEquipV;
    @FXML
    private Label labelPrixEquipV;
    @FXML
    private javafx.scene.control.TextField TFQuantite;
    @FXML
    private javafx.scene.control.TextField TFIdClient;
    @FXML
    private Label labelIdEquipV;
    @FXML
    private javafx.scene.control.TextField TFRechercher;
    @FXML
    private Rating ratingEquipV;
    @FXML
    private ImageView imgCapture;

    MediaPlayer mediaPlayer;
    private final int MAX_COLUMNS = 5;
    @FXML
    private Button btnQuitter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherEquipV();
    }

    private void afficherEquipV() {
        int row = 0;
        int column = 0;
        List<EquipementVendre> list = new ArrayList();
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        list = evc.listerEquipementVendre();
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipV1.fxml"));
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);
                vbox.setId("Equipement_" + i);
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
    private void selectionner(MouseEvent event) throws SQLException {
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
            
            ratingEquipV.setRating(((Rating) targetItem.getChildren().get(9)).getRating());
            labelNomEquipV.setText(((Label) targetItem.getChildren().get(2)).getText());
            labelDescriptionEquipV.setText(((Label) targetItem.getChildren().get(4)).getText());
            labelPrixEquipV.setText(((Label) targetItem.getChildren().get(6)).getText());
            labelIdEquipV.setText(((Label) targetItem.getChildren().get(10)).getText());
            //TFIdEquipV.setText( ((Label)targetItem.getChildren().get(9)).getText());
            //IVEquipV.setImage(getClass().getResourceAsStream((targetItem.getChildren().get(0)).getText()));   
            String img = imageAfficher(Integer.parseInt(((Label) targetItem.getChildren().get(10)).getText()));
            javafx.scene.image.Image image =new javafx.scene.image.Image(img);
            IVEquipV.setImage(image);
        }
    }
     private String imageAfficher(int id) throws SQLException{
         String img="";
         String requete = "SELECT imageEquipement FROM equipementvendre where idEquipement="+id;
            Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                img=rs.getString("imageEquipement");
            }
         return img;
     }
     
    @FXML
    private void acheter(javafx.event.ActionEvent event) {
        try {
            String requete1 = "INSERT INTO vendre(idEquipement,idClient,prixEquipement) VALUES(?,?,?)";
            PreparedStatement pst1 = MyConnection.getInstance().getCnx().prepareStatement(requete1);
            pst1.setInt(1, Integer.parseInt(labelIdEquipV.getText()));
            pst1.setInt(2, Integer.parseInt(TFIdClient.getText()));
            pst1.setInt(3, Integer.parseInt(labelPrixEquipV.getText()) * Integer.parseInt(TFQuantite.getText()));
            pst1.executeUpdate();

            String requete2 = "SELECT quantiteEquipement from equipementvendre where idEquipement=" + Integer.parseInt(labelIdEquipV.getText());
            Statement st2 = MyConnection.getInstance().getCnx().prepareStatement(requete2);
            ResultSet rs = st2.executeQuery(requete2);
            while (rs.next()) {
                String quantite = rs.getString(1);
                String requete3 = "UPDATE equipementvendre SET quantiteEquipement=?  WHERE idEquipement =" + Integer.parseInt(labelIdEquipV.getText());
                PreparedStatement pst3 = MyConnection.getInstance().getCnx().prepareStatement(requete3);
                int p = Integer.parseInt(quantite);
                int o =Integer.parseInt(TFQuantite.getText());
                int k = p-o;
                pst3.setInt(1, k);
                pst3.executeUpdate();

                System.out.println("Element Ajouté!");

                gridEquipV.getChildren().clear();
                afficherEquipV();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void rechercher(javafx.event.ActionEvent event) {
        int row = 0;
        int column = 0;
        List<EquipementVendre> list = new ArrayList();
        gridEquipV.getChildren().clear();
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        list = evc.rechercher(TFRechercher.getText());
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipV1.fxml"));
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);
                vbox.setId("Equipement_" + i);
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
    private void rating(javafx.event.ActionEvent event) throws SQLException {

        Double f = ratingEquipV.getRating();
        System.out.println(f);
        String requete2 = "SELECT rating from equipementvendre where idEquipement=" + Integer.parseInt(labelIdEquipV.getText());
        PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete2);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Double F = rs.getDouble(1);
            System.out.println(F);
            String requete = "UPDATE equipementvendre SET rating=? WHERE idEquipement =" + Integer.parseInt(labelIdEquipV.getText());
            PreparedStatement pst1 = MyConnection.getInstance().getCnx().prepareStatement(requete);
            Double K = (F + f) / 2;
            pst1.setDouble(1, K);
            pst1.executeUpdate();
            System.out.println("equipement modifier");
            
            gridEquipV.getChildren().clear();
            afficherEquipV();
        }
    }

    @FXML
    private void capture(javafx.event.ActionEvent event) throws AWTException {
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(0, 0, 600, 400);
        BufferedImage image = robot.createScreenCapture(rectangle);
        try {
            ImageIO.write(image, "jpg", new File("capture.jpg"));
            Desktop.getDesktop().open(new File("capture.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLEquipementVendreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //imagecapTrans.setImage(nyImage);
        
//        Image myImage = SwingFXUtils.toFXImage(image, null);
//        imgCapture.setImage(myImage);
    }

     
 

    @FXML
    private void trierNom(javafx.event.ActionEvent event) {
        int row = 0;
        int column = 0;
        List<EquipementVendre> list = new ArrayList();
        gridEquipV.getChildren().clear();
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        list = evc.TriNom();
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipV1.fxml"));
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);
                vbox.setId("Equipement_" + i);
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
    private void trierPrix(javafx.event.ActionEvent event) {
        int row = 0;
        int column = 0;
        List<EquipementVendre> list = new ArrayList();
        gridEquipV.getChildren().clear();
        EquipementVendreCRUD evc = new EquipementVendreCRUD();
        list = evc.TriPrix();
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader itemFxmlLoader = new FXMLLoader(getClass().getResource("FXMLEquipV1.fxml"));
                VBox vbox = itemFxmlLoader.load();
                System.err.println("Loading vBOX with id " + i);
                vbox.setId("Equipement_" + i);
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
    private void quitter(javafx.event.ActionEvent event) {
        try{
            btnQuitter.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("FXMLMenuEquipementClient.fxml"));
                Stage mainStage = new Stage();
                Scene scene= new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
