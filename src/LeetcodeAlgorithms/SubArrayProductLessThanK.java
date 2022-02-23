package LeetcodeAlgorithms;

public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 1;

        int ans = numSubarrayProductLessThanK(nums, k);
        System.out.println(ans);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int target) {
        int start = 0;
        int end = 0;
        int count = 0;
        int product = 1;

        while (end < nums.length) {
            product *= nums[end];
            while (product >= target) {
                if (start > end) {
                    break;
                }
                product = product / nums[start];
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count;
    }
}
