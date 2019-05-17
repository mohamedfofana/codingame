package main.java.codingame;

import java.util.*;
import java.math.*;

// ne pas modifier Monnaie
class Monnaie {
    long piece2 = 0;
    long billet5 = 0;
    long billet10 = 0;
}

class Solution {
    
    // ne pas modifier la signature de cette​​​​​​​‌‌‌‌‌​‌​‌​​‌​‌‌‌‌‌‌‌​​‌​ méthode
    static Monnaie monnaieOptimale(long s) {
        Monnaie m = new Monnaie();
        m.billet10 = s/10;
        long rest = s%10;
        if(rest<5){
            m.piece2 = rest;
            return m;
        }
        m.billet5 = rest/5;
        rest = rest % 5;
        if (rest%2==0)
            m.piece2 = rest;
        else 
            return null;
        return m;
        
    }
}
