package main.java.leetcodepattern.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        pq.addAll(hm.entrySet());

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();

            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
