package main.java.functionalprogramming.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class LambdaCollections {

	static void lambdaComparator() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(205);
		al.add(102);
		al.add(98);
		al.add(275);
		al.add(203);
		System.out.println("Elements of the ArrayList " + 
				"before sorting : " + al);

		// using lambda expression in place of comparator object
		Collections.sort(al, (o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);

		System.out.println("Elements of the ArrayList after" + " sorting : " + al);
	}

	static void lambdaOnTree() {
		/**
		 * Ordered by default
		 */
		TreeSet<Integer> h = new TreeSet<Integer>((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
		h.add(850);
		h.add(235);
		h.add(1080);
		h.add(15);
		h.add(5);

		System.out.println("Elements of the TreeSet after" + " sorting are: " + h);
	}
	static void lambdaOnTreeReverse() {
		// Pass a reverse comparator to TreeSet() via a lambda expression
		TreeSet<String> ts=new TreeSet<String>((aStr,bStr) -> bStr.compareTo(aStr));

		// Add elements to the Treeset
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("E");
		ts.add("F");
		ts.add("G");

		//Display the elements .
		for(String element : ts)
			System.out.println(element + "");

		System.out.println();
	}

	public static void main(String[] args) {
		lambdaComparator();
		lambdaOnTree();
		lambdaOnTreeReverse();
	}
}
