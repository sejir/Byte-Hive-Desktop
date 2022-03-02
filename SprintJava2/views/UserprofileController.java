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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class UserprofileController implements Initializable {

    @FXML
    private Circle profilepicture;
    @FXML
    private Label namellastnameuser;
    @FXML
    private Button changepicbtn;
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
    private Button modifbtn;
    
    
    private boolean isModifying = false;
    @FXML
    private Button suppbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        profileHome();
    }  
    private void profileHome(){
        Image im = new Image(UsersSession.getProfilepicture());
        ImagePattern pattern = new ImagePattern(im);
        profilepicture.setFill(pattern);
        profilepicture.setStroke(Color.SEAGREEN);
        profilepicture.setEffect(new DropShadow(20, Color.BLACK));
        namellastnameuser.setText("Welcome, "+ UsersSession.getName().toUpperCase()+" "+UsersSession.getlastname().toUpperCase());
        TFname.setText(UsersSession.getName());
        TFlastname.setText(UsersSession.getlastname());
        TFemail.setText(UsersSession.getEmail());
        TFpassword.setText(UsersSession.getPassword());
        TFrole.setText(UsersSession.getRole());
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
            Image image = new Image(TempprofilePicture);
            ImagePattern pattern = new ImagePattern(image);
            UsersSession.setProfilepicture(TempprofilePicture);
            profilepicture.setFill(pattern);
            profilepicture.setStroke(Color.SEAGREEN);
            profilepicture.setEffect(new DropShadow(20, Color.BLACK));
        }
    }

    @FXML
    private void modifClicked(ActionEvent event) {
        if(isModifying)
        {
            TFname.setDisable(true);
            TFlastname.setDisable(true);
            TFemail.setDisable(true);
            TFpassword.setDisable(true);
            TFrole.setDisable(true);
            changepicbtn.setVisible(false);
            UsersSession.setName(TFname.getText());
            UsersSession.setLastname(TFlastname.getText());
            UsersSession.setEmail(TFemail.getText());
            UsersSession.setPassword(TFpassword.getText());
            UsersSession.setRole(TFrole.getText());
            UsersCRUD.modifierUsers(UsersCRUD.cUserId, UsersSession.getName(), UsersSession.getlastname(), UsersSession.getEmail(), UsersSession.getPassword(), UsersSession.getRole(), UsersSession.getProfilepicture());
            modifbtn.setText("Modifier");
            
        }else
        {
            TFname.setDisable(false);
            TFlastname.setDisable(false);
            TFemail.setDisable(false);
            TFpassword.setDisable(false);
            TFrole.setDisable(false);
            changepicbtn.setVisible(true);
            
            
            modifbtn.setText("Sauvegarder");
        }
        isModifying = ! isModifying;
    }

    @FXML
    private void deleteClicked(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to PERMANENTLY delete your account");
        alert.setContentText("Are you sure "+UsersSession.getName()+" ?");
        if (alert.showAndWait().get() == ButtonType.OK ) {
            Users nuser = new Users();
            nuser.setId(UsersCRUD.cUserId);
            UsersCRUD.supprimerUser(nuser);
           // NewFXMain._stage.close();
            NewFXMain.setScene("InterfaceLogin");
               

        }
        
    }
    
}
