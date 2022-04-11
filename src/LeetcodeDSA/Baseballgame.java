package LeetcodeDSA;

import java.util.Stack;

public class Baseballgame {
    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        int calPoints = calPoints(ops);
        System.out.println(calPoints);
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
       // Stack<Integer> stack1 = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("C")) {
             //   stack1.add(stack.pop());
                stack.pop();
            } else if (s.equals("D")) {
                Integer peek = stack.peek();
              //  Integer pop = stack1.pop();
                stack.add(peek * 2);
            } else if (s.equals("+")) {
                Integer a = stack.pop();
                Integer b = stack.peek();
                stack.add(a);
                stack.add(a + b);
            } else {
                stack.add(Integer.valueOf(s));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

}
