package main.java;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.math.*;
public class CombinationOptionTournament {
	//	Énoncé
	//	You have to organize a chess tournament in which players will compete head-to-head.
	//	Here is how we proceed to form the duels: select a first player randomly, then, select his opponent at random among the remaining
	//	participants. The pair of competitors obtained forms one of the duels of the tournament. We proceed in the same manner to form all
	//	the other pairs.
	//	In this exercise, we would like to know how many pairs it is possible to form knowing that the order of opponents in a pair does not
	//	matter.
	//	For example, with 4 players named A, B, C and D, it is possible to get 6 different pairs : AB, AC, AD, BC, BD, CD
	//	Implement count to return the number of possible pairs. Parameter n corresponds to the number of players.
	//	Try to optimize your solution so that, ideally, the duration of treatment is the same for any n.
	//	Input: 2 <= n <= 10000

//	Il s'agit d'une combinaison 
	static int count(int n) {
		int m = n;
		int nb = 0;
		m--;
		while (m>0){
			nb = nb +m;
			m--;
		}
		return nb;
	}
//	Résultat
//	La solution fonctionne avec un jeu de données simple : Succès
//	La solution fonctionne avec des données proches de 10000 : Succès
//	La solution n'utilise pas excessivement la mémoire (pas de cache) : Succès
//	La solution retourne le bon résultat en un temps constant : Échec
//	Lisibilité du code : 100%

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
