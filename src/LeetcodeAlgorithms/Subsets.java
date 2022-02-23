package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findSubsets(nums, 0, res, curr);

        res = res.stream().distinct().collect(Collectors.toList());
        return res;
    }

    private static void findSubsets(int[] nums, int start, List<List<Integer>> res, List<Integer> curr) {

        res.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            findSubsets(nums, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
