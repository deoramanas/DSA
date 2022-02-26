package LeetcodeAlgorithms;

import java.util.Arrays;

public class UniquePaths {
    public static int res = 0;

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        int ans = uniquePaths(m, n);
        System.out.println(ans);
    }

    private static int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m - 1][n - 1];
    }

    //time limit exceeded -dfs
    public static int uniquePaths1(int m, int n) {

        int result = 0;
        int grid[][] = new int[m][n];
        result = dfs(grid, m, n, 0, 0);
        return result / 2;
    }

    private static int dfs(int[][] grid, int m, int n, int x, int y) {

        if (grid[m - 1][n - 1] == 1) {
            return 1;
        }

        if (x < 0 || y < 0 || x >= m || y >= n) {
            return 0;
        }

        if (grid[x][y] == 1) {
            return 0;
        }

        grid[x][y] = 1;
        res = dfs(grid, m, n, x + 1, y) +
                dfs(grid, m, n, x, y + 1);
        grid[x][y] = 0;

        return res;
    }
}