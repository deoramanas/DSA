package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {
    public static int[] nums;
    private static Random random;

    public static void main(String[] args) {
        nums = new int[]{1, 2, 3};
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(nums);
        int[] shuffle = shuffleAnArray.shuffle();
        print(shuffle);
        shuffleAnArray.reset();
    }

    private static void print(int[] shuffle) {
        for (int i = 0; i < shuffle.length; i++) {
            System.out.print(shuffle[i] + " ");
        }
        System.out.println();
    }

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {

        int a[] = nums.clone();

        for (int i = 0; i < a.length; i++) {
            int ran = random.nextInt(i + 1);

            int temp = a[i];
            a[i] = a[ran];
            a[ran] = temp;
        }

        return a;
    }

    //not optimized
    public void permutations(int[] nums, int i, int j, List<Integer> curr, List<List<Integer>> res) {
        if (i == j) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int k = i; k < j; k++) {
            swap(i, k, curr);
            permutations(nums, i + 1, j, curr, res);
            swap(i, k, curr);
        }
    }

    private static void swap(int i, int j, List<Integer> current) {
        int temp = current.get(i);
        current.set(i, current.get(j));
        current.set(j, temp);
    }

}
