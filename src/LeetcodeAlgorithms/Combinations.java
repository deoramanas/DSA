package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        List<List<Integer>> ans = combine(n, k);
        System.out.println(ans);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        combine(subsets, current, 1, k, n);
        return subsets;
    }

    private static void combine(List<List<Integer>> subsets, List<Integer> current, int start, int k, int n) {
         if (k == current.size()) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            combine(subsets, current, i + 1, k, n);
            current.remove(current.size() - 1);
        }
    }

}
