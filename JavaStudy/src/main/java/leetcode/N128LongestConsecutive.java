package leetcode;

import java.util.BitSet;
import java.util.Set;

public class N128LongestConsecutive {
    //fail,  precondition all number have to postive
    public int longestConsecutive(int[] nums) {
        BitSet bitSet = new BitSet();
        bitSet.set(-1);
        for (int i = 0; i < nums.length; i++) {
            bitSet.set(nums[i]);
        }
        BitSet visited = new BitSet();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited.get(nums[i])) {
                int count = 1;
                int left = nums[i] + 1;
                while (bitSet.get(left)) {
                    visited.set(left);
                    left++;
                    count++;
                }
                int right = nums[i] - 1;
                while (right >= 0 && bitSet.get(right)) {
                    visited.set(right);
                    right--;
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
