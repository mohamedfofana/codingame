package main.java.codingame;

public class LargestNumber {
	//	�nonc�
	//	Algorithm.findLargest(int[] numbers) should return the largest number from numbers. The array numbers always contains at least
	//	one number.
	//	Implement Algorithm.findLargest(int[] numbers).

	static int findLargest(int[] numbers) {
		int max = numbers[0];
		for (int i=1; i<numbers.length; i++){
			if (max<numbers[i]){
				max=numbers[i];
			}
		}
		
		return max;
	}
//	R�sultat
//	Fonctionne dans des cas simples : Succ�s
//	Fonctionne quand le tableau contient seulement Integer.MIN_VALUE : Succ�s
//	Fonctionne quand le plus grand �l�ment est � la position 0 : Succ�s
//	Fonctionne quand le plus grand �l�ment est � la fin du tableau : Succ�s
//	Lisibilit� du code : 100%

	
	public static void main(String[] args) {
		
	}

}
