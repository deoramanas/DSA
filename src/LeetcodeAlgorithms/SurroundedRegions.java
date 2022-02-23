package LeetcodeAlgorithms;

public class SurroundedRegions {
    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'O', 'X', 'X'},
//                {'X', 'O', 'O', 'O'},
//                {'O', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}};
//        char[][] board = {
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'}};

        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}};
//        char[][] board = {
//                {'X', 'O', 'X', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'X'}
//        };
//        char[][] board =
//                {
//                        {'O', 'X', 'X', 'O', 'X'},
//                        {'X', 'O', 'O', 'X', 'O'},
//                        {'X', 'O', 'X', 'O', 'X'},
//                        {'O', 'X', 'O', 'O', 'O'},
//                        {'X', 'X', 'O', 'X', 'O'}
//                };

        solve(board);
    }

    public static void solve(char[][] board) {
        // System.out.println("Making borders inactive");
        makeBordersInactive(board);

        //System.out.println("Reconvert");
        reconvertOriginalBoard(board);

    }

    private static void reconvertOriginalBoard(char[][] board) {

        System.out.println("1");
        printBoard(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println("2");
        printBoard(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }

        printBoard(board);
    }

    public static void dfs(char[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 'X' || grid[x][y] == '1') {
            return;
        } else {
            grid[x][y] = '1';

            dfs(grid, x - 1, y);//up
            dfs(grid, x, y - 1); //left
            dfs(grid, x, y + 1);//right
            dfs(grid, x + 1, y); //down
        }

    }

    private static void makeBordersInactive(char[][] board) {

        int m = board[0].length;
        int n = board.length;
        // first column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

        }

        // last column
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 1);
            }

        }

        // first row
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

        }

        // last row
        for (int i = 0; i < m; i++) {
            if (board[n - 1][i] == 'O') {
                dfs(board, n - 1, i);
            }

        }

    }

    private static void printBoard(char[][] board) {
        System.out.println("Printing board");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
