/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.services;

//import com.mysql.cj.Session;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author chayma
 */
public class SendMail {
    public static void send(String recepient) throws Exception{
        System.out.println("Preparing to send email");
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
         properties.put("mail.smtp.port","587");
         String myAccountEmail = "nature.cruiseteam@gmail.com";
         String password="Cmest1920";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password); //To change body of generated methods, choose Tools | Templates.
            }
        
    });
       Message message = prepareMessage(session,myAccountEmail,recepient); 
       Transport.send(message);
       System.out.println("Message sent sucessfully");
    }
    private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            //message.setContent("<h1> Email from nature cruise team!</h1>","text/html");
            message.setSubject("Account Created Sucessfully ! ");
            message.setText("Dear user , Welcome to our platform nature cruise created by byte-hive your account has been successuflly created ! , You can send u an email if you want to seek any other informations about our application  ");
            
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
