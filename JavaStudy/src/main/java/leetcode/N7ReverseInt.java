package leetcode;

public class N7ReverseInt {
    public int reverse(int x) {
        int res = 0;
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        while (x > 0) {
            if (res > 1000000000)
                return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (flag) res = -res;
        return res;
    }

    public static void main(String arts[]) {
        System.out.println(new N7ReverseInt().reverse(-123));
    }
}
