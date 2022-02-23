package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] combinations = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> lists = combinationSum(combinations, target);
        System.out.println(lists);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(curr, res, 0, candidates.length, candidates, target);
        return res;
    }

    private static void dfs(List<Integer> curr, List<List<Integer>> res, int start, int end, int[] candidates, int target) {

        if (target == 0) {
            res.add(new ArrayList<>(curr));
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < end; i++) {
            curr.add(candidates[i]);
            dfs(curr, res, i, end, candidates, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
