import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations2 {
    public static void main(String[] args) {

        AllPermutations2 permutations2 = new AllPermutations2();
        int[] nums = {1, 2, 3, 4};
        Boolean map[] = new Boolean[nums.length];
        Arrays.fill(map, false);
        List<List<Integer>> allPossibleCombinations = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        permutations2.permuteRecursion(nums, allPossibleCombinations, map, ds);
        System.out.println(allPossibleCombinations);
    }

    private void permuteRecursion(int[] nums, List<List<Integer>> allPossibleCombinations, Boolean[] map, List<Integer> ds) {

        if (ds.size() == nums.length) {
            allPossibleCombinations.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!map[i]) {
                map[i] = true;
                ds.add(nums[i]);
                permuteRecursion(nums, allPossibleCombinations, map, ds);
                ds.remove(ds.size() - 1);
                map[i] = false;
            }
        }
    }
}
