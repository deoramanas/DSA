package LeetcodeDSA;

import java.util.Stack;

public class ScoreOfParanthesis {
    public static void main(String[] args) {
        String s = "(()(()))";
        int scoreOfParentheses = scoreOfParentheses(s);
        System.out.println(scoreOfParentheses);
    }

    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int pop = 0;
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                while (stack.peek() != 0) {
                    pop += stack.pop();
                }
                pop = Math.max(2 * pop, 1);
                stack.pop();
                stack.push(pop);
            }
        }

        int count = 0;
        while (!stack.isEmpty()) {
            count += stack.pop();
        }

        return count;
    }
}
