package LeetcodeAlgorithms;

public class HouseRobber2 {
    public static void main(String[] args) {

//        int[] nums = {2, 3, 2};
        int[] nums = {1, 2, 3, 1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < dp2.length; i++) {
            System.out.print(dp2[i] + " ");
        }
        System.out.println();
        return Math.max(dp[dp.length - 2], dp2[dp2.length - 1]);
    }

}
