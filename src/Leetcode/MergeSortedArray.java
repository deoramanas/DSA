package Leetcode;

public class MergeSortedArray {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;

        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;

        merge(nums1, m, nums2, n);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i] + " ");
        }
        System.out.println();

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int end1 = m - 1;
        int end2 = n - 1;
        int i = nums1.length - 1;
        while (end2 >= 0 && end1 >= 0) {

            if (nums1[end1] > nums2[end2]) {
                nums1[i] = nums1[end1];
                end1--;
            } else {
                nums1[i] = nums2[end2];
                end2--;
            }
            i--;
        }

        while (end2 >= 0) {
            nums1[i--] = nums2[end2--];
        }
    }
}
