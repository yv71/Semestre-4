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
 * @author yv066840
 */
public class Algo_Vigenere implements Algorithme{

    public Algo_Vigenere() {
        this.initTab();
    }
    
    private int[][] tableau;

    private void initTab(){
        tableau = new int[26][26];
        int k;
        for(int i = 0; i< tableau.length; i++)
        {
            k =i;
            for(int j =0; j<tableau.length; j++)
            {
                k = k % 26;
                tableau[i][j] = k+65;
                k++;
            }
        }
    }
    
    @Override
    public ArrayList<String> genererClePublique() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> genererClePrivee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String initCle(Message m, String cle)
    {
        String newCle = cle;
        if(m.taille()>newCle.length())
        {
            int nbFois = m.taille()/newCle.length();
            int reste = m.taille()%newCle.length();
            for(int i=0; i < nbFois; i++)
            {
                newCle += cle;
            }
            for(int i =0; i < reste; i++)
            {
                newCle+=cle.charAt(i);
            }
        }
        return newCle;
    }
    
    @Override
    public Message crypter(Message _message, ArrayList<String> cle) {
        Message crypt = new Message();
        String newCle = this.initCle(_message,cle.get(0));
        for(int i =0; i<_message.taille(); i++)
        {
            int lettreM = _message.getCharAscii(i)-65;
            int lettreC = (int)newCle.charAt(i) - 65;
            crypt.addCharAscii(tableau[lettreM][lettreC]);
        }
        return crypt;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        Message crypt = new Message();
        String newCle = this.initCle(_message,cle.get(0));
        for(int i =0; i<_message.taille(); i++)
        {
            int lettreM = _message.getCharAscii(i);
            int lettreC = (int)newCle.charAt(i) - 65;
            boolean trouve = false;
            int k = 0;
            while(!trouve)
            {
                if(tableau[k][lettreC]==lettreM)
                {
                    trouve = true;
                }
                else{
                    k++;
                }
            }
            crypt.addCharAscii(k+65);
        }
        return crypt;
    }
    
}
