package main.java.codingame;

public class ConcatString {
    /**
     * Concatenates the given array of strings.
     */
	static String concat(String[] strings) {
		StringBuilder str = new StringBuilder(strings[0]);
		for (int i = 1; i<strings.length; i++)
		    str.append(strings[i]);
		return str.toString();
	}

}
