package LeetcodeDSA;

public class FindKthPositive {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int kthPositive = findKthPositive(arr, k);
        System.out.println(kthPositive);
    }

    public static int findKthPositive(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int countMissing = arr[m] - (m + 1);

            if (countMissing >= k) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        int ans = 0;
        if (h < 0) {
            ans = k;
        } else {
            ans = arr[h] + (k - (arr[h] - (h + 1)));
        }
        return ans;
    }
}
