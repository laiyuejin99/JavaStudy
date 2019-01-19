package leetcode;

public class N69Sqrt {

    public int mySqrt(int x) {
        if (x == 1 || x == 0) return x;
        int start = 0, end = x;
        while (start + 1 < x) {
            int mid = start + (end - start) / 2;
            int r = mid * mid;
            if (r == x || (r < x && (mid + 1) * (mid + 1) > x)) {
                return mid;
            } else if (r > x) {
                end = mid;
            } else if (r < x) {
                start = mid;
            }
        }
        return end - 1;
    }

    public static void main(String args[]) {
        System.out.println(new N69Sqrt().mySqrt(2147395599));
    }


    public int mySqrt2(int x) {
        if (x <= 0) return 0;
        int left = 1, right = x, mid = left + (right - left) / 2;
        while (left <= right) {
            if (mid == x / mid) return mid;
            else {
                if (mid > x / mid) right = mid - 1;
                else left = mid + 1;
                mid = left + (right - left) / 2;
            }
        }
        return right;
    }

}
