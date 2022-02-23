package LeetcodeAlgorithms;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        int nums[] = {-4, -1, 0, 3, 10};
        nums = squaresOfSortedArray.sortedSquares(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

//    public int[] sortedSquares(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(nums);
//        return nums;
//    }

    public int[] sortedSquares(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            if (Math.abs(nums[low]) >= Math.abs(nums[high])) {
                res[i] = nums[low] * nums[low];
                low++;
            } else {
                res[i] = nums[high] * nums[high];
                high--;
            }
        }
        return res;
    }

}
