/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava1.utils;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chayma
 */
public class ControleDeSaisie {
    Connection mc=MyConnection.getInstance().getCnx();
    public String masque;
public boolean validateEmail(String email){
masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
Pattern pattern = Pattern.compile(masque);
Matcher controller = pattern.matcher(email);
return controller.matches();
}

}
