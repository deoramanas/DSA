import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutations {
    public static void main(String[] args) {

        AllPermutations permutationsClass = new AllPermutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> allPossibleCombinations = permutationsClass.permute(nums);
        String str="ARJUN";
        System.out.println(str.substring(3));
        System.out.println(allPossibleCombinations);

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> onePermutation = new ArrayList<>();
        Set<List<Integer>> onePermutationSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            onePermutation.add(nums[i]);
        }
        onePermutationSet.add(onePermutation);

        onePermutationSet = permuation(nums, 0, nums.length, onePermutationSet);

        onePermutationSet.stream().forEach(x -> res.add(x));

        return res;
    }

    public Set<List<Integer>> permuation(int[] nums, int l, int length, Set<List<Integer>> onePermutationSet) {

        if (l == length) {
            List<Integer> onePermutation = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                onePermutation.add(nums[i]);
            }
            onePermutationSet.add(onePermutation);
        }else{
            for (int i = l; i < length; i++) {
                int[] swapped = swap(nums, l, i);
                permuation(nums, l + 1, length, onePermutationSet);
                swapped = swap(nums, l, i);
            }
        }
        return onePermutationSet;
    }

    private int[] swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        return nums;
    }

}
