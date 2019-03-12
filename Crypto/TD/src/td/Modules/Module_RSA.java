/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Modules;

import java.util.ArrayList;
import td.Algo.Algo_RSA;
import td.Algo.Algorithme;
import td.Utilisateurs.Message;

/**
 *
 * @author yv066840
 */
public class Module_RSA implements Module{

    @Override
    public void Start() {
        Algorithme s = new Algo_RSA();
        Message _message = new Message("Coucou");
        ArrayList<String> clePublique = s.genererClePublique();
        ArrayList<String> clePrivee = s.genererClePrivee();
        Message crypt = s.crypter(_message, clePublique);
        Message aled = s.decrypter(crypt, clePrivee);
        System.out.println(_message);
        System.out.println(crypt);
        System.out.println(aled);
    }
    
}
