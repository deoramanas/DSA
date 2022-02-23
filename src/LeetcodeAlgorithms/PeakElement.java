package LeetcodeAlgorithms;

public class PeakElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
//        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int peakElement = findPeakElement1(nums);
        System.out.println(peakElement);
    }

    private static int findPeakElement1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid+1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
