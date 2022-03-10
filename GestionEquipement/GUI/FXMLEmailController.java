/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import javax.mail.Session;
import static javax.mail.Transport.send;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sun.security.util.Password;


/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLEmailController implements Initializable {

    @FXML
    private TextArea TAMail;
    @FXML
    private TextField TFAdresse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Envoyer(ActionEvent event) throws Exception {
        sendMail(TFAdresse.getText());
        TFAdresse.setText("");
        TAMail.setText("");
    }
    
    public  void sendMail(String reception) throws MessagingException, Exception{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail= "behija.benghorbel@esprit.tn";
        String password = "191JFT3232";
        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(myAccountEmail, password);//To change body of generated methods, choose Tools | Templates.
            }
            
            
        });
        javax.mail.Message message = prepareMessage(session,myAccountEmail,"");
        Transport:send(message);
        
        
   }
    private  javax.mail.Message prepareMessage(Session session,String myAccountEmail,String recepient) throws Exception{
        javax.mail.Message message = (javax.mail.Message) new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(javax.mail.Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Hello");
            message.setText(TAMail.getText());
            return message;
        } catch (AddressException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        
    }
    
}
