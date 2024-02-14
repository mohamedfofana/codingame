package main.java.codingame.string;

public class Palindrome {
	public boolean isPalindrome( String str ) {
		/*----------NE MODIFIEZ PAS LE CODE AU DESSUS DE CETTE LIGNE, IL SERA REINITIALISE LORS DE l'EXECUTION----------*/
		
		StringBuilder sb = new StringBuilder(str);
		if (sb.reverse().toString().toLowerCase().equals(str.toLowerCase()))
		    return true;
		return false;

		/*----------NE MODIFIEZ PAS LE CODE EN DESSOUS DE CETTE LIGNE, IL SERA REINITIALISE LORS DE l'EXECUTION----------*/
    }
	public boolean isPalindrome2(String str) {
		for ( int x=0, y=(str.length()-1); x<y; x++,y-- ) {
			String start = str.substring( x, x+1 ).toLowerCase();
	        String end   = str.substring( y, y+1 ).toLowerCase();

			if ( !  start.equals( end )  ) {
	        	return false;
	        }
		}
		return true;
	}
	
	/**
	 * Check if characters of a given string can be rearranged to form a palindrome
	 */
	static boolean canFormPalindrome(String a){
		// bitvector to store
		// the record of which character appear
		// odd and even number of times
		int bitvector = 0, mask = 0;
		for (int i = 0; i < a.length(); i++){
			int x = a.charAt(i) - 'a';
			mask = 1 << x;

			bitvector = bitvector ^ mask;
		}

		return (bitvector & (bitvector - 1)) == 0;
	}

	// Driver Code
	public static void main (String[] args) {

		if (canFormPalindrome("geeksforgeeks"))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
