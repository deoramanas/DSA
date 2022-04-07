package LeetcodeDSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] kthLargest = findKthFrequent(nums, k);
        for (int i = 0; i < kthLargest.length; i++) {
            System.out.print(kthLargest[i] + " ");
        }
    }

    public static int[] findKthFrequent(int[] nums, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y.value, x.value));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll().key);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
