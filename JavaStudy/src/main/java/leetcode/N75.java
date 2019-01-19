package leetcode;

public class N75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int left = -1, right = nums.length;
        int k = 0;

        while (k < right) {
            if (nums[k] == 1) {
                k++;
            } else if (nums[k] == 0) {
                nums[k++] = nums[++left];
                nums[left] = 0;
            } else {
                nums[k] = nums[--right];
                nums[right] = 2;
            }
        }
    }

    private static void sortArray(int[] arr) {
        if(arr == null || arr.length<2){
            return;
        }
        int left = -1,right = arr.length;
        int k=0;
        while(k<right){
            if(arr[k]==2){
                k++;
            }else if(arr[k] == 1){
                arr[k++] = arr[++left];
                arr[left] = 1;
            }else{
                arr[k] = arr[--right];
                arr[right]=3;
            }
        }
    }


    public static void main(String args[]){

    }
}
