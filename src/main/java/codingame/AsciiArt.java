package main.java.codingame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AsciiArt {
//	BouclesTableauxChaînes De Caractères
//	Résoudre ce puzzle vous apprend à gérer les chaînes de caractères et les calculs dans un tableau.
//	Il vous faut couper des chaînes de caractères en plusieurs morceaux et les concaténer en d'autres. Vous pouvez aussi utiliser les index de tableau
//	Ressources externes BouclesChaînes de caractères(EN) Let's Play ASCII Art
//	ÉNONCÉ
//	Votre programme doit afficher une ligne de texte en art ASCII.
//	Vous devez séparer des chaînes de caractères, les enregistrer et en recréer d'autres. Vous pouvez utiliser une structure de donnée (comme un tableau) ou une structure de donnée associative (comme une table de hachage ou dictionnaire).
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        List<String> ascii = new ArrayList<String>();
        int group = 0;
        
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            int beginIndex = 0;
            int endIndex = L - 1;
             group = ROW.length() / L;
            for (int j = 0; j < group; j++) {
               //System.err.println("Tour: " + j + " group: " + group + " beginIndex: " + beginIndex + " endIndex: " + endIndex);
               ascii.add(ROW.substring(beginIndex, endIndex+1));
               beginIndex = endIndex + 1;
               endIndex = beginIndex + (L - 1);
               //System.err.println(ascii.get(j).length());
            }
        }
        
        char[] cArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?".toCharArray();
        List<Character> letters = new ArrayList<Character>();
        for(char c : cArray) {
            letters.add(c);
        }
        T = T.toUpperCase();
        char[] ch = T.toCharArray();
        List<Integer> indexes = new ArrayList<Integer>();
        for (char c : ch) {
            if (!letters.contains(c)) {
                indexes.add(26);
                //Solution.printSolution(26, H, ascii, group);
            }
            else {
                indexes.add(letters.indexOf(c));
               
            }
        }
        AsciiArt.printSolution(indexes, H, ascii, group);
    }
    
    private static void printSolution(List<Integer> indexes, int charHigth, List<String> ascii, int group) {
        List<Integer> pointers = indexes;
        int pointer = 0;
        for (int i = 0; i < charHigth; i++) {
            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < pointers.size(); j++) {
                int index = pointers.get(j);
                index += pointer;
                answer.append(ascii.get(index));
            }
            pointer = pointer + group;
            System.out.println(answer.toString()); 
        }
    }
}
