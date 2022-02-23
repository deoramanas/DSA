package Leetcode;

public class Matrix01 {
    public static void main(String[] args) {
        int matrix[][] = {
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        };
        System.out.println("Original matrix is : ");
        printMatrix(matrix);
        System.out.println("Computing using DFS: ");
        // int[][] ansUsingDFS = updateMatrixDFS(matrix);

        System.out.println("DP solution: ");
        int[][] ansUsingDFS = updateMatrix(matrix);
        printMatrix(ansUsingDFS);
    }

    private static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        int range = m * n;
//

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    int upCell = (i > 0) ? result[i - 1][j] : range;
                    int leftCell = (j > 0) ? result[i][j - 1] : range;
                    result[i][j] = Math.min(upCell, leftCell) + 1;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    int downCell = (i < matrix.length - 1) ? result[i + 1][j] : range;
                    int rightCell = (j < matrix[0].length - 1) ? result[i][j + 1] : range;
                    result[i][j] = Math.min(Math.min(downCell, rightCell) + 1, result[i][j]);
//                    result[i][j] = Math.min(((j < n - 1) || (i < m - 1)) ? Math.min(result[i + 1][j], result[i][j + 1]) + 1 : range, result[i][j]);
                }
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] updateMatrixDFS(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    result[i][j] = dfs(matrix, i, j, visited);
                }
            }
        }
        return result;
    }

    private static int dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j]) {
            return Integer.MAX_VALUE;
        }

        if (matrix[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        int val = 1 + Math.min(Math.min(dfs(matrix, i, j - 1, visited), dfs(matrix, i, j + 1, visited)),
                Math.min(dfs(matrix, i + 1, j, visited), dfs(matrix, i - 1, j, visited)));
        visited[i][j] = false;

        return val;
    }
}
