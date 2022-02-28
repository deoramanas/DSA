package LeetcodeAlgorithms;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
//        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
//        int nums[] = {0, 1, 0, 3, 2, 3};
        int nums[] = {7, 7, 7, 7, 7};
//        int nums[] = {4, 10, 4, 3, 8, 9};

//        int nums[] = {1, 2, 4, 3, 5, 4, 7, 2};

//        int nums[] = {1, 2, 4, 3, 5, 4, 7, 2};
        //    int nums[] = {0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15, 18, 17, 20, 19, 22, 21, 24, 23, 26, 25, 28, 27, 30, 29, 32, 31, 34, 33, 36, 35, 38, 37, 40, 39, 42, 41, 44, 43, 46, 45, 48, 47, 50, 49, 52, 51, 54, 53, 56, 55, 58, 57, 60, 59, 61};
        int lengthOfLIS = lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }

    public static int lengthOfLIS(int[] nums) {

        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxVal = Math.max(dp[j], maxVal);
                }
            }
            dp[i] = maxVal + 1;
        }

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println("dp = " + Arrays.toString(dp));

        return max;
    }
}
