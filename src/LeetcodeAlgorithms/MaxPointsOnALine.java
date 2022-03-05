package LeetcodeAlgorithms;

import java.util.HashMap;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        int points[][] = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int ans = maxPoints(points);
        System.out.println(ans);
    }

    public static int maxPoints(int[][] points) {

        HashMap<Double, Integer> map = new HashMap<>();
        int max = 1;

        for (int i = 1; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int same = 0;
            int currentMax = 1;
            for (int j = 0; j < i; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                double slope = 0d;
                if (x1 == x2 && y1 == y2) {
                    same++;
                    currentMax++;
                    continue;
                } else if (x1 == x2) {
                    slope = Double.MAX_VALUE;
                } else {
                    slope = ((double) (y2 - y1) / (double) (x2 - x1));
                }

                int hits = map.getOrDefault(slope, 1) + 1;
                map.put(slope, hits);
                currentMax = Math.max(currentMax, hits + same);
            }
            max = Math.max(max, currentMax);
            map.clear();
        }
        return max;
    }
}


