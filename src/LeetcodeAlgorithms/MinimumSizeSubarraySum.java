package LeetcodeAlgorithms;

import java.util.HashMap;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = {2, 3, 1, 2, 4, 3};

        int target = 11;
        int[] nums = {1, 2, 3, 4, 5};
        int ans = minSubArrayLen1(target, nums);
        System.out.println(ans);

    }

    //using sliding window technique
    private static int minSubArrayLen1(int target, int[] nums) {
        int shortestLengthSoFar = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;

        int len = nums.length;
        int current = 0;
        while (end < len) {
            current = current + nums[end];
            if (current >= target) {
                while (current >= target) {
                    current = current - nums[start];
                    start++;
                }
                shortestLengthSoFar = Math.min(shortestLengthSoFar, end - start + 2);
            }
            end++;
        }
        return shortestLengthSoFar == Integer.MAX_VALUE ? 0 : shortestLengthSoFar;
    }

    //using hashmap
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int minimumLengthSoFar = Integer.MAX_VALUE;
        int end = -1;

        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];

            if (currentSum == target) {
                start = 0;
                end = i;
            }

            if (hmap.containsKey(currentSum - target)) {
                start = hmap.get(currentSum - target) + 1;
                end = i;
                minimumLengthSoFar = Math.min(minimumLengthSoFar, end - start + 1);
            }

            hmap.put(currentSum, i);
        }

        if (end == -1) {
            return 0;
        }

        return minimumLengthSoFar;
    }
}
