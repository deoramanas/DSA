package LeetcodeAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int matrix[][] = {
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };
        System.out.println("Original matrix is : ");
        printMatrix(matrix);

        System.out.println("DP solution: ");
        int ans = orangesRotting(matrix);
        System.out.println(ans);
    }

    private static int orangesRotting(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int totalOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (matrix[i][j] != 0) {
                    totalOranges++;
                }
            }
        }

        int rottenOranges = 0;
        int days = 0;

        if (totalOranges == 0) {
            return 0;
        }

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int size = queue.size();
            rottenOranges = rottenOranges + size;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] == 2 || matrix[x][y] == 0) {
                        continue;
                    }
                    matrix[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }

            if (queue.size() != 0) {
                days++;
            }
        }

        printMatrix(matrix);
        return rottenOranges == totalOranges ? days : -1;
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

}
