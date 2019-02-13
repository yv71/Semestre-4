/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Algo.NecesssaireTranspo;

/**
 *
 * @author yv066840
 */
public class Pair {
    private int nb;
    private char carac;

    public Pair( char carac, int nb) {
        this.nb = nb;
        this.carac = carac;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public char getCarac() {
        return carac;
    }

    public void setCarac(char carac) {
        this.carac = carac;
    }

    @Override
    public String toString() {
        return "Pair{" + "nb=" + nb + ", carac=" + carac + '}';
    }
    
    
    
    
    
}
