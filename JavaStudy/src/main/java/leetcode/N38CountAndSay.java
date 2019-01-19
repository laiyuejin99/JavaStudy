package leetcode;

import java.util.LinkedList;

public class N38CountAndSay {
    public String countAndSay(int n) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(1);
        for (int i = 1; i < n; i++) {
            int size = result.size();
            for (int j = 0; j < size; ) {
                int k = result.getFirst();
                int count = 0;
                while (j < size && k == result.peekFirst()) {
                    count++;
                    result.pollFirst();
                    j++;
                }
                result.addLast(count);
                result.addLast(k);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Integer i : result)
            builder.append(i);
        return builder.toString();
    }
}
