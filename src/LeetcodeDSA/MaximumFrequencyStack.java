package LeetcodeDSA;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq;


    public MaximumFrequencyStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int count = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, count);
        if (count > maxFreq) {
            maxFreq = count;
        }
        freqStack.computeIfAbsent(count, f -> new Stack()).push(val);
    }

    public int pop() {
        Stack<Integer> stack = freqStack.get(maxFreq);
        if (stack.isEmpty()) {
            maxFreq--;
        }
        int element = stack.pop();
        freqMap.put(element, freqMap.get(element) - 1);
        return element;
    }
}
