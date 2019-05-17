package main.java;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.math.*;
public class CombinationOptionTournament {
	//	�nonc�
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
//	R�sultat
//	La solution fonctionne avec un jeu de donn�es simple : Succ�s
//	La solution fonctionne avec des donn�es proches de 10000 : Succ�s
//	La solution n'utilise pas excessivement la m�moire (pas de cache) : Succ�s
//	La solution retourne le bon r�sultat en un temps constant : �chec
//	Lisibilit� du code : 100%

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
