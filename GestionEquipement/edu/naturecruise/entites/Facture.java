/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naturecruise.entites;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class Facture {
    
    
    
    
    
     public boolean testString(String nom) {
		//************************ nom et prenom contiennent que des alphabets ***************************
		String masque = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(masque);
		Matcher controler = pattern.matcher(nom);
		return controler.matches();
	}
     
     
     public boolean testInt(String num) {
 		String masque = "^[0-9]+[0-9]$";
 		Pattern pattern = Pattern.compile(masque);
 		Matcher controler = pattern.matcher(num);
 		if (controler.matches()) {
 			return true;
 		}
 	return false;
 	}
     
     
     
}
