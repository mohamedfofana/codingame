package test.java.codingame.tri;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.codingame.tri.Dichotomique;

public class TestDichotomieRecursifMemo {

	@Test
	public void testDichotomie_index_debut() {
		// Given 
		int[] arr = {2, 3, 5, 7, 8, 9, 11, 19, 24, 99};
		int expectedResult = 0;
		int searchInt = 2;
		// When
		int actualResult = Dichotomique.dichoSearchMemoization(arr, searchInt);

		// Then
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testDichotomie_index_fin() {
		// Given 
		int[] arr = {2, 3, 5, 7, 8, 9, 11, 19, 24, 99};
		int expectedResult = 9;
		int searchInt = 99;
		// When
		int actualResult = Dichotomique.dichoSearchMemoization(arr, searchInt);

		// Then
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testDichotomie_index_mid() {
		// Given 
		int[] arr = {2, 3, 5, 7, 8, 9, 11, 19, 24, 99};
		int expectedResult = 4;
		int searchInt = 8;
		// When
		int actualResult = Dichotomique.dichoSearchMemoization(arr, searchInt);
		
		// Then
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testDichotomie_index_exist_upper() {
		// Given 
		int[] arr = {2, 3, 5, 7, 8, 9, 11, 19, 24, 99};
		int expectedResult = 7;
		int searchInt = 19;
		// When
		int actualResult = Dichotomique.dichoSearchMemoization(arr, searchInt);
		
		// Then
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testDichotomie_index_exist_down() {
		// Given 
		int[] arr = {2, 3, 5, 7, 8, 9, 11, 19, 24, 99};
		int expectedResult = 2;
		int searchInt = 5;
		// When
		int actualResult = Dichotomique.dichoSearchMemoization(arr, searchInt);
		
		// Then
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testDichotomie_index_notExists_but_in_scope() {
		// Given 
		int[] arr = {2, 3, 5, 7, 8, 9, 11, 19, 24, 99};
		int expectedResult = -1;
		int searchInt = 43;
		// When
		int actualResult = Dichotomique.dichoSearchMemoization(arr, searchInt);
		
		// Then
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testDichotomie_index_notExists_but_out_of_scope() {
		// Given 
		int[] arr = {2, 3, 5, 7, 8, 9, 11, 19, 24, 99};
		int expectedResult = -1;
		int searchInt = 121;
		// When
		int actualResult = Dichotomique.dichoSearchMemoization(arr, searchInt);
		
		// Then
		assertEquals(expectedResult, actualResult);
	}
}
