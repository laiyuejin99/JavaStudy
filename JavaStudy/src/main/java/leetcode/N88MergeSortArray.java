package leetcode;

public class N88MergeSortArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int allLength = m + n - 1;
        int n1End = m - 1;
        int n2End = n - 1;
        while (n2End >= 0) {
            if (n1End < 0) {
                nums1[allLength--] = nums2[n2End--];
            } else if (nums1[n1End] > nums2[n2End]) {
                int t = nums1[n1End];
                nums1[n1End--] = 0;
                nums1[allLength--] = t;
            } else {
                nums1[allLength--] = nums2[n2End--];
            }
        }


    }
}
