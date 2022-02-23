package LeetcodeAlgorithms;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int ans = numIslands(grid);
        System.out.println(ans);

        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int numIslands(char[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || grid[x][y] == '2') {
            return;
        }

        if (grid[x][y] == '1') {
            grid[x][y] = '2';
        }

        dfs(grid, x - 1, y);//up
        dfs(grid, x, y - 1); //left
        dfs(grid, x, y + 1);//right
        dfs(grid, x + 1, y); //down
    }
}
