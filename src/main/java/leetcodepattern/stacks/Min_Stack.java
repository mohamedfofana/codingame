package main.java.leetcodepattern.stacks;

public class Min_Stack {
    class Node {
        private int val, min;
        Node next;

        public Node(int v, int m) {
            val = v;
            min = m;
            next = null;
        }
    }

    Node head;

    public Min_Stack() {
        head = null;
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            Node n = new Node(val, Math.min(val, head.min));
            n.next = head;
            head = n;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
