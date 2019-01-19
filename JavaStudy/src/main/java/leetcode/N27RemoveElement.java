package leetcode;

public class N27RemoveElement {
    //    Given nums = [3,2,2,3], val = 3,
//[1] 1
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
