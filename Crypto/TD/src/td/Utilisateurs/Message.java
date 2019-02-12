/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Utilisateurs;

/**
 *
 * @author lk365606
 */
public class Message {
    private String message;

    public Message() {
        this.message = "";
    }

    public Message(String _message) {
        this.message = _message;
    }

    @Override
    public String toString() {
        return "Le message est : " + message + '.';
    }
    
    public int taille()
    {
        return message.length();
    }
    
    public void affichageAscii()
    {
        for(int i = 0; i < message.length(); i++)
        {
            System.out.print(getCharAscii(i)+" ");
        }
        System.out.println("");
    }
    
    public int getCharAscii(int i)
    {
        return message.charAt(i);
    }
    
    public void addCharAscii(int codeAscii)
    {
        this.message += (char) codeAscii;
    }
    
    public String getCharBinary(int i){
        String rez = "";
        String test = Integer.toBinaryString(this.getCharAscii(i));
        if(test.length() < 8){
            int nbZ = 8 - test.length();
            for (int j=0; j < nbZ; j ++){
                rez += "0";
            }
        }
        rez += test;        
        return rez;
    }
    
    public String toBinaryString(){
        String rez = "";
        for (int i = 0; i < this.taille(); i ++){
            rez += this.getCharBinary(i)+ " ";
        }
        return rez;
    }
    
}
