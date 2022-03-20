package LeetcodeDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {9, 18}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[0].length; j++) {
                System.out.print(merge[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int j = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] point = res.get(j);

            if (intervals[i][0] <= point[1]) {
                point[1] = Math.max(intervals[i][1], point[1]);
            } else {
                res.add(intervals[i]);
                j++;
            }
        }

        int[][] arr = new int[j + 1][2];
        for (int i = 0; i < j + 1; i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
