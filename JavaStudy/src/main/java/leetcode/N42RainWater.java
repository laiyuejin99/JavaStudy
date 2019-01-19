package leetcode;

public class N42RainWater {
    public int trap(int[] height) {
        int max = 0;
        int maxHeight[] = new int[height.length];
        for (int i = height.length - 1; i >= 0; i--) {
            max = max > height[i] ? max : height[i];
            maxHeight[i] = max;
        }
        int sum = 0;
        max = 0;
        for (int i = 0; i < height.length; i++) {
            max = max > height[i] ? max : height[i];
            sum += Math.min(max, maxHeight[i]) - height[i];
        }
        return sum;
    }
}
