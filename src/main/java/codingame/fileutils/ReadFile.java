package main.java.codingame.fileutils;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static String readFile(String path) {
		FileReader reader;
		StringBuilder  stringBuilder = null;
		try {
			reader = new FileReader( path );
			String         line = null;
			stringBuilder = new StringBuilder();

			char[] b = new char[5];
			int n;
			while (( n = reader.read(b)) > 0 ) {
				stringBuilder.append( b, 0, n );
			}
		} catch (IOException e) { // (IOException e ¡ another Exception)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
}
