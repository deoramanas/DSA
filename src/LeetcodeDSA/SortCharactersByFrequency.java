package LeetcodeDSA;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        String ans = frequencySort(s);
        System.out.println(ans);
    }

    public static String frequencySort(String s) {
        return (frequency(s.toCharArray(), s.length()));
    }

    public static String frequency(char[] nums, int k) {
        PriorityQueue<TopKFrequent.Node> priorityQueue =
                new PriorityQueue<>((x, y) -> Integer.compare(y.value, x.value));
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(Character.valueOf(nums[i]), 0);
            map.put((Character.valueOf(nums[i])), map.get(nums[i]) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.add(new TopKFrequent.Node(entry.getKey(), entry.getValue()));
        }
        StringBuilder res = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            int key = priorityQueue.poll().key;
            int t = map.get((char) key);
            while (t-- > 0) {
                res.append((char) key);
            }
        }

        return res.toString();
    }

    static class Node {
        char key;
        int value;

        public Node(char key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
