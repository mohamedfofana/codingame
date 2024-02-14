package main.java.codingame.arrays;

public class ClosestToZero {
	//	�nonc�
	//	Implement closestToZero to return the integer in the array ints that is closest to zero.
	//	If there are two integers equally close to zero, consider the positive element to be closer to zero (example: if ints contains -5 and 5,
	//	return 5).
	//	If ints is null or empty, return 0.
	//	Input: integers in ints have values ranging from -2147483647 to 2147483647.
	
	// Pas efficace � 100% � r�adapter au cas ou le premier int est n�gatif et existe en double		
		static int closestToZeroOK1(int[] ints) {
			if(ints == null || ints.length== 0){
				return 0;
			}
			int plusProche = ints[0];
			for (int i=1; i<ints.length; i++) {
				int aNumber = ints[i];
				if (Math.abs(aNumber) < Math.abs(plusProche)){
					plusProche = aNumber;
				}else if (aNumber == 0){
					return 0;
				}else if (Math.abs(aNumber) == Math.abs(plusProche)) {
					if (aNumber > plusProche)
						plusProche = aNumber;
				}
			}
			return plusProche;
		}
	
	// Doit Marcher
	static int closestToZeroOK2(int[] ints) {
		if(ints == null || ints.length== 0){
			return 0;
		}
		int plusProche = ints[0];
		for (int i=1; i<ints.length; i++) {
			int aNumber = ints[i];
			if (aNumber == 0){
				return 0;
			} else if (aNumber > 0 ){
				if (plusProche > 0) {
					if (plusProche > aNumber)
						plusProche = aNumber;
				}else {
					if (Math.abs(plusProche) > aNumber || Math.abs(plusProche) == aNumber)
						plusProche = aNumber;
				}
			}
			else {
				if (plusProche > 0) {
					if (plusProche > Math.abs(aNumber) )
						plusProche = aNumber;
				}else {
					if (Math.abs(plusProche) > Math.abs(aNumber))
						plusProche = aNumber;
				}
			}
		}
		return plusProche;
	}
	// Si tu trouve la solution je suis preneur 
	// tu peux faire plus de test
	public static void main(String[] args) {
		int[] ints = new int[]{2,-7, 125,-10,65,7,10,15,-2};
		System.out.println(closestToZeroOK1(ints));
		System.out.println(closestToZeroOK2(ints));
		ints = new int[]{-2,-7, 125,-10,65,7,10,15,2};
		System.out.println(closestToZeroOK1(ints));
		System.out.println(closestToZeroOK2(ints));
		ints = new int[]{2,-7, 125,1,65,7,10,15,-2};
		System.out.println(closestToZeroOK1(ints));
		System.out.println(closestToZeroOK2(ints));
		ints = new int[]{2,-7, 125,1,0,7,10,15,-2};
		System.out.println(closestToZeroOK1(ints));
		System.out.println(closestToZeroOK2(ints));
	}

}
