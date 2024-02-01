package main.java.leetcode.helperClass;


public class ListNode {  
    private int val;  
    private ListNode next;  
    public ListNode(int val) {  
        this.val = val;  
    }  
    
    public ListNode getNext() {
		return next;
	}
    
    public void setNext(ListNode next) {
		this.next = next;
	}

    public void setNext(int val) {
    	this.next = new ListNode(val);
    }
    
    public int getVal() {
		return val;
	}
}  
