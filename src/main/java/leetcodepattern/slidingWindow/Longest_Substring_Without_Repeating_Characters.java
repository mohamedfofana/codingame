package main.java.leetcodepattern.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> hm = new HashMap<>();

        int start = 0, end = 0, result = 0;

        while (end < s.length()) {
            if (hm.containsKey(s.charAt(end))) {
                start = Math.max(start, hm.get(s.charAt(end)) + 1);
            }

            hm.put(s.charAt(end), end);
            ++end;
            result = Math.max(result, end - start);
        }

        return result;
    }
}
