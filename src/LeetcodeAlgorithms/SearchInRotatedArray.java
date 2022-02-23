package LeetcodeAlgorithms;

public class SearchInRotatedArray {
    public static void main(String[] args) {
//        int[] nums = {3, 5, 1};
//        int target = 3;
        int[] nums = {3,1};
        int target = 1;

        int search = search1(nums, target);
        System.out.println(search);
    }

    private static int search1(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;

                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

    //not optimized
    public static int search(int[] nums, int target) {
        int pivot = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        int ans = -1;

        int ans1 = binarySearch(nums, 0, pivot, target);
        int ans2 = binarySearch(nums, pivot + 1, nums.length - 1, target);
        if (ans1 == -1) {
            ans = ans2;
        }
        if (ans2 == -1) {
            ans = ans1;
        }
        return ans;
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    high = high - 1;
                } else {
                    low = low + 1;
                }
            }
        }
        return -1;
    }
}
