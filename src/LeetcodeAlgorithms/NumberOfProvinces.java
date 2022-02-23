package LeetcodeAlgorithms;

public class NumberOfProvinces {
    public static int val = 0;

    public static void main(String[] args) {

        int[][] grid = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int ans = findCircleNum(grid);
        System.out.println("Ans " + ans);
        System.out.println("Final Answer");
        printarr(grid);

    }

    private static void printarr(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int findCircleNum(int[][] grid) {

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    System.out.println("After DFS call");
                    printarr(grid);

                    ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(int[][] grid, int row, int col) {
        grid[row][col] = 2;

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[col][i] == 1) {
                dfs(grid, col, i);
            }
        }
    }

}
