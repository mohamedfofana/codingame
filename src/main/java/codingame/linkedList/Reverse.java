package main.java.codingame.linkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Reverse {
	static LinkedList<String> reverseLinkedList(LinkedList<String> str) {
		LinkedList<String> newTtmp = new LinkedList<>();
		Iterator<String> itr=str.iterator();  
		while(itr.hasNext()){  
			newTtmp.addFirst(itr.next());
		}  

		
		return newTtmp;
	}
	
	public static void main(String[] args) {
		System.out.println(reverseLinkedList(new LinkedList<String>(Arrays.asList("a", "b", "c", "d")) ));
	}
}
