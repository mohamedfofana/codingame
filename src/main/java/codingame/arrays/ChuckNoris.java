package main.java.codingame.arrays;

import java.util.Scanner;

public class ChuckNoris {
//	Résoudre ce puzzle vous fait convertir des caractères en leur valeur 
//	numérique ainsi que convertir des chiffres en valeurs binaires.
//	Il vous faut aussi parcourir une liste de bit d'une valeur numérique.
//	Ressources externes MasquageDécalage de bitsTable ASCII
//	ÉNONCÉ
//	Votre programme doit transformer une chaîne de caractères en une série de zéros.
//	Une chaîne de caractères a aussi une forme chiffrée et vous devez transformer cette forme dans un autre format.
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        char[] cArray = MESSAGE.toCharArray();
        StringBuilder answer = new StringBuilder();
        StringBuilder binaryString = new StringBuilder();
        
        for (char stringChar : cArray) {
            binaryString.append((String) String.format("%7s", Integer.toBinaryString((int) stringChar)).replace(' ', '0'));
        }
        String groups[] = binaryString.toString().split("(?<=1)(?=0)|(?<=0)(?=1)");
        int counter = 0;
        for (String group : groups) {
          //System.err.println(group);
          if (group.contains("0")) {
              answer.append("00 ");
          }
          else {
            answer.append("0 ");
          }
          for (int i = 0; i < group.length(); i++) {
                answer.append("0");  
          }
          if (counter < groups.length - 1) {
            answer.append(" ");
            counter++;
          } 
          
        }

        System.out.println(answer.toString());
    }
}
