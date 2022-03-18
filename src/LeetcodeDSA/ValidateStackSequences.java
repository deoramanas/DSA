package LeetcodeDSA;

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5}, popped = {4, 5, 3, 2, 1};

        boolean b = validateStackSequences(pushed, popped);
        System.out.println(b);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int start1 = 0;
        int start2 = 0;
        int n = pushed.length;

        while (start1 < n && start2 < n) {

            if (!stack.isEmpty() && popped[start2] == stack.peek()) {
                stack.pop();
                start2++;
            } else {
                stack.push(pushed[start1]);
                start1++;
            }
        }

        while (!stack.isEmpty()) {
            if (popped[start2] == stack.pop()) {
                start2++;
            } else {
                return false;
            }
        }

        return true;
    }
}
