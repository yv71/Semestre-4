/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Modules;

import java.util.ArrayList;
import java.util.Random;
import td.Algo.Algo_MasqueJetable;
import td.Utilisateurs.Message;

/**
 *
 * @author yv066840
 */
public class Module_MasqueBinaire implements Module{

    @Override
    public void Start() {
        String superCle = "";
        Message m = new Message("BONJOURCOMMENTCAVA");
        Random r = new Random();
        for (int i = 0; i < (m.taille()*8);  i ++){
            superCle += r.nextInt(2);
        }
        Algo_MasqueJetable test = new Algo_MasqueJetable();
        ArrayList<String> cc = new ArrayList();
        cc.add(superCle);
        Message vroum = test.crypter(m, cc);
        System.out.println(vroum);
        System.out.println(test.decrypter(vroum, cc));
    }
    
}
