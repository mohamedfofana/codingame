package main.java.codingame.game;

/**
 * // Java program to Find the minimum 
   // number of moves required to reach
   // the destination by the king in a 
   // chess board
 */
public class ChessBoardGame {
	// function to Find the minimum number 
	// of moves required to reach the
	// destination by the king in a chess board
	static void minSteps(int sourceX, int sourceY, int destX, int destY){
		// minimum number of steps
		System.out.println(Math.max(Math.abs(sourceX - destX),Math.abs(sourceY - destY)));
		// while the king is not in the same 
		// row or column as the destination
		while ((sourceX != destX) || (sourceY != destY)) {
			// Go up
			if (sourceX < destX){
				System.out.print( 'U');
				sourceX++;
			}
			// Go down
			if (sourceX > destX){
				System.out.println( 'D');
				sourceX--;
			}
			// Go left
			if (sourceY > destY){
				System.out.print( 'L');
				sourceY--;
			}
			// Go right
			if (sourceY < destY){
				System.out.print( 'R');
				sourceY++;
			}
			System.out.println();
		}
	}
	
	public static void main (String[] args){
		int sourceX = 4, sourceY = 4;
		int destinationX = 7, destinationY = 0;

		minSteps(sourceX, sourceY, destinationX, destinationY);
	}
}
