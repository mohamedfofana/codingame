package main.java.leetcodepattern.arrays;

public class Find_the_Celebrity extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;

        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }

            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

	private boolean knows(int candidate, int i) {
		// TODO Auto-generated method stub
		return false;
	}
}

class Relation{
	
}
