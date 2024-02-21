package main.java.codingame.arrays;

public class Ascenci {

	/**
	 * findLargestSquare of 1 with dynamic Programming
	 * @param matrix
	 * @param row
	 * @param cols
	 */
	public int findLargestSquareSimplified(int[][] matrix, int row, int cols) {
		int[][] squareArray = new int[row][cols];
		// copy the first row
		for (int i = 0; i < cols; i++) {
			squareArray[0][i] = matrix[0][i];
		}
		// copy the first column
		for (int i = 0; i < row; i++) {
			squareArray[i][0] = matrix[i][0];
		}

		// for rest of the matrix
		// check if arrA[i][j]==1
		int maxSize = 0;
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 1) {
					squareArray[i][j] = Math.min(squareArray[i - 1][j - 1],	Math.min(squareArray[i][j - 1], squareArray[i - 1][j])) + 1;
					maxSize = Math.max(maxSize, squareArray[i][j]);
				} else {
					squareArray[i][j] = 0;
				}
			}
		}
		// find the maximum size of sub matrix
		return maxSize;
	}
	
	/**
	 * Character
	 * findLargestSquare of 1 with dynamic Programming
	 * @param matrix
	 * @param row
	 * @param cols
	 */
	public int findLargestSquareSimplifiedChar(char[][] matrix, int row, int cols) {
		char[][] squareArray = new char[row][cols];
		// copy the first row
		for (int i = 0; i < cols; i++) {
			squareArray[0][i] = matrix[0][i];
		}
		// copy the first column
		for (int i = 0; i < row; i++) {
			squareArray[i][0] = matrix[i][0];
		}

		// for rest of the matrix
		// check if arrA[i][j]==1
		int maxSize = 0;
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == '1') {
					final int newValue = Math.min(Character.getNumericValue(squareArray[i - 1][j - 1]),	Math.min(Character.getNumericValue(squareArray[i][j - 1]), Character.getNumericValue(squareArray[i - 1][j]))) + 1; 
					squareArray[i][j] = (char) (newValue + '0');
					maxSize = Math.max(maxSize, newValue);
				} else {
					squareArray[i][j] = '0';
				}
			}
		}
		// find the maximum size of sub matrix
		return maxSize;
	}
	
	/**
	 * findLargestSquare of 1 with dynamic Programming
	 * @param matrix
	 * @param row
	 * @param cols
	 */
	public int findLargestSquare(int[][] matrix, int row, int cols) {
		int[][] squareArray = new int[row][cols];
		// copy the first row
		for (int i = 0; i < cols; i++) {
			squareArray[0][i] = matrix[0][i];
		}
		// copy the first column
		for (int i = 0; i < row; i++) {
			squareArray[i][0] = matrix[i][0];
		}

		// for rest of the matrix
		// check if arrA[i][j]==1
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 1) {
					squareArray[i][j] = Math.min(squareArray[i - 1][j - 1],	Math.min(squareArray[i][j - 1], squareArray[i - 1][j])) + 1;
				} else {
					squareArray[i][j] = 0;
				}
			}
		}
		// find the maximum size of sub matrix
		int maxSize = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				if (squareArray[i][j] > maxSize) {
					maxSize = squareArray[i][j];
				}
			}
		}
		return maxSize;
	}
	
	 public static void main(String[] args) {
		int[][] arrA = { { 0, 1, 0, 1, 0, 1 }, 
						  { 1, 0, 1, 0, 1, 0 },
						  { 0, 1, 1, 1, 1, 0 }, 
						  { 0, 0, 1, 1, 1, 0 },
				          { 1, 1, 1, 1, 1, 1 } };
		// [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
		int[][] arrA2 = { { 1, 0, 1, 0, 0 }, 
						   { 1, 0, 1, 1, 1 },
						   { 1, 1, 1, 1, 1 }, 
						   { 1, 0, 0, 1, 0 }};
		
		char[][] arrA3 = { { '1','0','1','0','0' }, 
						   { '1','0','1','1','1' },
						   { '1','1','1','1','1' }, 
						   { '1','0','0','1','0' }};
		
		char[][] arrA4 = { { '0','1' }, 
						   { '1','0' }};
		Ascenci i = new Ascenci();
		System.out.println(i.findLargestSquare(arrA, 5, 6));
		System.out.println(i.findLargestSquareSimplified(arrA, 5, 6));
		System.out.println(i.findLargestSquare(arrA2, 4, 5));
		System.out.println(i.findLargestSquareSimplified(arrA2, 4, 5));
		System.out.println(i.findLargestSquareSimplifiedChar(arrA3, 4, 5));
		//System.out.println("i.maximalSquare(arrA3)" +i.maximalSquare(arrA3));
		System.out.println("i.maximalSquare(arrA4)" + new LeetCodeMaximalSquare().maximalSquare(arrA4));
	}
	
}

class LeetCodeMaximalSquare {
	  public int maximalSquare(char[][] matrix) {
	        final int row = matrix.length;
	        final int cols = matrix[0].length;
	        int[][] squareArray = new int[row+1][cols+1];


			// for rest of the matrix
			// check if arrA[i][j]==1
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= cols; j++) {
					if (matrix[i-1][j-1] == '1') {
	                    squareArray[i][j] = getMinSquare(i, j, squareArray);                    
					} else {
						squareArray[i][j] = 0;
					}
				}
			}

	        // find max sqare size in array
			int maxSize = 0;
	        for (int i = 0; i <= row; i++) {
				for (int j = 0; j<= cols; j++) {
	                maxSize = Math.max(maxSize, squareArray[i][j]);
	            }
	        }

			return maxSize * maxSize;
	    }

	    int getMinSquare(int i, int j, int[][] squareArray) {
	        final int value = Math.min(squareArray[i - 1][j - 1],	Math.min(squareArray[i][j - 1], squareArray[i - 1][j])) + 1;

	        return value;
	    }
}

