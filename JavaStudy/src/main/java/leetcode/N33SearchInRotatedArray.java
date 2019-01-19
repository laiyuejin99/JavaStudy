package leetcode;

public class N33SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = 0, ub = nums.length - 1;


        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[lb]) {
                if (nums[mid] > target && nums[lb] <= target) {
                    ub = mid;
                } else {
                    lb = mid;
                }
            } else {
                if (target < nums[ub] && nums[mid] < target)
                    lb = mid;
                else
                    ub = mid;
            }
        }

        if (nums[lb] == target)
            return lb;
        else if (nums[ub] == target) {
            return ub;
        }
        return -1;
    }

//1 3 5

}
