package LeetcodeDSA;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        // int nums[] = {1, 1, 1};
        int nums[] = {1, 2, 3};
        int k = 3;

        int count = subarraySum(nums, k);
        System.out.println(count);
    }

    public static int subarraySum(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int num = nums[0];
        int same = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                same++;
            }
            curSum += nums[i];

            if (curSum == k) {
                start = 0;
                end = i;
                count++;
            }

            if (map.containsKey(curSum - k)) {
                start = map.get(curSum - k) + 1;
                end = i;
                count++;
            }

            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        int len = nums.length;
        if (same == len) {
            return len * (len + 1) / 2;
        }
        return count;
    }
}
