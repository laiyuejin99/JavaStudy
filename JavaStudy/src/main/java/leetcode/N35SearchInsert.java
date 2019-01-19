package leetcode;

public class N35SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = -1,end = nums.length;
        int mid = 0;
        while(start+1<end){
            mid = start+(end-start)/2;
            if(nums[mid]<target){
                start = mid;
            }else {
                end = mid;
            }
        }
        return start+1;
    }
}
