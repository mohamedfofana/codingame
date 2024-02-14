package main.java.codingame.linkedList;

import java.util.ArrayList;
import java.util.List;

import main.java.leetcode.helperClass.ListNode;

public class AddTwoSum2 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next= new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		printListNode(l1);
		printListNode(l2);
		
		ListNode result = addTwoNumbers(l1, l2);

		printListNode(result);
		
	}
	
    static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
    	final var numbers1= getDigitListFromListNode(list1);
    	final var numbers2= getDigitListFromListNode(list2);
        final int finalSum = getNumberFromDigitList(numbers1) + getNumberFromDigitList(numbers2);
        
        if(finalSum < 10) {
        	return new ListNode(finalSum);
        }
        ListNode list = getListNodeFromNumber(finalSum);
        
        return list;
    }
    
    static List<Integer> getDigitListFromListNode(ListNode listNode){
		var numbers= new ArrayList<Integer>();
		while(listNode!= null) {
			numbers.add(listNode.val);
	    	listNode = listNode.next;
	    }
		
		return numbers;
	}

	static int getNumberFromDigitList(List<Integer> list){
		int sum = 0;
	    for (int i = list.size() -1; i > 0; i--) {
			sum += list.get(i)*Math.pow(10, i);
		}
	    sum+=list.get(0);
	    return sum;
	}

	static ListNode getListNodeFromNumber(int finalSum){
    	ListNode list = null;
    	int newSum = finalSum;
    	while(newSum > 0) {
    		list = insert(list, newSum % 10);
    		newSum = newSum / 10; 
    	}
    	
    	return list;
    }
    /**
     * Not used
     * @param node
     * @return
     */
    static ListNode reverse(ListNode node){
    	ListNode prev = null;
    	ListNode current = node;
    	ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        
        return node;
    }
    
    static void printListNode(ListNode listNode){
    	var numbers1= getDigitListFromListNode(listNode);
    	System.out.println(numbers1.toString());
    }
    
    /**
     * Not used
     * @param node
     * @return
     */
    static ListNode arrayToListNode(int arr[], int n) 
    { 
    	ListNode root = null; 
        for (int i = 0; i < n; i++) {
            root = insert(root, arr[i]);
        }
        
        return root; 
    } 
    
    static ListNode insert(ListNode head, int val){ 
    	ListNode newListNode = new ListNode(); 
    	ListNode tempListNode; 
        newListNode.val = val; 
        newListNode.next = null; 
      
        if (head == null) {
            head = newListNode; 
        }else { 
            tempListNode = head; 
            while (tempListNode.next != null) {
                tempListNode = tempListNode.next; 
            }
            tempListNode.next = newListNode; 
        } 
        
        return head; 
    } 
   
}
