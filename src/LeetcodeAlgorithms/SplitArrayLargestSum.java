package LeetcodeAlgorithms;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] a = {7, 2, 5, 10, 8};
        int m = 2;
        int splitArray = splitArray(a, m);
        System.out.println(splitArray);
    }

    public static int splitArray(int[] nums, int m) {

        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        if (m == nums.length) {
            return max;
        }
        int low = max;
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] nums, int mid, int m) {

        int sa = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                sa++;
                sum = nums[i];
            }
        }

        return sa <= m;
    }
}
