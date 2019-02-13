/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Algo;

import td.Algo.NecesssaireTranspo.Pair;
import java.util.ArrayList;
import java.util.Random;
import td.Algo.NecesssaireTranspo.Comparateur;
import td.Utilisateurs.Message;

/**
 *
 * @author yv066840
 */
public class Algo_Transposition implements Algorithme{
    private ArrayList<String> cle;

    @Override
    public ArrayList<String> genererClePublique() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> genererClePrivee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private char[][] initTab(Message _message, String cle){
        int nbLignes = _message.taille()/cle.length();
        int nbColonnes = cle.length();
        if(_message.taille()%cle.length() != 0){
            nbLignes++;
        }
        char[][] rez = new char[nbLignes][nbColonnes];
        int nb = 0;
        for(int i=0;i<nbLignes;i++){
            for(int j=0;j<nbColonnes;j++){
                if(nb<_message.taille()){
                    rez[i][j]=(char)_message.getCharAscii(nb);
                    nb++;
                }
                else{
                    Random r = new Random();
                    int valeur = 65+r.nextInt(90-65);
                    rez[i][j]=(char) valeur;
                }
            }
        }
        return rez;
    }
    
    private ArrayList<Pair> createPair(String cle){
        Comparateur comp = new Comparateur();
        ArrayList<Pair> rez = new ArrayList();
        for(int i = 0; i < cle.length() ; i++){
           rez.add(new Pair(cle.charAt(i), i + 1));
        }        
        rez.sort(comp);
        System.out.println(rez);
        return rez;
    }
    @Override
    public Message crypter(Message _message, ArrayList<String> cle) {
        Message rez = new Message();
        String motCle = cle.get(0);
        motCle = motCle.toLowerCase().replaceAll("\\s+","");
        char[][] tableauChaine = this.initTab(_message, motCle);
        ArrayList<Pair> aled = this.createPair(motCle);
        int nb = 0;
        for(Pair p :aled){
            int nColonne = p.getNb()-1;
            for(int i = 0; i < tableauChaine.length; i++){
                rez.addCharAscii((int) tableauChaine[i][nColonne]);
                nb++;
                if(nb == 5){
                    rez.addCharAscii((int) ' ');
                }
                nb = nb%5;
            }
        }
        System.out.println(rez);
        return rez;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        Message rez = new Message();
        String motCle = cle.get(0);
        motCle = motCle.toLowerCase().replaceAll("\\s+","");
        
        return rez;
    }
    
    
}
