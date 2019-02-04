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
public interface Algorithme {
    public ArrayList<String> genererClePublique();
    public ArrayList<String> genererClePrivee();
    public Message crypter(Message _message, ArrayList<String> cle);
    public Message decrypter(Message _message, ArrayList<String> cle);
}
