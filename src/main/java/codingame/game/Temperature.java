package main.java.codingame.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Temperature {

//ConditionsBouclesTableaux
//Résoudre ce puzzle valide que le concept de boucle est compris et que vous pouvez comparer une liste de valeurs.
//Ce puzzle est aussi un terrain de jeu pour tester le concept des lambdas dans différents langages de programmation. C'est également une occasion de découvrir la programmation fonctionnelle.
//
//Ressources externes ConditionsBouclesValeur absolue(EN) Let's Play Temperatures
//ÉNONCÉ
//Votre programme doit analyser des relevés de température pour trouver la plus proche de zéro.
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String TEMPS = in.nextLine(); // the N temperatures expressed as integers ranging from -273 to 5526

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        int result = 0;
        if (TEMPS.isEmpty()) {
            System.out.println(result);
        } 
        else { 
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> originaList = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                list.add(Math.abs(Integer.valueOf(TEMPS.split(" ")[i])));
                originaList.add(Integer.valueOf(TEMPS.split(" ")[i]));
            }
            if (originaList.size() == 1) {
                result = originaList.get(0);
            } 
            else {
                Collections.sort(list);
                result =  list.get(N-1);
                for (int i = 0; i < list.size(); i++) {
                    int tmp = originaList.get(i);
                    System.err.println(result);
                    if (Math.abs(tmp) <= Math.abs(result)) {
                        result = tmp;
                    }
                }
                if (Math.signum(result) == -1.0 && originaList.contains(Math.abs(result))) {
                    result = Math.abs(result);
                    System.err.println(result);
                } 
            }
            System.out.println(result);
        }
    }
}
