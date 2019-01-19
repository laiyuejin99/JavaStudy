package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N32LongestParentheses {
    public int longestValidParentheses(String s) {

        List<int[]> data = new ArrayList<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int startIndex = 0;
        int count = 0;
        //start to back
        for (int i = 0; i < chars.length; i++) {
            count = chars[i] == '(' ? count + 1 : count - 1;
            if (count < 0) {
                startIndex = i + 1;
                count = 0;
            }
            if (count == 0) {
                max = Math.max(max, i - startIndex + 1);
            }
        }
        //back to start
        startIndex = chars.length - 1;
        count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            count = chars[i] == ')' ? count + 1 : count - 1;
            if (count < 0) {
                startIndex = i - 1;
                count = 0;
            }
            if (count == 0) {
                max = Math.max(max, startIndex - i + 1);
            }
        }
        return max;
    }


    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
