package LeetcodeAlgorithms;

public class HouseRobber {
    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 4};
        //dp = { 2, 2 ,3, 4};
        // f(n) = max(f(n-2)+arr[n],f[n-1]);

//        int ans = robRecursion(nums, nums.length - 1);
        int ans = robMO(nums);
        System.out.println(ans);

    }

    private static int robRecursion(int[] nums, int end) {
        if (end == 0) {
            return nums[0];
        }

        if (end == 1) {
            return Math.max(nums[end - 1], nums[end]);
        }

        int max = Math.max(robRecursion(nums, end - 2) + nums[end], robRecursion(nums, end - 1));
        return max;
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return nums[nums.length - 1];
    }

    //best
    public static int robMO(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int prev1 = 0;
        int prev2 = 0;

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }


}
