package LeetcodeDSA;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 2};
        // int[] stones = {2, 7, 4, 1, 8, 1};
        int lastStoneWeight = lastStoneWeight(stones);
        System.out.println(lastStoneWeight);
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                break;
            }

            int x = queue.poll();
            int y = queue.poll();
            if (x == y) {

            } else if (x > y) {
                queue.offer(x - y);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
