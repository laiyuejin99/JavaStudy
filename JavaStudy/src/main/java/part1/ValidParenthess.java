package part1;

import java.util.Stack;

public class ValidParenthess {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '}') {
                if (stack.size() == 0) return false;
                char v = stack.pop();
                if (v != '{') return false;

            } else if (chars[i] == ')') {
                if (stack.size() == 0) return false;
                char v = stack.pop();
                if (v != '(') return false;
            } else if (chars[i] == ']') {
                if (stack.size() == 0) return false;
                char v = stack.pop();
                if (v != '[') return false;
            } else {
                stack.push(chars[i]);
            }
        }
        if (stack.size() == 0)
            return true;
        return false;
    }
}
