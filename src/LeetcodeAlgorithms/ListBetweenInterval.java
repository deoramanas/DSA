package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class ListBetweenInterval {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] intervalIntersection = intervalIntersection(firstList, secondList);
        for (int i = 0; i < intervalIntersection.length; i++) {
            for (int j = 0; j < intervalIntersection[0].length; j++) {
                System.out.print(intervalIntersection[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int[0][0];
        }

        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int max = Math.max(firstList[i][0], secondList[j][0]);
            int min = Math.min(firstList[i][1], secondList[j][1]);
            if (max <= min) {
                res.add(new int[]{max, min});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] result = new int[res.size()][2];
        for (i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
