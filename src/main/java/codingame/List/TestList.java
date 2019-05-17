package main.java.codingame.List;

import java.util.LinkedList;

public class TestList {

	public static void main(String[] args) {
		LinkedList<String> linkedString = new LinkedList<String>();
		linkedString.add("premier");
		linkedString.add("deuxieme");
		linkedString.add("dernier");
		
		System.out.println(linkedString.get(0));
		System.out.println(linkedString.get(1));
		System.out.println(linkedString.get(2));
	}
}
