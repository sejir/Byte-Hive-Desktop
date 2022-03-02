/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import edu.SprintJava2.entities.Users;
import edu.SprintJava2.services.UsersCRUD;
import edu.SprintJava2.services.UsersSession;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class InterfaceLoginController implements Initializable {
   private static String profilePicture="";
   @FXML
    private TextField TFname;
    @FXML
    private TextField TFlastname;
    @FXML
    private TextField TFemail;
    @FXML
    private PasswordField TFpassword;
    @FXML
    private TextField TFrole;
    @FXML
    private ImageView sigupimage;
    private String cImageUrl = "";
    @FXML
    private PasswordField TFpassword2;
    @FXML
    private TextField TFemail2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void ajouteruser(ActionEvent event) throws Exception{
       UsersCRUD cc = new UsersCRUD(); 
        Users u = new Users(); 
        u.setName(TFname.getText());
        u.setLastname(TFlastname.getText());
        u.setEmail(TFemail.getText());
        u.setPassword(TFpassword.getText());
        u.setRole(TFrole.getText());
        u.setProfilePicture(cImageUrl);
        
        if(cc.ajouteruser(u))
        {
            boolean result = UsersCRUD.Login(TFemail.getText(), TFpassword.getText());
            if(result==true)
            {
                NewFXMain.setScene("InterfaceAdmin");
            }
        }
        
        
        
    }
  

    @FXML
    private void validate(ActionEvent event) throws Exception{
        
        boolean result = UsersCRUD.Login(TFemail2.getText(), TFpassword2.getText());
        if(result==true)
        {
            NewFXMain.setScene("InterfaceAdmin");
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
    
}
