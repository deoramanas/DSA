package LeetcodeDSA;

public class MergeSortedArray {
    public static void main(String[] args) {
//        int nums1[] = {1, 5, 6, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {3, 4, 7};
//        int n = 3;
//        int nums1[] = {2, 0};
//        int m = 3;
//        int[] nums2 = {1};
//        int n = 3;
        int nums1[] = {0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3, 4, 5};
        int n = 3;
        merge(nums1, m, nums2, n);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1;
        int end2 = n - 1;
        int k = m + n - 1;

        while (end1 < nums1.length && end2 < nums2.length) {
            if (end1 < 0 || end2 < 0) {
                break;
            }
            if (nums1[end1] < nums2[end2]) {
                nums1[k] = nums2[end2];
                k--;
                end2--;
            } else if (nums1[end1] >= nums2[end2]) {
                nums1[k] = nums1[end1];
                k--;
                end1--;
            } else {
            }
        }

        while (k <= end2 && k >= 0 && end2 >= 0) {
            nums1[k] = nums2[end2];
            k--;
            end2--;
        }
    }

}
