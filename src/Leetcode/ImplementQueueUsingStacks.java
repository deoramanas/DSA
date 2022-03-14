package Leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(4);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}

class MyQueue {
    private static Stack<Integer> stack;
    private static Stack<Integer> stack2;

    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        return stack2.isEmpty() ? -1 : stack2.peek();
    }

    public boolean empty() {
        if (stack.empty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }
}
