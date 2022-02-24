package LeetcodeAlgorithms;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
//        int[] nums = {2, 0, 0};
//        int[] nums = {2, 5, 0, 0};
//        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 0, 8, 2, 0, 0, 1};
//        int[] nums = {1, 2, 3};
        int nums[] = {2, 1, 2, 1, 2, 1};

        boolean ans = canJump(nums);
        System.out.println(ans);
    }

    private static boolean canJump(int[] nums) {

        int goal = nums.length - 1;

        for (int i = nums.length - 1; i >=0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        if (goal == 0) {
            return true;
        }
        return false;
    }

    //Unoptimized
    public static boolean canJump1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        for (int i = 0; i < nums.length; i++) {
            if (dp[dp.length - 1] == true) {
                break;
            }
            int currIndexVal = nums[i];
            if (currIndexVal == 0) {
                int flag = 0;
                for (int j = i + 1; j < dp.length; j++) {
                    if (dp[j] == true) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    continue;
                } else {
                    break;
                }
            }
            if (i + currIndexVal >= nums.length - 1) {
                dp[dp.length - 1] = true;
                break;
            } else {
                dp[i + currIndexVal] = true;
            }
        }
        return dp[dp.length - 1];
    }
}

