package LeetcodeDSA;

import java.util.LinkedList;
import java.util.Queue;

public class FindTriangularSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int triangularSum = triangularSum(nums);
        System.out.println(triangularSum);
    }

    public static int triangularSum(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        queue.add(null);
        while (queue.size() != 2) {

            Integer f = queue.poll();
            Integer s = queue.peek();

            if (f == null) {
                queue.poll();
                queue.add(null);
                continue;
            }
            if (s == null) {
                queue.poll();
                queue.add(null);
                continue;
            }

            queue.offer((f + s) % 10);
        }
        return queue.poll();
    }
}
