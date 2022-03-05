/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.SprintJava2.entities.Contact;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import edu.SprintJava2.services.ContactCRUD;
import java.util.Date;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class ContactPageController implements Initializable {

    @FXML
    private TextField colname;
    @FXML
    private TextField colemail;
    @FXML
    private TextField coldesc;
    @FXML
    private TextField coldate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyercontact(ActionEvent event) {
     ContactCRUD cc = new ContactCRUD();
     Contact u = new Contact();
      u.setName(colname.getText());
      u.setEmail(colemail.getText());
      u.setDescription(coldesc.getText());
      u.setDate(coldate.getText());
      cc.ajoutecontact(u);
      colname.setText("");
      colemail.setText("");
     coldate.setText("");
     coldesc.setText("");
    }

    @FXML
    private void supprimercontact(ActionEvent event) {
          ContactCRUD cc = new ContactCRUD(); 
           Contact u = new Contact();
           //u.setId();
               
    }
    @FXML
    private void retourner(ActionEvent event) {
    NewFXMain.setScene("InterfaceLogin");
}
    
}
