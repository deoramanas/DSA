package LeetcodeDSA;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] ans = {map.get(target - nums[i]), i};
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

}
