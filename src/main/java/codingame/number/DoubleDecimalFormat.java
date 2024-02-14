package main.java.codingame.number;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DoubleDecimalFormat {
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
		NumberFormat formatter = new DecimalFormat("#0.00");     
		System.out.println(formatter.format(4.0));
		System.out.println(sum("99.35", "1.106"));
	}
}
