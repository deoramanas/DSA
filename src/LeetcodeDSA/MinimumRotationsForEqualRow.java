package LeetcodeDSA;

public class MinimumRotationsForEqualRow {
    public static void main(String[] args) {
        int[] top = {2, 1, 2, 4, 2, 2};
        int[] bottom = {5, 2, 6, 2, 3, 2};
        int ans = minDominoRotations(top, bottom);
        System.out.println(ans);
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        int nums1 = tops[0];
        int nums2 = bottoms[0];
        for (int i = 0; i < tops.length; i++) {
            if (count1 != Integer.MAX_VALUE) {
                if (tops[i] == nums1) {

                } else if (bottoms[i] == nums1) {
                    count1++;
                } else {
                    count1 = Integer.MAX_VALUE;
                }
            }

            if (count2 != Integer.MAX_VALUE) {
                if (bottoms[i] == nums1) {

                } else if (tops[i] == nums1) {
                    count2++;
                } else {
                    count2 = Integer.MAX_VALUE;
                }
            }

            if (count3 != Integer.MAX_VALUE) {
                if (tops[i] == nums2) {

                } else if (bottoms[i] == nums2) {
                    count3++;
                } else {
                    count3 = Integer.MAX_VALUE;
                }
            }

            if (count4 != Integer.MAX_VALUE) {
                if (bottoms[i] == nums2) {

                } else if (tops[i] == nums2) {
                    count4++;
                } else {
                    count4 = Integer.MAX_VALUE;
                }
            }
        }

        int res = Math.min(Math.min(count1, count2), Math.min(count3, count4));
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
