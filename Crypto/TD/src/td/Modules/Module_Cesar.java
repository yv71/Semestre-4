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
 * @author lk365606
 */
public class Module_Cesar implements Module{
    private String message;

    public Module_Cesar(String _message) {
        this.message = _message;
    }
    
    @Override
    public void Start(){
        ArrayList<String> cle = new ArrayList();
        cle.add("60");
        Message msg = new Message(message);
        Algorithme algo = new Algo_Cesar();
        Utilisateur alice = new Utilisateur(algo);
        Utilisateur bobb = new Utilisateur(algo);
        alice.setMessageClair(msg);
        alice.setClePublique(cle);
        alice.crypterAvecClePublique();
        System.out.println(alice.getMessageCrypte());
        alice.decrypterAvecClePublique();
        System.out.println(alice.getMessageCrypte());
    }
}
