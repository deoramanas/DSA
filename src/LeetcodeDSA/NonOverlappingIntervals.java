package LeetcodeDSA;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {1, 3}};
        int eraseOverlapIntervals = eraseOverlapIntervals(intervals);
        System.out.println(eraseOverlapIntervals);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd && prevEnd > intervals[i][1]) {
                count++;
                prevEnd = intervals[i][1];
            } else if (prevEnd <= intervals[i][0]) {
                prevEnd = intervals[i][1];
            } else {
                count++;
                continue;
            }
        }
        return count;
    }
}
