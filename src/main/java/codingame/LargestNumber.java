package main.java.codingame;

public class LargestNumber {
	//	Énoncé
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
//	Résultat
//	Fonctionne dans des cas simples : Succès
//	Fonctionne quand le tableau contient seulement Integer.MIN_VALUE : Succès
//	Fonctionne quand le plus grand élément est à la position 0 : Succès
//	Fonctionne quand le plus grand élément est à la fin du tableau : Succès
//	Lisibilité du code : 100%

	
	public static void main(String[] args) {
		
	}

}
