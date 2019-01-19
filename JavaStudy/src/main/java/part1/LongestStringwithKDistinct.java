package part1;

import java.util.HashMap;

public class LongestStringwithKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                while (map.size() > k) {
                    char rm = s.charAt(start);
                    int tempCount = map.get(rm);
                    if (tempCount > 1) {
                        map.put(rm, tempCount - 1);
                    } else {
                        map.remove(rm);
                    }
                    start++;
                    count--;
                }
            }
            count++;
            max = Math.max(max, count);
        }
        return max;
    }
}
