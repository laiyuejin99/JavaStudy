package leetcode;

public class N70Climbing {
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);
        return left + right;
    }

    public int climbStairs2(int n) {
        //1
        //11,2
        //111,12,21
        //1111,211,121,112,22
        //11111,2111,1211,1121,1112,122,221,212,
        //d(n) = d(n-1)+d(n-2)
        if (n <= 1)
            return 1;
        int oneStep = 1, twoStep = 1, res = 0;

        for (int i = 2; i <= n; i++) {
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new N70Climbing().climbStairs(44));
    }
}
