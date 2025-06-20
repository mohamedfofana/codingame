package main.java.leetcodepattern.strings;

import java.util.HashMap;
import java.util.Map;

public class First_Unique_Character_In_String {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
