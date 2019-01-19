package leetcode;

public class N643MaximumAverage {
    public double findMaxAverage(int[] nums, int k) {

        int kSum = 0;
        for (int i = 0; i < k; i++) {
            kSum += nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k; i++) {
            kSum += nums[i + k] - nums[i];
            max = Math.max(kSum, max);
        }
        return (double)max / k;
    }
}
