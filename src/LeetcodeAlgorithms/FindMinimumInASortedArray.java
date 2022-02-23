package LeetcodeAlgorithms;

public class FindMinimumInASortedArray {
    public static void main(String[] args) {

//        int nums[] = {3, 4, 5, 1, 2};
//        int nums[] = {11, 13, 15, 17};
        int nums[] = {2, 1};
        int min = findMin(nums);

        System.out.println(min);
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[low] <= nums[mid] && nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nums[low];
    }
}
