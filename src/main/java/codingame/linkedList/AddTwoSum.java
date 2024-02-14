package main.java.codingame.linkedList;

import java.util.ArrayList;
import java.util.List;

import main.java.leetcode.helperClass.ListNode;

public class AddTwoSum {

	public ListNode addTwoNumbersLintCodeSolution(ListNode l1, ListNode l2) {

		ListNode dummyHead = new ListNode(0);
		ListNode tail=dummyHead;
		int carry=0;

		while(l1!=null || l2!=null|| carry!=0){
			int digit1=(l1!=null) ?l1.val : 0;
			int digit2=(l2!=null)? l2.val :0;

			int sum=digit1+digit2+carry;

			int digit=sum%10;
			carry=sum/10;

			ListNode  newNode=new ListNode(digit);
			tail.next=newNode;
			tail=tail.next;

			l1=(l1!=null)?l1.next:null;
			l2=(l2!=null)?l2.next:null;

		}
		ListNode result=dummyHead.next;
		dummyHead.next=null;
		return result;
	}

	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		final var numbers1= getDigitListFromListNode(l1);
		final var numbers2= getDigitListFromListNode(l2);

		ListNode list1;
		ListNode list2;
		list1 = l1;
		list2 = l2;
		if(numbers2.size() > numbers1.size()) {
			list1 = l2;
			list2 = l1;
		}

		ListNode ptr1 = list1;
		ListNode ptr2 = list2;
		ListNode ptr = null;
		int ret = 0;
		int newVal = 0;
		while(ptr1 != null && ptr2 !=null) {
			int sum = ptr1.val + ptr2.val + ret;
			newVal = sum;
			if(sum >= 10) {
				ret = 1;
				newVal = sum % 10;
			}else {
				ret = 0;
			}
			ptr = insert(ptr, newVal);
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		while(ptr1 != null) {
			int sum = ptr1.val + ret;
			newVal = sum;
			if(sum >= 10) {
				ret = 1;
				newVal = sum % 10;
			}else {
				ret = 0;
			}
			ptr = insert(ptr, newVal);
			ptr1 = ptr1.next;
		}
		if(ret > 0) {
			ptr = insert(ptr, ret);
		}
		return ptr;
	}

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
	
	static List<Integer> getDigitListFromListNode(ListNode listNode){
		var numbers= new ArrayList<Integer>();
		while(listNode!= null) {
			numbers.add(listNode.val);
	    	listNode = listNode.next;
	    }
		
		return numbers;
	}
	
    static void printListNode(ListNode listNode){
    	var numbers1= getDigitListFromListNode(listNode);
    	System.out.println(numbers1.toString());
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

	public static void main(String[] args) {
	//		ListNode l1 = new ListNode(2);
	//		l1.next = new ListNode(4);
	//		l1.next.next= new ListNode(3);
	//		
	//		ListNode l2 = new ListNode(5);
	//		l2.next = new ListNode(6);
	//		l2.next.next = new ListNode(4);
			
			ListNode l1 = new ListNode(9);
			l1.next = new ListNode(9);
			l1.next.next= new ListNode(1);
			
			ListNode l2 = new ListNode(1);
			printListNode(l1);
			printListNode(l2);
			
			ListNode result = addTwoNumbers(l1, l2);
	
			printListNode(result);
	    	
		}
    
}
