package main.java.functionalprogramming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * There uses of Stream in Java are mentioned below:

 * Stream API is a way to express and process collections of objects.
 * Enable us to perform operations like filtering, mapping,reducing and sorting.
 * Stream<T> stream;
 * 
 * Intermediate Operations
 * Terminate Operations
 */
public class StreamMy {

	/**
	 * Important Intermediate Operations
	 */
	/**
	 * The map method is used to return a stream consisting of the results of applying the given function to the elements of this stream.
	 */
	static List<Integer> map() {
		List<Integer> number = Arrays.asList(2,3,4,5);
		List<Integer>  square = number.stream().map(x->x*x).collect(Collectors.toList());
		
		return square;
	}
	
	/**
	 * The filter method is used to select elements as per the Predicate passed as an argument.
	 */
	static List<String> filter() {
		List<String>  names = Arrays.asList("Reflection","Collection","Stream");
		List<String>  result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
		
		return result;
	}
	/**
	 * The sorted method is used to sort the stream.
	 */
	static List<String> sorted() {
		List<String> names = Arrays.asList("Reflection","Collection","Stream");
		List<String> result = names.stream().sorted().collect(Collectors.toList());
		
		return result;
	}
	
	/**
	 * Important Terminal Operations
	 */
	
	/**
	 * The collect method is used to return the result of the intermediate operations performed on the stream.
	 */
	static Set<Integer> collect() {
		List<Integer> number = Arrays.asList(2,3,4,5,3);
		Set<Integer> square = number.stream().map(x->x*x).collect(Collectors.toSet());
		
		return square;
	}
	
	/**
	 * The forEach method is used to iterate through every element of the stream.
	 */
	static void forEach() {
		List<Integer> number = Arrays.asList(2,3,4,5);
		number.stream().map(x->x*x).forEach(y->System.out.println(y));
	}
	
	/**
	 * The reduce method is used to reduce the elements of a stream to a single value. The reduce method takes a BinaryOperator as a parameter.
	 */
	static int reduce() {
		List<Integer> number = Arrays.asList(2,3,4,5);
		int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
		
		return even;
	}

	public static void main(String args[]) {
        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5); 
 
        // demonstration of map method
        List<Integer> square = number.stream()
						             .map(x -> x * x)
						             .collect(Collectors.toList());
 
        System.out.println(square);
        
        // create a list of String
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
 
        // demonstration of filter method
        List<String> result = names.stream()
        						   .filter(s -> s.startsWith("S"))
        						   .collect(Collectors.toList());
       
        System.out.println(result);
 
        // demonstration of sorted method
        List<String> show 
          = names.stream()
            	 .sorted()
                 .collect(Collectors.toList());
       
        System.out.println(show);
 
        // create a list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);
 
        // collect method returns a set
        Set<Integer> squareSet = numbers.stream()
							            .map(x -> x * x)
							            .collect(Collectors.toSet());
       
        System.out.println(squareSet);
 
        // demonstration of forEach method
        number.stream()
              .map(x -> x * x)
              .forEach(y -> System.out.println(y));
 
        // demonstration of reduce method
        int even = number.stream()
			             .filter(x -> x % 2 == 0)
			             .reduce(0, (ans, i) -> ans + i);
 
        System.out.println(even);
    }
}
