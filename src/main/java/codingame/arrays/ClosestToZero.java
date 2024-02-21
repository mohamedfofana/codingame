package main.java.codingame.arrays;

import java.util.Arrays;

public class ClosestToZero {
	
	int closestToZero(int[] numbers)
	{
	    if (numbers.length == 0) return 0;
	    
	    var closest = numbers[0];

	    for(var i = 0; i < numbers.length;i++){
	    	var number = numbers[i];
	    	var absNumber =  Math.abs(number);
	    	var absClosest = Math.abs(closest);

	        if (absNumber < absClosest) 
	        {
	            closest = number;
	        } 
	        else if (absNumber == absClosest && closest < 0) 
	        {
	            closest = number;
	        }
	    }

	    return closest;
	}
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

class GFG 
{ 
 // Print the distance with zeroes of every element 
 static void print_distance(int arr[], int n) 
 { 
     // initializes an array of size n with 0 
     int ans[]=new int[n]; 
     Arrays.fill(ans,0); 
   
     // if first element is 0 then the distance 
     // will be 0 
     if (arr[0] == 0) 
         ans[0] = 0; 
       
     // if not 0 then initialize  
     // with a maximum value     
     else
         ans[0] = +2147483647; 
   
     // traverse in loop from 1 to n and store  
     // the distance from left 
     for (int i = 1; i < n; ++i)  
     { 
   
         // add 1 to the distance 
         // from previous one 
         ans[i] = ans[i - 1] + 1; 
   
         // if the present element is  
         // 0 then distance will be 0 
         if (arr[i] == 0)  
             ans[i] = 0;      
     } 
   
     // if last element is zero  
     // then it will be 0 else  
     // let the answer be what was 
     // found when traveled 
     // from left to right 
     if (arr[n - 1] == 0) 
         ans[n - 1] = 0; 
   
     // traverse from right to  
     // left and store the minimum 
     // of distance if found from  
     // right to left or left 
     // to right 
     for (int i = n - 2; i >= 0; --i)  
     { 
   
         // store the minimum of distance  
         // from left to right or right to left 
         ans[i] = Math.min(ans[i], ans[i + 1] + 1); 
   
         // if it is 0 then minimum  
         // will always be 0 
         if (arr[i] == 0)  
             ans[i] = 0; 
     } 
   
     // print the answer array 
     for (int i = 0; i < n; ++i)  
         System.out.print(ans[i] + " ");  
 } 
   
 // Driver code  
 public static void main (String[] args) 
 { 
     int a[] = { 2, 1, 0, 3, 0, 0, 3, 2, 4 }; 
     int n = a.length; 
     print_distance(a, n); 
 } 
} 