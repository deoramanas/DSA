package LeetcodeAlgorithms;

public class BinarySearch {
    public static void main(String[] args) {

        int arr[] = {1,3,5,6};
//        int target = 7;
        int target = 2;
//        int found = search(arr, target);
//        System.out.println(target + " exists in nums and its index is " + found);

        int ans = searchInsert(arr, target);
        System.out.println("Target " + ans);
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;

                }
            }
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else {
                if (target > nums[mid]) {
                    low = mid + 1;
                    ans=low;
                } else {
                    high = mid - 1;
                    ans=mid;
                }
            }
        }
        return ans;
    }
}
