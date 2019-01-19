package leetcode;

public class N5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        char[] str = s.toCharArray();
        int max = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = lengthOfPal(str, i, i);
            if (i - val > max) {
                start = val;
                end = i + i - val;
                max = i - val;
            }
            val = lengthOfPal(str, i, i + 1);
            if (i - val >= max) {
                start = val;
                end = i + 1 + i - val;
                max = i - val;
            }
        }
        System.out.print(start);
        return s.substring(start, end + 1);
    }

    public int lengthOfPal(char[] s, int left, int right) {
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            System.out.println("left = " + s[left] + " right = " + s[right]);
            System.out.println("left = " + left + " right = " + right);
            left--;
            right++;
        }
        if (left >= 0 && right < s.length && s[left] == s[right]) {
            return left;
        }

        return ++left;
    }

    public static void main(String args[]) {
        System.out.println(new N5LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
