package LeetcodeDSA;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length - 1;
        int i, j;
        for (i = n - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            reverse(nums, 0, n);
            return;
        } else {
            for (j = n; j > i; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
        }
        swap(nums, i, j);
        reverse(nums, i + 1, n);
    }



    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
