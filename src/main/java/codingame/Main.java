package main.java.codingame;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static final int MAXSIZE = 100;
	static String sum(String... numbers) {
		NumberFormat formatter = new DecimalFormat("#0.00");		
		double total = 0.0;
		for (String number : numbers) {
			total = total + Double.parseDouble(number);
		}

		return formatter.format(total);
	}
	
	public static void main(String[] args) {
		A a = new A();
		A b = new B();
		System.out.println(2>>1);
		System.out.println(01|11);
		System.out.println(5/2);
		NumberFormat formatter = new DecimalFormat("#0.00");     
		System.out.println(formatter.format(4.0));
		System.out.println(sum("99.35", "1.106"));
		Set<String> t = new HashSet();
	}

}
class A{
	
}

class B extends A{
	
}
