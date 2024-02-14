package main.java.codingame.string;

import java.util.Map;
import java.util.TreeMap;

public class TranslateStringAddAV {

	
	static String translate(String text) {
		final StringBuilder result = new StringBuilder();
		final String vowel = "aoeiu";
		final String replace = "av";
		for (int i = 0; i < text.length(); i++) {
			final char current = text.charAt(i);
			if(vowel.indexOf(current) > -1) {
				if(i-1 < 0 || vowel.indexOf(text.charAt(i-1)) < 0) {
					result.append(replace);
				}
			}
			result.append(current);
		}
		
		return result.toString();
	}
	
	
	public static void main(String[] args) {
			System.out.println(translate("codingame")); // "cavodavingavamave";
			System.out.println(translate("codiale")); // "cavodavialave";
	}
}
