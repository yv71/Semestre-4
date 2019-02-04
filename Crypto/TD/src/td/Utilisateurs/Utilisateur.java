/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Utilisateurs;

import java.util.ArrayList;
import td.Algo.Algorithme;

/**
 *
 * @author lk365606
 */
public class Utilisateur {
    private Algorithme algo;
    private Message message_clair;
    private Message message_crypte;
    private ArrayList<String> clePublique;
    private ArrayList<String> clePrivee;

    public Utilisateur(Algorithme algo) {
        this.algo = algo;
    }

    public ArrayList<String> getClePublique() {
        return clePublique;
    }

    public void setClePublique(ArrayList<String> clePublique) {
        this.clePublique = clePublique;
    }

    public ArrayList<String> getClePrivee() {
        return clePrivee;
    }

    public void setClePrivee(ArrayList<String> clePrivee) {
        this.clePrivee = clePrivee;
    }

    public Message getMessageCrypte() {
        return message_crypte;
    }

    public void setMessageCrypte(Message _message) {
        this.message_crypte = _message;
    }

    public void setMessageClair(Message _message) {
        this.message_clair = _message;
    }

    public void afficherMessageClair()
    {
        System.out.println(message_clair);
    }
    
    public void crypterAvecClePublique()
    {
        message_crypte = algo.crypter(message_clair, clePublique);
    }
    
    public void crypterAvecClePrivee()
    {
        message_crypte = algo.crypter(message_clair, clePrivee);
    }
    
    public void decrypterAvecClePublique()
    {
        message_crypte = algo.decrypter(message_crypte, clePublique);
    }
    
    public void decrypterAvecClePrivee()
    {
        message_crypte = algo.decrypter(message_crypte, clePrivee);
    }
}
