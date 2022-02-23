package Leetcode;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int missingNumber = missingNumber(nums);
        System.out.println(missingNumber);
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = (n * (n + 1) / 2);
        for (int i = 0; i < nums.length; i++) {
            sum1 = sum1 - nums[i];
        }
        System.out.println(sum1);
        return -1;
    }
}
