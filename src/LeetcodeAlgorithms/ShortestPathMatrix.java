package LeetcodeAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathMatrix {
    public static int val = 0;

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
        int shortestPathBinaryMatrix = shortestPathBinaryMatrix1(grid);
        System.out.println(shortestPathBinaryMatrix);
    }

    private static int shortestPathBinaryMatrix1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }

        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] point = queue.poll();
                if (point[0] == row - 1 && point[1] == col - 1) {
                    return point[2];
                }

                for (int[] d : direction) {
                    int x = point[0] + d[0];
                    int y = point[1] + d[1];

                    if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 0) {
                        queue.add(new int[]
                                {x, y, point[2] + 1});
                        grid[x][y] = 1;
                    }
                }
            }
        }
        return -1;
    }

}
