package main.java.codingame.linkedList;

/**
 * 
 * Nth node from the end of a Linked List using two pointers:
As Nth node from the end equals to (Length – N + 1)th node from the start, so the idea is to Maintain 
two pointers starting from the head of the Linked-List and move one pointer to the Nth node from the start 
and then move both the pointers together until the pointer at the Nth position reaches the last node. 
Now the pointer which was moved later points at the Nth node from the end of the Linked-List
 * Time Complexity: O(M) where M is the length of the linked list.
	Auxiliary Space: O(1)
 */
public class NNodeFromEndOfLinkedList {
	Node head; // head of the list
	 
    /* Linked List node */
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    /* Function to get the
      Nth node from end of list */
    void printNthFromLast(int N)
    {
        Node main_ptr = head;
        Node ref_ptr = head;
 
        int count = 0;
        if (head != null) {
            while (count < N) {
                if (ref_ptr == null) {
                    System.out.println(
                        N + " is greater than the no "
                        + " of nodes in the list");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }
 
            if (ref_ptr == null) {
 
                if (head != null)
                    System.out.println("Node no. " + N
                                       + " from last is "
                                       + head.data);
            }
            else {
 
                while (ref_ptr != null) {
                    main_ptr = main_ptr.next;
                    ref_ptr = ref_ptr.next;
                }
                System.out.println("Node no. " + N
                                   + " from last is "
                                   + main_ptr.data);
            }
        }
    }
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
}
