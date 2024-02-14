package main.java.codingame.string;

public class ReverseString {

	static String reverseStringBuilder(String str) {
		if(str == null) {
			return str;
		}
		
		return new StringBuilder(str).reverse().toString();
	}
	
	static String reverseStringBuffer(String str) {
		if(str == null) {
			return str;
		}
		
		return new StringBuffer(str).reverse().toString();
	}
	
	/**
	 * not good because uses literal
	 * @param str
	 * @return
	 */
	static String reverseString(String str) {
		String reverse = "";
		for (int i = str.length()-1; i >= 0; i--) {
			reverse+=str.charAt(i);
		}
		
		return reverse;
	}
	public static void main(String[] args) {
		System.out.println(reverseString("abcd"));
		System.out.println(reverseStringBuilder("abcd"));
		System.out.println(reverseStringBuffer("abcd"));
	}
	
}
