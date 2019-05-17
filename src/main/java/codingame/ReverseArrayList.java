package main.java.codingame;

import java.util.ArrayList;
import java.util.List; 
class ReverseArrayList { 

	// Takes an arraylist as a parameter and returns  
    // a reversed arraylist 
    public List<Integer> reverseArrayListMoreSpace(List<Integer> alist) { 
        List<Integer> revArrayList = new ArrayList<Integer>(); 
        for (int i = alist.size() - 1; i >= 0; i--) { 
            revArrayList.add(alist.get(i)); 
        } 
        return revArrayList; 
    }	
    
 // Takes an arraylist as a parameter and returns 
 // a reversed arraylist 
 public static List<Integer> reverseArrayList(List<Integer> alist){ 
     for (int i = 0; i < alist.size() / 2; i++) { 
         Integer temp = alist.get(i); 
         alist.set(i, alist.get(alist.size() - i - 1)); 
         alist.set(alist.size() - i - 1, temp); 
     } 
     return alist; 
 } 

 // Iterate through all the elements and print 
 public static void printElements(List<Integer> alist) { 
     for (int i = 0; i < alist.size(); i++) { 
         System.out.print(alist.get(i) + " "); 
     } 
 } 
 public static void main(String[] args) { 

     // Declaring arraylist without any initial size 
     List<Integer> arrayli = new ArrayList<Integer>(); 

     // Appending elements at the end of the list 
     arrayli.add(new Integer(12)); 
     arrayli.add(new Integer(13)); 
     arrayli.add(new Integer(123)); 
     arrayli.add(new Integer(54)); 
     arrayli.add(new Integer(1)); 
     System.out.print("Elements before reversing: "); 
     printElements(arrayli); 
     arrayli = reverseArrayList(arrayli); 
     System.out.print("\nElements after reversing: "); 
     //Collections.reverse(arrayli);
     printElements(arrayli); 
     System.out.println();
     for (int i = 1; i < 11; i++) 
    	 System.out.println(i);
 } 
} 