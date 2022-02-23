public class RemoveElement {
    public static void main(String[] args) {
        //  int arr[] = {3, 2, 2, 3};
//        int arr[] = {0, 1, 2, 2, 3, 0, 4, 2};
        int arr[] = {0, 1, 2, 2, 3, 0, 4, 2};
        int count = removeElement(arr, 2);
        System.out.println(count);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        for (int element : nums) {
            if (element != val) {
                nums[i++] = element;
            }
        }
        return n;
    }

}