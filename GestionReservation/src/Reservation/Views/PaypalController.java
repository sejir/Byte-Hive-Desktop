/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation.Views;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Sejir
 */
public class PaypalController implements Initializable {

    @FXML
    private WebView idWebView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WebEngine webEngine = idWebView.getEngine();
        File f = new File(getClass().getClassLoader().getResource("html//checkout.html").getFile());
        webEngine.load(f.toURI().toString());
       
        webEngine.reload();
        webEngine.loadContent(" <h1>Check Out</h1>\n" +
"    <br/>\n" +
"    <form action=\"authorize_payment\" method=\"post\">\n" +
"    <table>\n" +
"        <tr>\n" +
"            <td>Product/Service:</td>\n" +
"            <td><input type=\"text\" name=\"product\" value=\"Next iPhone\" /></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Sub Total:</td>\n" +
"            <td><input type=\"text\" name=\"subtotal\" value=\"100\" /></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Shipping:</td>\n" +
"            <td><input type=\"text\" name=\"shipping\" value=\"10\" /></td>\n" +
"        </tr>    \n" +
"        <tr>\n" +
"            <td>Tax:</td>\n" +
"            <td><input type=\"text\" name=\"tax\" value=\"10\" /></td>\n" +
"        </tr>    \n" +
"        <tr>\n" +
"            <td>Total Amount:</td>\n" +
"            <td><input type=\"text\" name=\"total\" value=\"120\" /></td>\n" +
"        </tr>\n" +
"    </table>\n" +
"    </form>");

    }    

    @FXML
    private void checkout(ActionEvent event) {
          WebEngine webEngine = idWebView.getEngine();
             webEngine.reload();
        webEngine.loadContent(" <h1>Please Review Before Paying</h1>\n" +
"    <form action=\"execute_payment\" method=\"post\">\n" +
"    <table>\n" +
"        <tr>\n" +
"            <td colspan=\"2\"><b>Transaction Details:</b></td>\n" +
"            <td>\n" +
"                <input type=\"hidden\" name=\"paymentId\" value=\"${param.paymentId}\" />\n" +
"                <input type=\"hidden\" name=\"PayerID\" value=\"${param.PayerID}\" />\n" +
"            </td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Description:</td>\n" +
"            <td>${transaction.description}</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Subtotal:</td>\n" +
"            <td>200 USD</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Shipping:</td>\n" +
"            <td>12 USD</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Tax:</td>\n" +
"            <td>2.6 USD</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Total:</td>\n" +
"            <td>112.6 USD</td>\n" +
"        </tr>\n" +
"        <tr><td><br/></td></tr>\n" +
"        <tr>\n" +
"            <td colspan=\"2\"><b>Payer Information:</b></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>First Name:</td>\n" +
"            <td>Sejir</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Last Name:</td>\n" +
"            <td>Bali</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Email:</td>\n" +
"            <td>sejirbali</td>\n" +
"        </tr>\n" +
"        <tr><td><br/></td></tr>\n" +
"        <tr>\n" +
"            <td colspan=\"2\"><b>Shipping Address:</b></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Recipient Name:</td>\n" +
"            <td>bali</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Line 1:</td>\n" +
"            <td>l'aouina</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>City:</td>\n" +
"            <td>Tunis</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>State:</td>\n" +
"            <td>Tunis</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Country Code:</td>\n" +
"            <td>Tunisia</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Postal Code:</td>\n" +
"            <td>2045</td>\n" +
"        </tr>\n" +
"    </table>\n" +
"    </form>");}

    @FXML
    private void PAY(ActionEvent event) {
         WebEngine webEngine = idWebView.getEngine();
             webEngine.reload();
        webEngine.loadContent(" <h1>Payment Done. Thank you for purchasing our products</h1>\n" +
"    <br/>\n" +
"    <h2>Receipt Details:</h2>\n" +
"    <table>\n" +
"        <tr>\n" +
"            <td><b>Merchant:</b></td>\n" +
"            <td>Company ABC Ltd.</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td><b>Payer:</b></td>\n" +
"            <td>Sejir Bali</td>      \n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td><b>Description:</b></td>\n" +
"            <td>activité camping</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td><b>Subtotal:</b></td>\n" +
"            <td>200 TND</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td><b>Shipping:</b></td>\n" +
"            <td>10 TND</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td><b>Tax:</b></td>\n" +
"            <td>2.6 TND</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td><b>Total:</b></td>\n" +
"            <td>112.6 TND</td>\n" +
"        </tr>                    \n" +
"    </table>");
    }
    
}
