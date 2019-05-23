package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.codingame.Fibonacci;

public class TestFibonacci {

	@Test
	public void testFibonacciIteratif() {
		// Given
		int in = 13;
		int expectedResult = 233; 
		// When
		int actualResult = Fibonacci.fibonacciIteratif(in);
		// Then
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testFibonacciRecursif() {
		// Given
		int in = 13;
		int expectedResult = 233; 
		// When
		int actualResult = Fibonacci.fibonacciRecursif(in);
		// Then
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testFibonacciRecursifMemoization() {
		// Given
		int in = 13;
		int expectedResult = 233; 
		// When
		int actualResult = Fibonacci.fibonacciMemoization(in);
		// Then
		assertEquals(expectedResult, actualResult);
	}
}
