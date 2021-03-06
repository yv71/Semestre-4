/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Algo;

import java.util.ArrayList;
import java.math.*;
import java.util.Random;
import td.Utilisateurs.Message;

/**
 *
 * @author yv066840
 */
public class Algo_RSA implements Algorithme{
    private int P;
    private int Q;
    
    private int puissance_modulo(int a, int b, int n)
    {            
        int rez;
        for(rez = 1; b > 0; b = b/2){
            if( b % 2 != 0){
                rez = (rez * a) % n;
            }
            a = (a * a) % n;
        }
        return rez;        
    }
    
    
    @Override
    public ArrayList<String> genererClePublique() {
        ArrayList<String> rez = new ArrayList();
        P =this.premier();
        Q = this.premier();
        int N = P*Q;
        boolean test = true;
        int e = 0;
        int phi = (P-1)*(Q-1);
        while(test){
            e = this.premier();
            if(this.pgcd(e,phi) == 1){
                test = false;
            }
        }
        rez.add(String.valueOf(N));
        rez.add(String.valueOf(e));
        return rez;
    }
    
    @Override
    public ArrayList<String> genererClePrivee() {
        ArrayList<String> rez = new ArrayList();
        ArrayList<String> trucs = this.genererClePublique();
        int phi = (P-1)*(Q-1);
        rez.add(String.valueOf(this.inverse_modulo(Integer.parseInt(trucs.get(1)), phi)));
        return rez;
    }
    private int premier(){
        int rez;
        Random r = new Random();
        int nb = 0;
        nb = r.nextInt((int) Math.pow(2,10))+(int) Math.pow(2,10);        
        if(nb%2 == 0){
            nb = nb+1;
        }
        boolean ok = false;
        while(!ok){
            if (this.millerRabin(nb, 30)){
                ok = true;
            }
            else{
                nb +=2;
            }
        }        
        return nb;
    }

    @Override
    public Message crypter(Message _message, ArrayList<String> cle) {
        Message m = new Message();
        int chara;
        
        for(int i =0; i<_message.taille();i++)
        {
            chara =(int) _message.getCharAscii(i);
            int e = Integer.parseInt(cle.get(1));
            int n = Integer.parseInt(cle.get(0));
            m.addCharAscii(this.puissance_modulo(chara, e, n));
        }
        return m;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        Message rez = new Message();
        int chara;
        String chaine = "";
        for(int i =0; i<_message.taille();i++)
        {
            chaine += (char) _message.getCharAscii(i);
            rez.a
            /*int d = Integer.parseInt(cle.get(0));
            int n = P * Q;
            rez.addCharAscii(this.puissance_modulo(chara, d, n));*/
        }
        System.out.println(chaine);
        return rez;
    }
    
    
    private boolean temoin(int a, int n){
        boolean rez = false;
        int s;
        int d;
        if ((n-1)%2 != 0){
            d = n-1;
            s = 0;
        }
        else {
            s = calculerS(n);
            d = (n-1)/(int)(Math.pow(2, s));
        }
        
        int x = this.puissance_modulo(a, d, n);
        if (x == 1 ||x == (n-1)){
            return false;
        }
        while (s> 1){
            x = this.puissance_modulo(x, 2, n);
            if (x==(n-1)){
                return false;
            }
            s --;
        }
        return true;
    }
    
    private boolean millerRabin(int n, int k)
    {
        int a;
        Random m = new Random();
        for (int i=0; i <k; i++)
        {
            a = m.nextInt(n-4)+2;
            if(this.temoin(a, n))
            {
                return false;
            }
        }
        
        return true;
    }
    
    int pgcd (int a , int b) { 
        int t;
        if ( b>a) { 
                t = a; 
                a = b; 
                b = t; 
         } 
        int r;
        do { 
                r = a % b; 
                a = b; 
                b = r; 
        } while(r !=0); 
       return a ; 
      }
    
    private int calculerS(int n){
        int s = 0;
        int temp =n-1;
        boolean fini = false;
        while(!fini)
        {   
            if(temp%2 !=0)
            {
                fini = true;
            }
            else{
                s++;
            }
            temp = temp/2;
        }
        return s;
    }
    
    private int inverse_modulo(int i, int n){
        int r = i;
        int r2 = n;
        int u = 1;
        int v = 0;
        int u2 =0;
        int v2 = 1;
        int q, rs, us, vs;
        while(r2 !=0)
        {
            q = r/r2;
            rs = r;
            us = u;
            vs = v;
            r = r2;
            u = u2;
            v = v2;
            r2 = rs - q*r2;
            u2 = us - q*u2;
            v2 = vs - q*v2;
        }
        while(u <0)
        {
            u+=n;
        }
        return u;
    }
}
