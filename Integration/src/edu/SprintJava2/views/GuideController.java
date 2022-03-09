/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.SprintJava2.entities.Guide;
import edu.SprintJava2.entities.upcomingevents;
import edu.SprintJava2.services.GuideCRUD;
import edu.SprintJava2.services.upcomingeventCRUD;
import edu.SprintJava2.utlis.MyConnection;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GuideController implements Initializable {

    @FXML
    private TextField gfnom;
    @FXML
    private TextField gfprenom;
    @FXML
    private Button BtnVa;
    @FXML
    private TextField gflieux;
    @FXML
    private DatePicker gfdispo;
    @FXML
    private TableView<Guide> tguide;
    @FXML
    private TableColumn<Guide,String> gnom;
    @FXML
    private TableColumn<Guide,String> gprenom;
    @FXML
    private TableColumn<Guide,String> glieux;
    @FXML
    private TableColumn<Guide,Date> gdispo;
    @FXML
    private Button btnmodif;
    @FXML
    private Button btnsupp;
    @FXML
    private Button fpdf;
    @FXML
    private ImageView QRCode;
    @FXML
    private Button qr;
    @FXML
    private TextField tsearch;
    ObservableList<upcomingevents> dataList;
    FilteredList<upcomingevents> filtredData;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherguide();
        search();
        // TODO
    }    

    @FXML
    private void ajouterguide(ActionEvent event) {
         String nom = gfnom.getText();
    String prenom = gfprenom.getText();
    String lieux = gflieux.getText();
         java.sql.Date getDatePickerDate = java.sql.Date.valueOf(gfdispo.getValue());

    
    
    if(gfnom.getText().length()<2){
        JOptionPane.showMessageDialog(null, "enter a valid name");
    }else if (gfprenom.getText().length()<2){
        JOptionPane.showConfirmDialog(null, "enter a valid location");
 
    }else if (gflieux.getText().length()<2){
        JOptionPane.showInputDialog(null, "not exist");
    }
      

   
        Guide g = new Guide(nom, prenom, getDatePickerDate, lieux, 0);
        GuideCRUD ge = new GuideCRUD();
                ge.ajouterPersonne(g);
         afficherguide();
         search();
    }
         public void afficherguide (){
     GuideCRUD ge = new GuideCRUD();
     
        ObservableList <Guide> List = ge.listerGuide();
        gnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        gprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        glieux.setCellValueFactory(new PropertyValueFactory<>("lieux"));
        gdispo.setCellValueFactory(new PropertyValueFactory<>("disponoibilte"));
         
            tguide.setItems(List);
            search();
    }
    @FXML
    private void selectrow(MouseEvent event) {
              Guide g  =  tguide.getSelectionModel().getSelectedItem();
        System.out.println("id"+g.getId());
        
         gfnom.setText(g.nom);
        gfprenom.setText(g.prenom);
        gflieux.setText(g.lieux);
         java.sql.Date getDatePickerDate = java.sql.Date.valueOf(gfdispo.getValue());
    }

    @FXML
    private void modifierguide(ActionEvent event) {
  GuideCRUD ge =new GuideCRUD();
        Guide g  =tguide.getSelectionModel().getSelectedItem();
        int selectedID = tguide.getSelectionModel().getSelectedIndex();
        String nom = gfnom.getText();
        String prenom = gfprenom.getText();
        String lieux = gflieux.getText();
         java.sql.Date getDatePickerDate = java.sql.Date.valueOf(gfdispo.getValue());
                 Guide gu = new Guide(nom, prenom, getDatePickerDate, lieux, selectedID);
         Guide gui = new Guide(nom, prenom, getDatePickerDate, lieux, selectedID);

           Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove");
        alert.setHeaderText("You Want to Remove Guide ?");
    
        if (alert.showAndWait().get() == ButtonType.OK ) {
         ge.UpdateGuide(gu, g.getId());

            System.out.println("GestionCamping.gui.GuideController.supprimguide()");
        }

         afficherguide();
         search();
    }

    @FXML
    private void supprimguide(ActionEvent event) {
        GuideCRUD ge = new GuideCRUD();
         Guide g = tguide.getSelectionModel().getSelectedItem(); 
         int selectedID = tguide.getSelectionModel().getSelectedIndex();
        afficherguide();
        Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove");
        alert.setHeaderText("You Want to Remove Guide ?");
    
        if (alert.showAndWait().get() == ButtonType.OK ) {
                     ge.SupprimerGuide(g);

            System.out.println("GestionCamping.gui.GuideController.supprimguide()");
        }
        search();
        afficherguide();
    }

    @FXML
    private void impdf(ActionEvent event) {
         try { 
                 
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\chayma\\Documents\\guide.pdf"));
                doc.open();
                 Paragraph p =new Paragraph();
                p.add("liste des Guides");
             doc.add(p);
                 PdfPTable t = new PdfPTable(4);
            PdfPCell c = new PdfPCell(new Phrase("nom"));
            t.addCell(c);
             c = new PdfPCell(new Phrase("prenom"));
            t.addCell(c);
              c = new PdfPCell(new Phrase("lieux"));
            t.addCell(c);
              c = new PdfPCell(new Phrase("disponoibilte"));
            t.addCell(c);
            doc.add(t);
               
            
              Connection cnx =MyConnection.getInstance().getCnx();
            String query = "select * from guide";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(4);
               while(rs.next()){ 
           
                 
            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("nom")));
            table.addCell(c1);
                 
             c1 = new PdfPCell(new Phrase(rs.getString("prenom")));
            table.addCell(c1);
                 
             c1 = new PdfPCell(new Phrase(rs.getString("lieux")));
            table.addCell(c1);
             c1 = new PdfPCell(new Phrase(rs.getString("disponoibilte")));
            table.addCell(c1);
             
               }
               
         // table.setHeaderRows(1);
//         ObservableList<Produit> list = (ObservableList<Produit>) ps.afficherProduit();
 //  colids.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("id"));
//      colprix.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("prix"));
//      colquan.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantite"));
//      date_exp.setCellValueFactory(new PropertyValueFactory<Produit,Date>("date_exp"));
//      coltype.setCellValueFactory(new PropertyValueFactory<Produit,String>("type"));
//     
//        tab_s.setItems(list);
       
//        table.addCell("");
//   table.addCell("1.1");
//             table.addCell("1.2");
//               table.addCell("2.1");
//                table.addCell("2.2");
//                 table.addCell("2.3");
                doc.add(table);
                
                doc.close();
                Desktop.getDesktop().open(new File("C:\\Users\\chayma\\Documents\\guide.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
    }
      public void start(Guide u) {
        
        QRCodeWriter QRCodeWriter;
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = u.getNom();
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }


System.out.println("Success...");
            
        } catch (WriterException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
                
        QRCode.setImage(qrView.getImage());
        
        //StackPane root = new StackPane();
        /*root.getChildren().add(qrView);
        
        Scene scene = new Scene(root, 350, 350);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }
    @FXML
    private void qrrr(ActionEvent event) {
          Guide g = tguide.getSelectionModel().getSelectedItem();
        if (g == null) {
            //veuillez selectionner une liiiiiiiiiiiiiiiigne
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur !");
            alert1.setHeaderText(null);
            alert1.setContentText("veuillez selectionner une ligne du tableau puis appuyez sur le bouton recuperer");
            alert1.show();

        } else {
        
        start(g);
    }
    

    }

   
     public void search(){
        GuideCRUD ue = new GuideCRUD();

         ObservableList <Guide> l = ue.listerGuide();        
         try{
        
          tguide.setItems(l);
          FilteredList<Guide> f = new FilteredList<>(l, b -> true);
          tsearch.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
             f.setPredicate(new Predicate<Guide>() {
                 public boolean test(Guide person) {
                     if(newValue == null|| newValue.isEmpty()){
                         return true;
                     }
                     String lowerCaseFilter= newValue.toLowerCase();
                     
                     if(person.getNom().toLowerCase().contains(lowerCaseFilter)){
                         return true;
                     }
                     else if(String.valueOf(person.getId()).indexOf(lowerCaseFilter)!=-1)
                         return true;
                     else
                         return false;
                 }

              
             });
             });
         SortedList<Guide> sortedData = new SortedList<>(f);
         sortedData.comparatorProperty().bind(tguide.comparatorProperty());
         tguide.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }  
     }

    @FXML
    private void retourner(ActionEvent event) {
         NewFXMain.setScene("InterfaceAdmin");
    }

    }


    

