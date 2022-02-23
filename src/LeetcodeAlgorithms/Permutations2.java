package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            curr.add(nums[i]);
        }
        dfs(nums, res, curr, 0, nums.length);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, int start, int end) {
        if (start == end) {
            if(!res.contains(curr)){
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = start; i < end; i++) {
            swap(curr, start, i);
            dfs(nums, res, curr, start + 1, end);
            swap(curr, start, i);
        }
    }

    private static void swap(List<Integer> curr, int i, int start) {
        int temp = curr.get(i);
        curr.set(i, curr.get(start));
        curr.set(start, temp);
    }

}
