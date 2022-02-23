package LeetcodeAlgorithms;

public class MaxAreaOfAnIsland {
    static int maxSumSoFar = 0;
    static int val = 0;

    public static void main(String[] args) {
        int[][] grid = {

                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}

        };

        int maxAreaOfIsland = maxAreaOfIsland(grid);
        System.out.println(maxAreaOfIsland);
    }

    public static int maxAreaOfIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    val = maxArea(grid, i, j);
                    if (val > maxSumSoFar) {
                        maxSumSoFar = val;
                    }
                    val = 0;
                }
            }
        }
        return maxSumSoFar;
    }

    private static int maxArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 0;
        }

        if (grid[row][col] == 1) {
            val = val + grid[row][col];
            grid[row][col] = 0;
        }
        maxArea(grid, row - 1, col); //up
        maxArea(grid, row, col - 1); //left
        maxArea(grid, row, col + 1); //right
        maxArea(grid, row + 1, col); //down
        return val;
    }
}
