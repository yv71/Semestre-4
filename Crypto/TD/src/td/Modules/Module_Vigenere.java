/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Modules;

import java.util.ArrayList;
import td.Algo.*;
import td.Utilisateurs.*;

/**
 *
 * @author yv066840
 */
public class Module_Vigenere implements Module{

    private String message;

    public Module_Vigenere(String _message) {
        this.message = _message.replaceAll("\\s+","").toUpperCase();
    }
    
    @Override
    public void Start() {
        ArrayList<String> cle = new ArrayList();
        cle.add("CLE");
        Message msg = new Message(message);
        Algorithme algo = new Algo_Vigenere();
        Utilisateur alice = new Utilisateur(algo);
        Utilisateur bobb = new Utilisateur(algo);
        alice.setMessageClair(msg);
        alice.setClePublique(cle);
        bobb.setClePublique(cle);
        alice.crypterAvecClePublique();
        System.out.println(alice.getMessageCrypte());
        bobb.setMessageCrypte(alice.getMessageCrypte());
        bobb.decrypterAvecClePublique();
        System.out.println(bobb.getMessageCrypte());
    }
}

