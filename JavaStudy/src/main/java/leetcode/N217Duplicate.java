package leetcode;

import java.util.BitSet;

public class N217Duplicate {
    public boolean containsDuplicate(int[] nums) {
        BitSet bitSet = new BitSet();
        BitSet bitSet1 = new BitSet();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (bitSet.get(nums[i])) {
                    return true;
                } else {
                    bitSet.set(nums[i]);
                }
            } else {
                int val = Math.abs(nums[i]);
                if (bitSet1.get(val)) {
                    return true;
                }
                bitSet1.set(val);
            }

        }
        return false;
    }
}
