package main.java.codingame;

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
	
}
