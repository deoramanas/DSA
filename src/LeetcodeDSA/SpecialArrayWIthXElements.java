package LeetcodeDSA;

public class SpecialArrayWIthXElements {
    public static void main(String[] args) {
        int[] nums = {0, 4, 0, 3, 4};
        int specialArray = specialArray(nums);
        System.out.println(specialArray);
    }

    public static int specialArray(int[] nums) {
        int n = 1;
        while (n <= nums.length) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= n) {
                    count++;
                }
            }
            if (count == n) {
                return n;
            }
            n++;
        }


        return -1;
    }
}
