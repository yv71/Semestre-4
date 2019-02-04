/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Algo;

import java.util.ArrayList;
import td.Utilisateurs.Message;

/**
 *
 * @author lk365606
 */
public class Algo_Cesar implements Algorithme{
    private ArrayList<String> cle;

    public Algo_Cesar() {
        
    }

    @Override
    public ArrayList<String> genererClePublique() {
        return cle;
    }

    @Override
    public ArrayList<String> genererClePrivee() {
        return cle;
    }

    @Override
    public Message crypter(Message _message, ArrayList<String> cle) {
        Message res = new Message();
        int decalage = Integer.valueOf(cle.get(0));
        for(int i =0; i< _message.taille(); i++)
        {
            int x = _message.getCharAscii(i) ;
            x -= 33;
            x +=decalage;
            x = x%(127-32) +1;
            x +=32;
            res.addCharAscii(x);
        }
        return res;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        Message res = new Message();
        int decalage = Integer.valueOf(cle.get(0));
        for(int i =0; i< _message.taille(); i++)
        {
            int x = _message.getCharAscii(i);
            x -= 33;
            x -=decalage;
            if(x < 0){
                x += (127 -32);
            }
            x = x%(127-32)+1;
            x +=32;
            
            res.addCharAscii(x);
        }
        return res;
    }
    
   
}
