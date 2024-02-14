package main.java.codingame.game;

import java.util.Arrays;

public class MagicSquare { // Odd numbers
	//	A magic square of order n is an arrangement of n� numbers, 
	//	usually distinct integers, in a square, such that the n numbers in all rows, 
	//	all columns, and both diagonals sum to the same constant. A magic square contains the integers from 1 to n�.
	//	The constant sum in every row, column and diagonal is called the magic constant or magic sum, M. 
	//	The magic constant of a normal magic square depends only on n and has the following value:
	//	M = n(n�+1)/2
	//	Magic Square of size 3
	//	-----------------------
	//	  2   7   6
	//	  9   5   1
	//	  4   3   8
	//	Sum in each row & each column = 3*(3^2+1)/2 = 15
	// Function to generate odd sized magic squares 
	static void generateSquare(int n) 
	{ 
		int[][] magicSquare = new int[n][n]; 

		// Initialize position for 1 
		int i = n/2; 
		int j = n-1; 

		// One by one put all values in magic square 
		for (int num=1; num <= n*n; ){ 
			if (i==-1 && j==n) { //3rd condition 
				j = n-2; 
				i = 0; 
			}else{ 
				//1st condition helper if next number  
				// goes to out of square's right side 
				if (j == n) 
					j = 0; 
				//1st condition helper if next number is  
				// goes to out of square's upper side 
				if (i < 0) 
					i=n-1; 
			} 
			//2nd condition 
			if (magicSquare[i][j] != 0){ 
				j -= 2; 
				i++; 
				continue; 
			}else
				//set number 
				magicSquare[i][j] = num++;  
			//1st condition 
			j++;  
			i--;  
		} 
		// print magic square 
		System.out.println("The Magic Square for "+n+":"); 
		System.out.println("Sum of each row or column "+n*(n*n+1)/2+":"); 
		for(i=0; i<n; i++) 
		{ 
			for(j=0; j<n; j++) 
				System.out.print(magicSquare[i][j]+" "); 
			System.out.println(); 
		} 
	} 

	static void generateSquareMin(int n) {
		if (n % 2 == 0) throw new RuntimeException("n must be odd");

		int[][] magic = new int[n][n];

		int row = n-1;
		int col = n/2;
		magic[row][col] = 1;

		for (int i = 2; i <= n*n; i++) {
			if (magic[(row + 1) % n][(col + 1) % n] == 0) {
				row = (row + 1) % n;
				col = (col + 1) % n;
			}
			else {
				row = (row - 1 + n) % n;
				// don't change col
			}
			magic[row][col] = i;
		}

		// print results
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (magic[i][j] < 10)  System.out.print("");  // for alignment
				if (magic[i][j] < 100) System.out.print("");  // for alignment
				System.out.print(magic[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static int minCost(int[][] matrix) {
		int[][] matrix1 =
			{{4, 9, 2},
					{3, 5, 7},
					{8, 1, 6}};

		int[][] matrix1inverse=
			{{8, 1, 6},
					{3, 5, 7},
					{4, 9, 2}};

		int[][] matrix2 =
			{{8, 3, 4},
					{1, 5, 9},
					{6, 7, 2}};

		int[][] matrix2inverse =
			{{4, 3, 8},
					{9, 5, 1},
					{2, 7, 6}};

		int[][] matrix3 =
			{{6, 1, 8},
					{7, 5, 3},
					{2, 9, 4}};

		int[][] matrix3inverse =
			{{2, 9, 4},
					{7, 5, 3},
					{6, 1, 8}};

		int[][] matrix4 =
			{{2, 7, 6},
					{9, 5, 1},
					{4, 3, 8}};

		int[][] matrix4inverse =
			{{6, 7, 2},
					{1, 5, 9},
					{8, 3, 4}};
		int [] sum = new int[8]; 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum[0] += Math.abs(matrix[i][j] - matrix1[i][j]);
				sum[1] += Math.abs(matrix[i][j] - matrix1inverse[i][j]);
				sum[2] += Math.abs(matrix[i][j] - matrix2[i][j]);
				sum[3] += Math.abs(matrix[i][j] - matrix2inverse[i][j]);
				sum[4] += Math.abs(matrix[i][j] - matrix3[i][j]);
				sum[5] += Math.abs(matrix[i][j] - matrix3inverse[i][j]);
				sum[6] += Math.abs(matrix[i][j] - matrix4[i][j]);
				sum[7] += Math.abs(matrix[i][j] - matrix4inverse[i][j]);
			}
		}
		Arrays.sort(sum);
		return sum[0];
	}
	public static void main(String[] args) {
		// Works only when n is odd 
		int n = 3; 
		generateSquare(n); 
		System.out.println("");
		generateSquareMin(n); 
		System.out.println("Min cost");
		int[][] matrix =
			{{4, 8, 2},
					{4, 5, 7},
					{6, 1, 6}};
		System.out.println(minCost(matrix)); 
		// Minimum cost to convert 3 X 3 matrix into magic square
		// Consider a 3 X 3 matrix, s, of integers in the inclusive range [1, 9] . 
		// We can convert any digit, a, to any other digit, b, in the range [1, 9] at cost |a � b|.
		// Given s, convert it into a magic square at minimal cost by changing zero or more of its digits. The task is to find minimum cost.
		// The idea is to find all 3 X 3 magic squares and, for each one, 
		// compute the cost of changing mat into a known magic square. The result is the smallest of these costs.
		// We know that s will always be 3 X 3. There are 8 possible magic squares for 3 X 3 matrix = n�-1
		// There are two ways to approach this:
		// So, compute all 8 magic squares by examining all permutations of integers 1, 2, 3, �.., 9 and for each one, 
		// check if it forms a magic square if the permutation is inserted into the square starting from the upper left hand corner.

	}
}
