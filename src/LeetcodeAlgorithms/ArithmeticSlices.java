package LeetcodeAlgorithms;

public class ArithmeticSlices {
    public static void main(String[] args) {
//        int nums[] = {1, 3, 5, 7, 9};
        int nums[] = {2, 1, 3, 4, 2, 3};
//        int nums[] = {1, 2, 3, 4};
        int ans = numberOfArithmeticSlices(nums);
        System.out.println(ans);

    }

    public static int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }

        int sum = 0;
        int[] dp = new int[nums.length];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = (nums[2] - nums[1]) == (nums[1] - nums[0]) ? dp[1] + 1 : 0;
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
            sum = sum + dp[i];
        }
        return sum;
    }
}
