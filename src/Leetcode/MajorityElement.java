package Leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
//        int ans = majorityElement(nums);
        int ans = majorityElementOptimized(nums);
        System.out.println(ans);
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Map.Entry<Integer, Integer> maxEntry = Collections.max(map.entrySet(), Comparator.comparing(Map.Entry::getValue));
        return maxEntry.getKey();
    }

    // 2 2 1 1 1 2 2

    //Moore's algo
    public static int majorityElementOptimized(int[] nums) {

        int maxFrequenceySoFarIndex = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxFrequenceySoFarIndex] == nums[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maxFrequenceySoFarIndex = i;
                count = 1;
            }
        }

        int reps = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxFrequenceySoFarIndex] == nums[i]) {
                ans = nums[maxFrequenceySoFarIndex];
                reps++;
            }
        }

        if (reps > nums.length / 2) {
            return ans;
        }
        return ans;
    }
}
