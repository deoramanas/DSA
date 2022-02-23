package Leetcode;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "()";
        boolean isValid = isValid(s);
        System.out.println(isValid);
    }

    public static boolean isValid(String s) {
        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length; i++) {

            if (brackets[i] == '(' || brackets[i] == '[' || brackets[i] == '{') {
                stack.push(brackets[i]);
                continue;
            } else if (stack.isEmpty()) {
                return false;
            } else if (!(isMatchingParanthesis(stack.peek(), brackets[i]))) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingParanthesis(char currentBracket, char brackets) {
        return (currentBracket == '(' && brackets == ')') || (currentBracket == '[' && brackets == ']')
                || (currentBracket == '{' && brackets == '}');
    }

}



