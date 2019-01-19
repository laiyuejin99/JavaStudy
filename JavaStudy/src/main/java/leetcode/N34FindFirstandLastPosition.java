package leetcode;

public class N34FindFirstandLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first, last;

        //find last;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + ((ub - lb) >> 1);
            if (nums[mid] <= target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }
        if (lb >= 0 && nums[lb] == target) {
            last = lb;
        } else {
            return new int[]{-1, -1};
        }

        lb = -1;
        ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + ((ub - lb) >> 1);
            if (nums[mid] >= target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }
        if (ub < nums.length && nums[ub] == target) {
            first = ub;
        } else {
            return new int[]{-1, -1};
        }
        return new int[]{first, last};
    }
}
