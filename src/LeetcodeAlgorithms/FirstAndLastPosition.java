package LeetcodeAlgorithms;

// Leetcode -34
public class FirstAndLastPosition {
    public static void main(String[] args) {
        // int nums[] = {5, 7, 7, 8, 8, 10};
        // int[] ans = searchRange(nums, 8);
        int nums[] = {2, 2, 2};
        int[] ans = searchRange(nums, 2);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + " ");
        }
        System.out.println();
    }

    public static int[] searchRange(int[] nums, int target) {


        int[] ans = {-1, -1};

        int l = 0;
        int h = nums.length - 1;
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] == target) {
                ans[0] = m;
                h = m - 1;
            } else if (nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }


        l = 0;
        h = nums.length - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] == target) {
                ans[1] = m;
                l = m + 1;
            } else if (nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
