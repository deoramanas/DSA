package LeetcodeAlgorithms;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        //  rotateArray.rotate(nums, 3);
        rotateArray.rotateUsingDoubleSpace(nums, k);
        // print(nums);
    }

    private void rotateUsingDoubleSpace(int[] nums, int k) {
        int[] res = new int[2 * nums.length];
        int ind = 0;
        k = k % nums.length;
        for (int i = 0; i < res.length; i++) {
            res[ind++] = nums[i % nums.length];
        }
        print(res);
        int d = nums.length - k;
        System.out.println("Rotated array is: ");
        for (int i = d; i < d + nums.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] A, int start, int end) {

        while (start <= end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
