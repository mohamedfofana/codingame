package main.java.codingame.fileutils;

import java.io.File;

public class AbsolutePathOfFileInDirSubDir {
	
	// R�cup�rer le chemin absolu d'un fichier dans repertoire ou sous repertoire
	// M�thode R�cursive
	public static String getFileAbsolutePath(File directory) {
		File[] fList = directory.listFiles(); 
		for (File file : fList) { 
			if (!file.isDirectory() && "universe-formula".equals(file.getName()))
				return file.getAbsolutePath();
			else if (file.isDirectory()) 
				getFileAbsolutePath(file); 
		} 
		return "";
	}
	public static void main(String[] args) {
		File directory = new File("/tmp/documents");
		String cheminAbsolu = getFileAbsolutePath(directory);
	}

}
