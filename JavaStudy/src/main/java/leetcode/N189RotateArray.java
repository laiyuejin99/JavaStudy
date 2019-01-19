package leetcode;

public class N189RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null) return;
        k = k%nums.length;
        //rotate last
        rotateSegmentArray(nums, nums.length - k, nums.length - 1);
        //rotate first
        rotateSegmentArray(nums, 0, nums.length - k - 1);
        //rotate all
        rotateSegmentArray(nums, 0, nums.length - 1);
        return;
    }

    public void rotateSegmentArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
