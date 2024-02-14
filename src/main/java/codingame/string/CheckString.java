package main.java.codingame.string;

import java.util.Stack;

public class CheckString {
//	if the string A is correct, (A) and [A] are correct
//	if the string A and B are correct, the concatenation AB is also correct
//	Input: The string contains at most 10 000 characters.
//	Examples: [()] is correct, (()[]) is correct, ([)] is not correct, (( is not correct.
//	Implement the method check(String str) to check the correctness of a string of this type. check returns true if the string is correct,
//	false otherwise.
 	static boolean check(String str) {
  		if (str == null || str.isEmpty()){
  		 return true;
  		}
  		if (str.startsWith(")") || str.startsWith("]") || str.endsWith("(") || str.endsWith("[")){
  			return false;
  		}
  		int pOpen = 0;
  		int cOpen = 0;
  		Stack<String> dejaLu = new Stack<String>();
 
  		for (int i = 0; i < str.length(); i++) {
  			String c1 = Character.toString(str.charAt(i));
  			if (c1.equals("(")){
  				pOpen ++;
  				dejaLu.push(c1);
  			}
  			else if (c1.equals(")")){
  				if (pOpen == 0){
  					return false;
  				}else{
  					pOpen--;
  					if (dejaLu.peek().equals("(")){
  						dejaLu.pop();
  					}else{
  						return false;
  					}
  				}
  			}
  			else if (c1.equals("[")){
  				cOpen++;
  				dejaLu.push(c1);
  			}
  			else if (c1.equals("]")){
  				if (cOpen == 0){
  					return false;
  				}else{
  					cOpen--;
  					if (dejaLu.peek().equals("[")){
  						dejaLu.pop();
  					}else{
  						return false;
  					}
  				}
  			}
  		}
  		if (cOpen > 0 || pOpen>0){
  			return false;
  		}
 
  		return true;
  	}
 	
// 	R�sultat
// 	L'algorithme fonctionne avec un jeu de donn�es simple : Succ�s
// 	Une chaine vide retourne true : Succ�s
// 	Fonctionne dans les temps et sans d�bordement de pile avec une longue cha�ne : Succ�s
// 	Fonctionne toujours si plus de fermeture que d'ouverture (pile vide) : Succ�s
// 	'null' retourne true : Succ�s
// 	Lisibilit� du code : 0%

}
