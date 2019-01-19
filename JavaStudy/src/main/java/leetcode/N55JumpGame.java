package leetcode;

public class N55JumpGame {
    //[2,3,1,1,4]
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int maxP = 0;
        for (int i = 0; i < nums.length; i++) {
            maxP = Math.max(maxP, nums[i] + i);
            if (maxP >= nums.length - 1) return true;
            if (nums[i] == 0 && i >= maxP && i != nums.length - 1) {
                return false;
            }
        }
        return maxP >= nums.length - 1 ? true : false;
    }
}
