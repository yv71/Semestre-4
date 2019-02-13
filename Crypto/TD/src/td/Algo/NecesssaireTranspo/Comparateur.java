/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.Algo.NecesssaireTranspo;

import java.util.Comparator;

/**
 *
 * @author yv066840
 */
public class Comparateur implements Comparator<Pair>{


    @Override
    public int compare(Pair o1, Pair o2) {
        int rez= 1;
        if (o1.getCarac() < o2.getCarac() || (o1.getCarac() == o2.getCarac() && o1.getNb() < o2.getNb())){
            rez = -1;
        }
        return rez;
    }
    
}
