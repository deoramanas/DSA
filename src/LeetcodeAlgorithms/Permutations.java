package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            current.add(nums[i]);
        }
        permute(subsets, current, 0, nums.length);
        return subsets;
    }

    private static void permute(List<List<Integer>> subsets, List<Integer> current, int l, int r) {
        if (l == r) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        for (int i = l; i < r; i++) {
            swap(l, i, current);
            permute(subsets, current, l+1 , r);
            swap(l, i, current);
        }
    }

    private static void swap(int i, int j, List<Integer> current) {
        int temp = current.get(i);
        current.set(i, current.get(j));
        current.set(j, temp);
    }

}
