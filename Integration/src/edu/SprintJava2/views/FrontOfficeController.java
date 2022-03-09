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
import edu.SprintJava2.entities.upcomingevents;
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
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FrontOfficeController implements Initializable {

    private TableView<upcomingevents> tevenement;
    @FXML
    private TableColumn<upcomingevents, String> tname;
    @FXML
    private TableColumn<upcomingevents, String> tlocation;
    @FXML
    private TableColumn<upcomingevents, Date> tdate;
    @FXML
    private TableColumn<upcomingevents, String> tguide;
    @FXML
    private TextField tsearch;
    @FXML
    private ImageView QRCode;
    @FXML
    private Button pdf;
    @FXML
    private Button QRCoe;
    @FXML
    private TableView<upcomingevents> tvevenement;
    ObservableList <upcomingevents> List = FXCollections.observableArrayList();
    @FXML
    private Button afficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event= new ActionEvent();
        tname.setCellValueFactory(new PropertyValueFactory<>("event_name"));
            tlocation.setCellValueFactory(new PropertyValueFactory<>("location"));
            tdate.setCellValueFactory(new PropertyValueFactory<>("date_camping"));
            tguide.setCellValueFactory(new PropertyValueFactory<>("Guide"));
             search();
    } 
    
    
  /*  public void afficherevenemtn (){
  try {
            Connection cnx =MyConnection.getInstance().getCnx();
            String query = "select * from upcomingevents";
            ResultSet rs = cnx.createStatement().executeQuery(query);
            
            while (rs.next()) {
                List.add(new upcomingevents ( rs.getString(" event_name"), rs.getString(" location"), rs.getDate(" date_caming"), rs.getString(" guide"), rs.getInt(" event_number") ));
                
            } 
            
          //  upcomingeventCRUD uc = new upcomingeventCRUD();
            
          //  ObservableList <upcomingevents> list = uc.listerupcomingevents();
            tname.setCellValueFactory(new PropertyValueFactory<>("event_name"));
            tlocation.setCellValueFactory(new PropertyValueFactory<>("location"));
            tdate.setCellValueFactory(new PropertyValueFactory<>("date_camping"));
            tguide.setCellValueFactory(new PropertyValueFactory<>("Guide"));
            
            tvevenement.setItems(List);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FrontOfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   */
    
    @FXML
    private void KeyReleased(KeyEvent event) {
    }

    @FXML
    private void imprimerpdf(ActionEvent event) {
             try { 
                 
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\chayma\\Documents\\evenement.pdf"));
                doc.open();
                 Paragraph p =new Paragraph();
                p.add("liste d'evenement");
             doc.add(p);
                 PdfPTable t = new PdfPTable(4);
            PdfPCell c = new PdfPCell(new Phrase("event_name"));
            t.addCell(c);
             c = new PdfPCell(new Phrase("location"));
            t.addCell(c);
              c = new PdfPCell(new Phrase("date_camping"));
            t.addCell(c);
              c = new PdfPCell(new Phrase("guide"));
            t.addCell(c);
            doc.add(t);
               
            
              Connection cnx =MyConnection.getInstance().getCnx();
            String query = "select * from upcomingevents";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(4);
               while(rs.next()){ 
           
                 
            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("event_name")));
            table.addCell(c1);
                 
             c1 = new PdfPCell(new Phrase(rs.getString("location")));
            table.addCell(c1);
                 
             c1 = new PdfPCell(new Phrase(rs.getString("date_camping")));
            table.addCell(c1);
             c1 = new PdfPCell(new Phrase(rs.getString("guide")));
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
                Desktop.getDesktop().open(new File("C:\\Users\\chayma\\Documents\\evenement.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
    }
    
 public void start(upcomingevents u) {
        
        QRCodeWriter QRCodeWriter;
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = u.getEvent_name();
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
    private void QR(ActionEvent event) {
          upcomingevents u = tvevenement.getSelectionModel().getSelectedItem();
        if (u == null) {
            //veuillez selectionner une liiiiiiiiiiiiiiiigne
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur !");
            alert1.setHeaderText(null);
            alert1.setContentText("veuillez selectionner une ligne du tableau puis appuyez sur le bouton recuperer");
            alert1.show();

        } else {
        
        start(u);
    }
    }
        

    

   /* @FXML
    private void selectrow(MouseEvent event) {
        
    }*/

    @FXML
    private void afficher(ActionEvent event) {
          upcomingeventCRUD up = new upcomingeventCRUD();
        List<upcomingevents> liste = up.listerupcomingevents();
        ObservableList<upcomingevents> olist = FXCollections.observableArrayList(liste);
        
        tvevenement.setItems(olist);
        search();
    }
     public void search(){
        upcomingeventCRUD evc = new upcomingeventCRUD();
          
        ObservableList<upcomingevents> listEqV = evc.listerupcomingevents();
         try{
        
          tvevenement.setItems(listEqV);
          FilteredList<upcomingevents> filtredData = new FilteredList<>(listEqV, b -> true);
          tsearch.textProperty().addListener((observable, olValue, newValue)->{
             filtredData.setPredicate(upcomingevents-> {
                 if(newValue == null|| newValue.isEmpty()){
                     return true;
                 }
                 String lowerCaseFilter= newValue.toLowerCase();
                
                 if(upcomingevents.getEvent_name().toLowerCase().contains(lowerCaseFilter)){
                     return true;
                 }
                 else if(String.valueOf(upcomingevents.getEvent_number).contains(lowerCaseFilter))
                     return true;
                     else
                     return false;
                 });
             });
         SortedList<upcomingevents> sortedData = new SortedList<>(filtredData);
         sortedData.comparatorProperty().bind(tvevenement.comparatorProperty());
         tvevenement.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }  
     }

    @FXML
    private void retourner(ActionEvent event) {
        NewFXMain.setScene("Interface_User");
    }



    
}