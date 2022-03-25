package LeetcodeDSA;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {0, 4, 0};
        // int[] nums = {-1, 1, 0, -3, 3};
        // int[] nums = {1, 2, 3, 4};
        int[] productExceptSelf = productExceptSelf(nums);
        for (int i = 0; i < productExceptSelf.length; i++) {
            System.out.print(productExceptSelf[i] + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int count = 0;
        boolean isZeroPresent = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                isZeroPresent = true;
                count++;
            }
        }

        if (count > 1) {
            return new int[nums.length];
        }

        for (int i = 0; i < nums.length; i++) {
            if (isZeroPresent) {
                if (nums[i] != 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = product;
                }
            } else {
                nums[i] = product / nums[i];
            }
        }


        return nums;
    }
}
