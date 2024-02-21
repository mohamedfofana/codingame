package main.java.leetcodepattern.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Flatten_Nested_List_Iterator implements Iterator<Integer> {
    private Deque<Iterator<NestedInteger>> st;
    private Integer next;

    public Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        st = new ArrayDeque<>();
        st.push(nestedList.iterator());
        advance();
    }

    private void advance() {
        next = null;

        while (!st.isEmpty()) {
            Iterator<NestedInteger> it = st.peekFirst();

            if (!it.hasNext()) {
                st.pollFirst();
            } else {
                NestedInteger n = it.next();

                if (n.isInteger()) {
                    next = n.getInteger();
                    return;
                } else {
//                    st.push(n.getList().iterator());
                }
            }
        }
    }

    @Override
    public Integer next() {
        Integer n = next;
        advance();
        return n;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}

class NestedInteger {

	public boolean isInteger() {
		// TODO Auto-generated method stub
		return false;
	}

	public Deque<Iterator<NestedInteger>> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getInteger() {
		// TODO Auto-generated method stub
		return null;
	}
}
