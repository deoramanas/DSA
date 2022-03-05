package LeetcodeDSA;

public class MaximumSubarray {
    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    public static int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxCount = 0;
        int currIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (maxSum < currSum) {
                maxSum = currSum;
                maxCount = Math.max(maxCount, i - currIndex);

            }

            if (currSum < 0) {
                currSum = 0;
                currIndex = i + 1;
            }
        }
        System.out.println("Maxsum = " + maxSum);
        return maxCount + 1;
    }
}
