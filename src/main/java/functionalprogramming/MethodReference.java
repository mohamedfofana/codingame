package main.java.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * There are four kinds of method references: 
 * Static methods
 * Instance methods of particular objects
 * Instance methods of an arbitrary object of a particular type
 * Constructor
 */

public class MethodReference {

	static void capitalize() {
		// capitalizing and printing a list of Strings:
		List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
		
		// We can achieve this by leveraging a simple lambda expression calling the StringUtils.capitalize() method directly:
		messages.forEach(word -> StringUtils.capitalize(word));
		
		// we can use a method reference to simply refer to the capitalize static method:
		messages.forEach(StringUtils::capitalize);
		messages.stream()
				.map(word -> StringUtils.capitalize(word))
				.forEach(System.out::println);
	}
	public static void main(String[] args) {
		capitalize();
		
		BicycleComparator bikeFrameSizeComparator = new BicycleComparator();
		List<Bicycle> bycicles = new ArrayList<>();
		
		bycicles.add(new Bicycle("A", 10));
		bycicles.add(new Bicycle("B", 21));
		bycicles.add(new Bicycle("C", 18));
		bycicles.stream().sorted((a, b) -> bikeFrameSizeComparator.compare(a, b));
		
		bycicles.stream().sorted(bikeFrameSizeComparator::compare).forEach(System.out::println);;
	}
}

class StringUtils {
	static String capitalize(String str) {
		return str.toUpperCase();
	}
}


class BicycleComparator implements Comparator<Bicycle> {

    @Override
    public int compare(Bicycle a, Bicycle b) {
        return a.getFrameSize().compareTo(b.getFrameSize());
    }

}
class Bicycle {

    private String brand;
    private Integer frameSize;

    public Bicycle(String brand, Integer frameSize) {
    	this.frameSize = frameSize;
    	this.brand = brand;
	}
    public String getBrand() {
		return brand;
	}
    public Integer getFrameSize() {
		return frameSize;
	}
    
    @Override
    public String toString() {
    	return new StringBuilder()
    			.append(brand)
    			.append("-")
    			.append(frameSize)
    			.toString();
    }		
}

