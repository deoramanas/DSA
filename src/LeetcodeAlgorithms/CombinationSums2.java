package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSums2 {
    public static void main(String[] args) {
        int[] combinations = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> lists = combinationSum(combinations, target);
        System.out.println(lists);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(curr, res, 0, candidates.length, candidates, target);
        return res;
    }

    private static void dfs(List<Integer> curr, List<List<Integer>> res, int start, int end, int[] candidates, int target) {

        if (target == 0) {
            Collections.sort(curr);
            if (!(res.contains(curr))) {
                res.add(new ArrayList<>(curr));
            }

        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < end; i++) {
            //to avoid duplicates
            if(i > start && candidates[i]==candidates[i-1]){
                continue;
            }
            curr.add(candidates[i]);
            dfs(curr, res, i + 1, end, candidates, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
