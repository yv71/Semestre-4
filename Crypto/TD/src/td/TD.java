/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td;

import java.util.ArrayList;
import td.Algo.*;
import td.Modules.*;
import td.Utilisateurs.*;

/**
 *
 * @author lk365606
 */
public class TD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Module cesar = new Module_Cesar("Bonjour messieurs, comment se passe votre soiree ? B/D/P");
        //cesar.Start();
        Module vigenere = new Module_Vigenere("IUTDIJON");
        vigenere.Start();
        
        Message m = new Message("XXXX");
        System.out.println(m.toBinaryString());
    }
}
