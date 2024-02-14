package main.java.functionalprogramming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Stream.reduce() in Java with examples
 */
/**
 * Many times, we need to perform operations where a stream reduces to single resultant value, 
 * for example, maximum, minimum, sum, product, etc. Reducing is the repeated process of combining all elements.

reduce operation applies a binary operator to each element in the stream where the first argument to the operator is the return value of the previous application and second argument is the current stream element.
* 
 */
public class StreamReduce {
	/**
	 * T reduce(T identity, BinaryOperator<T> accumulator);
	 * Where, identity is initial value 
	 * of type T and accumulator is a 
	 * function for combining two values.
	 * sum(), min(), max(), count() etc. are some examples of reduce operations. reduce() explicitly asks you to specify how to reduce the data that made it through the stream.
	 */
	
	// Implementation of reduce method 
	// to get the longest String 
	static void longestStream() {
		 // creating a list of Strings 
        List<String> words = Arrays.asList("GFG", "Geeks", "for", 
                                           "GeeksQuiz", "GeeksforGeeks"); 
  
        // The lambda expression passed to 
        // reduce() method takes two Strings 
        // and returns the longer String. 
        // The result of the reduce() method is 
        // an Optional because the list on which 
        // reduce() is called may be empty. 
        Optional<String> longestString = words.stream() 
                                   			  .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2); 
  
        // Displaying the longest String 
        longestString.ifPresent(System.out::println); 
	}
	


	// Implementation of reduce method 
	// to get the combined String 
	static void combineString() {
		 // String array 
        String[] array = { "Geeks", "for", "Geeks" }; 
  
        // The result of the reduce() method is 
        // an Optional because the list on which 
        // reduce() is called may be empty. 
        Optional<String> String_combine = Arrays.stream(array) 
                                           .reduce((str1, str2) 
                                           -> str1 + "-" + str2); 
  
        // Displaying the combined String 
        if (String_combine.isPresent()) { 
            System.out.println(String_combine.get()); 
        } 
	}
	
	// Implementation of reduce method 
	// to get the sum of all elements 
	static void sum() {
		  // Creating list of integers 
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8); 
  
        // Finding sum of all elements 
        int sum = array.stream().reduce(0, 
                (element1, element2) -> element1 + element2); 
  
        // Displaying sum of all elements 
        System.out.println("The sum of all elements is " + sum); 
	}
	
	// Implementation of reduce method 
	// to get the product of all numbers 
	// in given range. 
	static void productRamge() {
		 // To get the product of all elements 
        // in given range excluding the 
        // rightmost element 
        int product = IntStream.range(2, 8) 
                     .reduce((num1, num2) -> num1 * num2) 
                     .orElse(-1); 
  
        // Displaying the product 
        System.out.println("The product is : " + product); 
	}
	
	public static void main(String[] args) {
		longestStream();
		combineString();
	}
}
