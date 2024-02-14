package main.java.functionalprogramming.lambdas;

import java.util.ArrayList;

/**
 * Lambda Expression in Java
 * In Java, Lambda expressions basically express instances of functional interfaces 
 * (An interface with a single abstract method is called a functional interface). 
 * Lambda Expressions in Java are the same as lambda functions which are the short block of code that accepts input as parameters and returns a resultant value. 
 * Lambda Expressions are recently included in Java SE 8. 
 * 
 */
public class LambdaMy {

	public static void main(String args[]){
		// lambda expression to implement above
		// functional interface. This interface
		// by default implements abstractFun()
		FuncInterface fobj = (int x)->System.out.println(2*x);
		FuncInterfaceWithAnnotation fobjAnnot = (int x, int y)-> System.out.println(x+y);

		// This calls above lambda expression and prints 10.
		fobj.abstractFun(5);
		fobjAnnot.sum(5, 6);
		
		// Creating an ArrayList with elements
        // {1, 2, 3, 4}
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);
 
        // Using lambda expression to print all elements
        // of arrL
        arrL.forEach(n -> System.out.println(n));
 
        // Using lambda expression to print even elements
        // of arrL
        arrL.forEach(n -> {
            if (n % 2 == 0)
                System.out.println(n);
        });
	}
}
//Java program to demonstrate lambda expressions
//to implement a user defined functional interface.

//A sample functional interface (An interface with
//single abstract method
interface FuncInterface {
	// An abstract function
	void abstractFun(int x);

	// A non-abstract (or default) function
	default void normalFun() {
		System.out.println("Hello");
	}
}

/**
 * The annotation Force the function to accept only ONE abstract method
 */
@FunctionalInterface
interface FuncInterfaceWithAnnotation {
	// An abstract function
	void sum(int x, int y);

	// A non-abstract (or default) function
	default void normalFun(){
		System.out.println("Hello");
	}
	
	static void print() {
		
	}
}

