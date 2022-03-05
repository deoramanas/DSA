package LeetcodeDSA;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean ans = containsDuplicate(nums);
        System.out.println(ans);

    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int a : nums) {
            if (set.contains(a)) {
                return true;
            } else {
                set.add(a);
            }
        }
        return false;
    }
}
