package LeetcodeDSA;

public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        boolean b = increasingTriplet(nums);
        System.out.println(b);
    }

    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= secondMin) {
                secondMin = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
