package leetcode;

import java.util.Stack;

public class N20ValidParentness {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return false;
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        char c[] = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (c[i] == '{' || c[i] == '[' || c[i] == '(') {
                stack.push(c[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (c[i] == '}') {
                    if (temp != '{')
                        return false;
                } else if (c[i] == ')') {
                    if (temp != '(')
                        return false;
                } else {
                    if (temp != '[')
                        return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
