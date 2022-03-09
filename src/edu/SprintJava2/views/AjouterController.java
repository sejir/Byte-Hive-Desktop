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
import static com.sun.corba.se.impl.logging.ActivationSystemException.get;
import static com.sun.corba.se.impl.logging.IORSystemException.get;
import static com.sun.javafx.applet.ExperimentalExtensions.get;
import static com.sun.xml.internal.bind.v2.runtime.reflect.TransducedAccessor.get;
//import edu.SprintJava2.entities.Guide;
import edu.SprintJava2.entities.upcomingevents;
import edu.SprintJava2.services.upcomingeventCRUD;
import edu.SprintJava2.utlis.MyConnection;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ChoiceBox.ON_SHOWN;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.get;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import static sun.swing.DefaultLookup.get;
import sun.util.calendar.BaseCalendar.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javax.tools.DocumentationTool.Location;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterController implements Initializable {

   
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfLocalisation;
    @FXML
    private Button BtnValider;
    @FXML
    private DatePicker tfDate;
    @FXML
    private TextField tfGuide;
    @FXML
    private TableView<upcomingevents> tevenement;
    @FXML
    private TableColumn<upcomingevents,String> tname;
    @FXML
    private TableColumn<upcomingevents,String> tlocation;
    @FXML
    private TableColumn<upcomingevents,Date> tdate;
    @FXML
    private TableColumn<upcomingevents,String> tguide;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnsupprimer;
    private TextField tsearch;

    @FXML
    private Button pdf;
    @FXML
    private ImageView QRCode;
    @FXML
    private Button QRCoe;
   
    @FXML
    private TextField tfid;
    ObservableList<upcomingevents> dataList;
    FilteredList<upcomingevents> filtredData;
    @FXML
    private TableColumn<upcomingevents, Integer> tfidd;
    private TextField TFRechercheEquipV;
    @FXML
    private TextField Search;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherevenemtn();
         search();
        // TODO
    }   

    @FXML
    private void ajouterevenement(ActionEvent event) {
        
    String event_name = tfNom.getText();
    String location = tfLocalisation.getText();
              java.sql.Date getDatePickerDate = java.sql.Date.valueOf(tfDate.getValue());
        int id_guide = Integer.parseInt(tfid.getText());
    String Guide = tfGuide.getText();
    
    if(tfNom.getText().length()<2){
        JOptionPane.showMessageDialog(null, "enter a valid name");
    }else if (tfLocalisation.getText().length()<2){
        JOptionPane.showConfirmDialog(null, "enter a valid location");
 
    }else if (tfGuide.getText().length()<2){
        JOptionPane.showInputDialog(null, "not exist");
    }
      
else {
        //JOptionPane.showMessageDialog(null,"Please wait we are creating your account");
        upcomingevents u = new upcomingevents();
        u.setEvent_name(tfNom.getText());
        u.setLocation(tfLocalisation.getText());
        u.setGuide(tfGuide.getText());
        u.setDate_camping(getDatePickerDate);
        u.setId_guide(Integer.parseInt(tfid.getText()));

       
   
        upcomingevents ue = new upcomingevents();
        upcomingeventCRUD uep = new upcomingeventCRUD();
        uep.ajouterupcomingevents(u);
         afficherevenemtn();
         search();
    }
    }
    @FXML
    private void modifierevenement(ActionEvent event) {
        upcomingeventCRUD uce =new upcomingeventCRUD();
        upcomingevents u  =tevenement.getSelectionModel().getSelectedItem();
        int selectedID = tevenement.getSelectionModel().getSelectedIndex();
        String event_name = tfNom.getText();
        String Location = tfLocalisation.getText();
         java.sql.Date  date_camping = java.sql.Date.valueOf(tfDate.getValue());

        String Guide = tfGuide.getText();
        int id_guide = Integer.parseInt(tfid.getText());
        u.setId_guide(id_guide);
        upcomingevents ue = new upcomingevents(event_name, Location, date_camping, Guide, id_guide);
           Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove");
        alert.setHeaderText("You Want to Edit this EVENT ?");
    
        if (alert.showAndWait().get() == ButtonType.OK ) {
                uce.Updateupcomingevents(ue, u.getEvent_number());

            System.out.println("GestionCamping.gui.AjouterController.supprimevenement()");
       search();
      
    }
         
         
         afficherevenemtn();
         search();
         
     }


  @FXML
    private void supprimevenement(ActionEvent event) {
        upcomingeventCRUD uce =new upcomingeventCRUD();
         upcomingevents ue  =tevenement.getSelectionModel().getSelectedItem(); 
         int selectedID = tevenement.getSelectionModel().getSelectedIndex();
         //tevenement.getItems().remove(selectedID);
        afficherevenemtn();
        Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove");
        alert.setHeaderText("You Want to Remove this EVENT ?");
    
        if (alert.showAndWait().get() == ButtonType.OK ) {
            uce.SupprimerUpcomingevents(ue);

            System.out.println("GestionCamping.gui.AjouterController.supprimevenement()");
       search();
      
    }
        
    }
 public void afficherevenemtn (){
     upcomingeventCRUD uc = new upcomingeventCRUD();
     
        ObservableList <upcomingevents> List = uc.listerupcomingevents();
        tname.setCellValueFactory(new PropertyValueFactory<>("event_name"));
        tlocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        tdate.setCellValueFactory(new PropertyValueFactory<>("date_camping"));
        tguide.setCellValueFactory(new PropertyValueFactory<>("Guide"));
        tfidd.setCellValueFactory(new PropertyValueFactory<>("id_guide"));
         search();
    

        //System.out.print("test");
        tevenement.setItems(List);
 }

    @FXML
    private void selectrow(MouseEvent event) {
           upcomingevents uc  = tevenement.getSelectionModel().getSelectedItem();
        System.out.println("id"+uc.getEvent_number());
        
        tfNom.setText(uc.event_name);
        tfLocalisation.setText(uc.location);
        java.sql.Date getDatePickerDate = java.sql.Date.valueOf(tfDate.getValue());
        tfGuide.setText(uc.guide);
        String id_g = Integer.toString(uc.getId_guide());
        tfidd.setText(id_g);
        

    }

 /*  public AjouterController() {
       ContextMenu.add(Panel);
   }*/
    private void KeyReleased(KeyEvent event) {
        String search=tsearch.getText().trim();
        if ( search.equals(event)){
            System.out.println(search);
                    
        }
    }
  /*   public void setData(upcomingevents get) {

      
        upcomingevents up = new upcomingevents();
        upcomingeventCRUD u = new upcomingeventCRUD();
       
        
            ByteArrayOutputStream out = QRCode.from("upcomingevents pour [1"+up.getEvent_number()+"]").to(ImageType.PNG).withSize(200, 200).stream();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Image image = new Image(in);
        im.setImage(image);
        }
  
        Image im = new Image(get.getUrl_image());
        image.setImage(im);
    }*/

  
    /*   public void setData(upcomingevents get) {
         dr.setVisible(false);

        staticSession=get;
        
        if(serviceAbonnement.listerupcomingevents().size()>0){
            qr.setVisible(false);
            dr.setVisible(true);
            flag=true;
            ByteArrayOutputStream out = QRCode.from("upcomingevents pour [1"+staticSession.getEvent_number()+"]").to(ImageType.PNG).withSize(200, 200).stream();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Image image = new Image(in);
        dr.setImage(image);
        }
        else{
            qr.setVisible(true);
            dr.setVisible(false);
            flag=true;
        }
        //Image im = new Image(get.getUrl_image());
        //image.setImage(im);
    }*/

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
        upcomingevents l1 = tevenement.getSelectionModel().getSelectedItem();
        if (l1 == null) {
            //veuillez selectionner une liiiiiiiiiiiiiiiigne
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur !");
            alert1.setHeaderText(null);
            alert1.setContentText("veuillez selectionner une ligne du tableau puis appuyez sur le bouton recuperer");
            alert1.show();

        } else {
        
        start(l1);
    }
    

    }
     public void search(){
        upcomingeventCRUD ue = new upcomingeventCRUD();

         ObservableList <upcomingevents> l = ue.listerupcomingevents();        
         try{
        
          tevenement.setItems(l);
          FilteredList<upcomingevents> filtred = new FilteredList<>(l, b -> true);
          Search.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
             filtred.setPredicate(new Predicate<upcomingevents>() {
                 @Override
                 public boolean test(upcomingevents person) {
                     if(newValue == null|| newValue.isEmpty()){
                         return true;
                     }
                     String lowerCaseFilter= newValue.toLowerCase();
                     
                     if(person.getEvent_name().toLowerCase().contains(lowerCaseFilter)){
                         return true;
                     }
                     else if(String.valueOf(person.getEvent_number).indexOf(lowerCaseFilter)!=-1)
                         return true;
                     else
                         return false;
                 }
             });
             });
         SortedList<upcomingevents> sortedData = new SortedList<>(filtred);
         sortedData.comparatorProperty().bind(tevenement.comparatorProperty());
         tevenement.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }  
     }

    @FXML
    private void retourner(ActionEvent event) {
         NewFXMain.setScene("InterfaceAdmin");
    }


    }
    
