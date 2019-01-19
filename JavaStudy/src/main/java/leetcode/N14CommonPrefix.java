package leetcode;

public class N14CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String args[]) {
        System.out.println("abcd".substring(0, 1));
    }
}
