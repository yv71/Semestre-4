/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Algo;

import java.util.ArrayList;
import java.util.Random;
import td.Utilisateurs.Message;

/**
 *
 * @author yv066840
 */
public class Algo_MasqueJetable implements Algorithme{

    @Override
    public ArrayList<String> genererClePublique() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> genererClePrivee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message crypter(Message _message, ArrayList<String> cle) {
        Message m = new Message();
        String superCle = cle.get(0);
        String mFinal="";
        for(int i = 0; i < superCle.length(); i ++){
            mFinal += (superCle.charAt(i)^ _message.toBinaryString().charAt(i));
        }
        int pack = 0;
        
        while(pack < _message.taille()*8)
        {
            String carapuce="";
            for(int i =pack; i<=pack+7;i++)
            {
                carapuce+=mFinal.charAt(i);
            }   
            m.addCharBinary(carapuce);
            pack += 8;
        }
        return m;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        return this.crypter(_message, cle);
    }
    
}
