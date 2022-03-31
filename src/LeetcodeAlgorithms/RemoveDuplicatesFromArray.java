package LeetcodeAlgorithms;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4, 2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] *= -1;
        }
        return -1;
    }
}
