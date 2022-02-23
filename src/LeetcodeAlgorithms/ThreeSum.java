package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;

        Arrays.sort(nums);

        List<List<Integer>> lists = threeSum1(nums, target);
        System.out.println(lists);
//        List<Integer> ans = twoSum(nums, 0, target);
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.print(ans.get(i) + " ");
//        }
    }

    private static List<List<Integer>> threeSum1(int[] nums, int target) {

        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Set<List<Integer>> answers = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    answers.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(answers);
    }

    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            int curr = nums[i];
            int newTarget = target - curr;
            List<List<Integer>> twoSumList = twoSum(nums, i + 1, newTarget);
            for (int j = 0; j < twoSumList.size(); j++) {
                List<Integer> list = twoSumList.get(j);
                List<Integer> newList = new ArrayList<>(list);
                newList.add(curr);
                Collections.sort(newList);
                if (!answers.contains(newList)) {
                    answers.add(newList);
                }

            }
        }

        return answers;
    }

    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                pairs.add(List.of(target - nums[i], nums[i]));
            } else {
                map.put(nums[i], i);
            }
        }
        return pairs;
    }
}
