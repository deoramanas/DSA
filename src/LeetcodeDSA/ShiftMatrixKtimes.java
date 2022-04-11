package LeetcodeDSA;

import java.util.ArrayList;
import java.util.List;

public class ShiftMatrixKtimes {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 9;
        List<List<Integer>> lists = shiftGrid(grid, k);
        System.out.println(lists);
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] res = new int[grid.length][grid[0].length];

        int n = grid.length;
        int m = grid[0].length;
        // k = k%n;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int currIndex = i * n + j;
                int newIndex = (currIndex + k);
                if (newIndex >= n * m) {
                    newIndex = newIndex % (m * n);
                }
                res[newIndex / n][newIndex % n] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            List<Integer> r = new ArrayList<>();
            for (int j = 0; j < res[0].length; j++) {
                r.add(res[i][j]);
            }
            result.add(r);
        }

        return result;
    }
}
