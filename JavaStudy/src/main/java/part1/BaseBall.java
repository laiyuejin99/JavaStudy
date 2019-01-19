package part1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BaseBall {

    public double getScore(String[] scores) {
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < scores.length; i++) {
            String score = scores[i];
            if (score.equals("x")) {
                Double v = stack.pop();
                if (v == null)
                    return 0;
                v = v * 2;
                stack.push(v);
            } else if (score.equals("z")) {
                stack.pop();
            } else if (score.equals("+")) {
                Double v1 = stack.pop();
                Double v2 = stack.pop();
                stack.push(v1 + v2);
            } else {
                Double v = Double.parseDouble(score);
                stack.push(v);
            }
        }
        double res = 0;
        while (stack.pop() != null) {
            res += stack.pop();
        }
        return res;
    }

    public int calPoints(String[] scores) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < scores.length; i++) {
            String score = scores[i];
            if (score.equals("D")) {
                Integer v = stack.peek();
                v = v * 2;
                stack.push(v);
            } else if (score.equals("C")) {
                stack.pop();
            } else if (score.equals("+")) {
                Integer v1 = stack.pop();
                Integer v2 = stack.pop();
                Integer v3 = v1 + v2;
                stack.push(v2);
                stack.push(v1);
                stack.push(v3);
            } else {
                Integer v = Integer.parseInt(score);
                stack.push(v);
            }
        }
        Integer res = 0;
        while (stack.size() != 0) {
            res += stack.pop();
        }
        return res;
    }
}
