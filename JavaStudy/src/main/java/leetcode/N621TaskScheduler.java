package leetcode;

import java.util.HashMap;
import java.util.Set;
//做错了

public class N621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Object, Integer> map = new HashMap<>();
        for (int c : tasks) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int result = 0;
        HashMap<Object, Integer> lastLocation = new HashMap<>();
        while (map.size() != 0) {
            Object[] keySet = map.keySet().toArray();
            for (int i = 0; i < keySet.length; i++) {
                Object key = keySet[i];
                Integer lastIndex = lastLocation.get(key);
                int v = lastIndex == null ? 0 : lastIndex;

                result += Math.max(0, result - n - v);

                if (map.get(key) == 1) {
                    map.remove(key);
                    keySet[i] = -1;
                } else {
                    map.put(key, map.get(key) - 1);
                }
                lastLocation.put(key, result);//store the index
                result++;
            }
        }
        return result;
    }
}
