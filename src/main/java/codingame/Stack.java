package main.java.codingame;

import java.util.EmptyStackException;

public class Stack {

    // keep these two fields as they​​​​​​​‌‌‌‌‌​‌‌​​​‌‌‌‌‌​​‌​​‌‌​ are
    private Object[] elements;
	private int size = 0;

	public Stack(int initialCapacity) {
		elements = new Object[initialCapacity];
	}

	public void push(Object object) {
		ensureCapacity();
		elements[size++] = object;
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		return elements[--size];
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			Object[] old = elements;
			elements = new Object[2 * size + 1];
			System.arraycopy(old, 0, elements, 0, size);
		}
	}
	public static void main(String[] args) {
		int arr1[] = { 5 };
	      int arr2[] = { 5, 10, 20, 30, 40, 50 };
	    
	      // copies an array from the specified source array
	      System.arraycopy(arr1, 0, arr2, 0, 1);
	      System.out.print("array2 = ");
	      System.out.print(arr2[0] + " ");
	      System.out.print(arr2[1] + " ");
	      System.out.print(arr2[2] + " ");
	      System.out.print(arr2[3] + " ");
	      System.out.print(arr2[4] + " ");
	      System.out.print(arr2[5] + " ");
	      System.out.print(arr2[6] + " ");

	}
}
