package leetcode;

import java.util.*;

public class N239MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];
            while (!queue.isEmpty() && queue.peekLast() < currentVal) {
                int t = queue.pollLast();
            }

            queue.offer(currentVal);
            if (i > k - 1 && queue.peekFirst() == nums[i - k]) {
                queue.pollFirst();
            }

            if (i >= k - 1) {
                res[index] = queue.peekFirst();
                index++;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] arr = {7, 2, 4};
        int[] res = new N239MaxSlidingWindow().maxSlidingWindow(arr, 2);
    }
}
