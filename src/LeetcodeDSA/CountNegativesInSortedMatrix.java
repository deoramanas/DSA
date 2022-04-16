package LeetcodeDSA;

public class CountNegativesInSortedMatrix {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int countNegatives = countNegatives(grid);
        System.out.println(countNegatives);
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] a : grid) {
            int l = 0;
            int h = a.length - 1;

            if (a[l] < 0) {
                count += a.length;
                continue;
            }

            while (l <= h) {
                int m = l + (h - l) / 2;
                if (a[m] < 0) {
                    count = count + (a.length - m);
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return count;
    }
}
