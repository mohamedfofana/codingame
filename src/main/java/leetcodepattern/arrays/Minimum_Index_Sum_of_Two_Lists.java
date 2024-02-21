package main.java.leetcodepattern.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Index_Sum_of_Two_Lists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m = new HashMap<>();
        List<String> result = new ArrayList<>();
        int maxFreq = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            m.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (m.containsKey(list2[i])) {
                int rating = m.get(list2[i]) + i;

                if (rating <= maxFreq) {
                    if (rating != maxFreq) {
                        result.clear();
                    }
                    result.add(list2[i]);
                    maxFreq = rating;
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
