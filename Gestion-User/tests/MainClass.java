/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava1.tests;

import edu.SprintJava1.entities.Admin;
import edu.SprintJava1.entities.Client;
import edu.SprintJava1.entities.Host;
import edu.SprintJava1.services.AdminCRUD;
import edu.SprintJava1.services.ClientCRUD;
import edu.SprintJava1.services.HostCRUD;
import edu.SprintJava1.utils.ControleDeSaisie;
import edu.SprintJava1.utils.MyConnection;
import java.util.Scanner;

/**
 *
 * @author chayma
 */
public class MainClass {

    public static void main(String[] args) {
        ControleDeSaisie cs = new ControleDeSaisie();
        //MyConnection mc = new MyConnection();

        Client d = new Client ("amira","hasni",1,22,"aaa","23-05-1998");
        ClientCRUD ccd = new ClientCRUD(); 
        //ccd.ajouterClient(d);
        System.out.println(ccd.listerClients());
        //ccd.supprimerClient(d);
        //ccd.modifierClient("pp", "mehrzi", 1, 0, "bbb", "23-05-1998");
        //Host p = new Host (1,"Ahmed","Ajili","Monastir","disponible"); 
        //Host p2 = new Host (3,"Mariem","Hammami","Tunis","nondisponible");
        //HostCRUD hcc = new HostCRUD();
        /*System.out.println("donner votre email : ");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        System.out.println("Donner mdp");
        String password = sc.nextLine();
        if (cs.validateEmail(email) && password.length() > 6) {
            System.out.println("valid credintals");
        } else {
            System.out.println("invalid arguments");
        }*/
        /*Admin ff = new Admin(1,"mehrez","chaabouni",022,"akerz");
      Admin ff1 = new Admin(22,"amir","absaii",0552,"amir70@gmail.com");
      Admin ff2 = new Admin(23,"hanen","Moualhi",2323,"hanenmoualhi@outoolk.com");
      Admin ff3 = new Admin(24,"mouhamed","Msehli",5050,"cc");
      AdminCRUD acc = new AdminCRUD(); */
        //acc.rechercherAdmin(23);
        //acc.ajouterAdmin(ff);
        //acc.ajouterAdmin(ff1);
        //acc.ajouterAdmin(ff2);
        //acc.ajouterAdmin(ff3);
        //System.out.println(acc.listerAdmins());
        //acc.modifierAdmin(1,"mehrez","chaabouni",022,"mehrez@gmail.com");
        //acc.supprimerAdmin(ff);

        //ppc.ajouterProvider(pp);
        //ppc.ajouterProvider(pp1);
        //hcc.ajouterHost(p2);
        //hcc.ajouterHost(p);
        //System.out.println(hcc.listerHosts());
        //hcc.modifierHost(1, "Ahmed", "Ajili", "Medenine", "disponible");
        //hcc.supprimerHost(p2);
    }

}
