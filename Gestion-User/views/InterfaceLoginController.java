/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.Users;
import edu.SprintJava2.services.UsersCRUD;
import edu.SprintJava2.services.UsersSession;
import edu.SprintJava2.services.SendMail;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class InterfaceLoginController implements Initializable {
   private static String profilePicture="";
   private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
     private static final String regex2 = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";

   @FXML
    private TextField TFname;
    @FXML
    private TextField TFlastname;
    @FXML
    private TextField TFemail;
    @FXML
    private PasswordField TFpassword;
    @FXML
    private ImageView sigupimage;
    private String cImageUrl = "";
    @FXML
    private PasswordField TFpassword2;
    @FXML
    private TextField TFemail2;
    @FXML
    private CheckBox cbox;
    @FXML
    private ComboBox<String> combobox1;
    ObservableList<String> list = FXCollections.observableArrayList("Provider","Host","Camper");
    ValidationSupport validationSupport = new ValidationSupport();
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      combobox1.setItems(list);
      // validationSupport.registerValidator(TFname,Validator.createEmptyValidator("name is required"));
       // validationSupport.registerValidator(TFlastname,Validator.createEmptyValidator("lastname is required"));

    }    

    @FXML
    private void ajouteruser(ActionEvent event) throws Exception {
      Pattern pattern = Pattern.compile(regex);
      Pattern pattern2 = Pattern.compile(regex2);
       UsersCRUD cc = new UsersCRUD(); 
        Matcher matcher = pattern.matcher(TFemail.getText());
        Matcher matcher1 = pattern.matcher(TFemail.getText());
        if (cImageUrl.equals("")) {
           JOptionPane.showMessageDialog(null,"select a picture");
        }else if (TFname.getText().length() < 3) {
           JOptionPane.showMessageDialog(null,"enter a valid name");
        } else if (TFlastname.getText().length() < 3) {
           JOptionPane.showMessageDialog(null,"enter your lastname ");
        } else if (!matcher.matches()) {
           JOptionPane.showMessageDialog(null,"enter a valid email format");
        } else if (TFpassword.getText().length() < 6 && (!matcher1.matches()))
        {
JOptionPane.showMessageDialog(null,"enter a strong password that mus contains uppercase char and symbol and numbers");
        } else if (!cc.validateEmail(TFemail.getText())) {
            JOptionPane.showMessageDialog(null,"This mail is already used");
        } else {
        JOptionPane.showMessageDialog(null,"Please wait we are creating your account");
        Users u = new Users();
        u.setName(TFname.getText());
        u.setLastname(TFlastname.getText());
        u.setEmail(TFemail.getText());
        u.setPassword(TFpassword.getText());
        u.setRole(combobox1.getValue());
        u.setProfilePicture(cImageUrl);
        if(cc.ajouteruser(u))
        { 
           //JOptionPane.showMessageDialog(null,"Your Account has been successfully created!");
           // NewFXMain.setScene("Userprofile");   
            System.out.println("User added");
            SendMail.send(TFemail.getText());
             Notifications notificationBuilder = Notifications.create()
                     .title("Message").text(" Your Account has been successfully created !").graphic(null).hideAfter(javafx.util.Duration.seconds(4))
                     .position(Pos.CENTER)
                     .onAction(new EventHandler<ActionEvent>(){
                         public void handle(ActionEvent event){
                             System.out.println("clicked On");
                         }});
             notificationBuilder.darkStyle();
             notificationBuilder.show();
                     
            TFname.setText("");
            TFlastname.setText("");
            TFemail.setText("");
            TFpassword.setText("");
            combobox1.setValue("");
            cImageUrl="";
           
            
            
        }
        else {
            System.out.println("User was not added");
        }
        }
    }
    

    @FXML
    private void validate(ActionEvent event) throws Exception{
        Users u = new Users(); 
        UsersCRUD cc = new UsersCRUD(); 
       String access = (combobox1.getItems().toString());

        
        boolean result = UsersCRUD.Login(TFemail2.getText(), TFpassword2.getText());
        if((UsersSession.getRole().equals("Admin")) && (true==result))
        {
         NewFXMain.setScene("InterfaceAdmin");    
        } else if ((UsersSession.getRole().equals("Camper")) && (true==result)) {
            
           NewFXMain.setScene("Interface_Camper");
        } else if ((UsersSession.getRole().equals("Provider")) && (true==result)) {
           NewFXMain.setScene("Interface_Provider");        
        } else if ((UsersSession.getRole().equals("Host")) && (true==result)) {
           NewFXMain.setScene("Interface_Host"); 
        } 
        
    }
       
    

    @FXML
    private void uploadsiguppic(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        fileChooser.setInitialDirectory(new File("C:\\Users\\chayma\\Documents\\NetBeansProjects\\SprintJava2\\src\\edu\\SprintJava2\\images"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            String TempprofilePicture = file.toURI().toString();
            System.out.println(TempprofilePicture);
            profilePicture= file.getName();
            System.out.println(profilePicture);
            Image image = new Image(TempprofilePicture);
            sigupimage.setImage(image);
            cImageUrl = TempprofilePicture;
        }
    }

    @FXML
    private void checkbox(ActionEvent event) {
        if (cbox.isSelected()){
            TFpassword2.setPromptText(TFpassword2.getText());
            TFpassword2.setText("");
            TFpassword2.setDisable(true);
        }else {
            TFpassword2.setText(TFpassword2.getPromptText());
            TFpassword2.setPromptText("");
            TFpassword2.setDisable(false);
        }
    }

    @FXML
    private void closeapplication(MouseEvent event) {
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setTitle("You are going to close the application");
       alert.setHeaderText("Are you sure you want to close the application?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }else {
            alert.close();
        }
    }
    
}
