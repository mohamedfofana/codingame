package main.java.codingame.string;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ReshapeString {

	/**
	 * Sans \n et avec StringWriter
	 *Exemple 1
	  Input: reshape(3 , "abcd de f g   h")
	  Output:  abc
			   def
			   gh 
	  Exemple 2 : 
	  Input: reshape(3 , " 1 23 4586   88 9 ")
	  Output:  123	
               458
               688
               9 
	 * @param n
	 * @param string
	 * @return pasa de \n final
	 */
	static String reshapeWithStringWriter(int n, String string) {
		
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		String noSpaceString = string.trim().replace(" ", "");
		int i = 0;
		while(i < noSpaceString.length()) {
			if(i+n < noSpaceString.length()) {
				printWriter.println(noSpaceString.substring(i, i+n));
			}else {
				printWriter.print(noSpaceString.substring(i));
			}
			i+=n;
			
		}
		return stringWriter.toString() ;
	}
	
	/**
	 * System.lineSeparator();
	 *Exemple 1
	  Input: reshape(3 , "abcd de f g   h")
	  Output:  abc
			   def
			   gh 
	  Exemple 2 : 
	  Input: reshape(3 , " 1 23 4586   88 9 ")
	  Output:  123	
               458
               688
               9 
	 * @param n
	 * @param string
	 * @return pasa de \n final
	 */
	static String reshape(int n, String string) {
		
		StringBuilder sb = new StringBuilder();
		String endofline = System.lineSeparator();
		String noSpaceString = string.trim().replace(" ", "");
		int i = 0;
		while(i < noSpaceString.length()) {
			if(i+n < noSpaceString.length()) {
				sb.append(noSpaceString.substring(i, i+n));
				sb.append(endofline);
			}else {
				sb.append(noSpaceString.substring(i));
			}
			i+=n;
			
		}
		return sb.toString() ;
	}
	public static void main(String[] args) {
		System.out.println(reshapeWithStringWriter(3, "abc de f g  h")); 
		//abc
		//def
		//gh
		System.out.println(reshapeWithStringWriter(4, "1 23 4576 88 9"));
		//1234
		//5768
		//89
		System.out.println(reshape(3, "abc de f g  h")); 
		//abc
		//def
		//gh
		System.out.println(reshape(4, "1 23 4576 88 9"));
		//1234
		//5768
		//89
	}
}
