package LeetcodeDSA;

public class SpiralMatrix2 {
    public static void main(String[] args) {

        int n = 9;
        int[][] matrix = generateMatrix(n);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int k = 1;
        int top = 0;
        int right = 0;
        int down = n - 1;
        int left = n - 1;

        boolean right1 = false;
        boolean down1 = false;
        boolean left1 = false;
        boolean up1 = false;

        int row = 0;
        int col = 0;

        right1 = true;
        while (k <= n * n) {

            if (top < 0 || top > n || down < 0 || down > n || left < 0 || left > n || right < 0
                    || right > n) {
                break;
            }
            if (right1) {
                for (int i = right; i <= down; i++) {
                    matrix[right][i] = k++;
                }
                right1 = false;
                left1 = false;
                up1 = false;
                down1 = true;
                right++;
            }

            if (down1) {
                for (int i = right; i <= left; i++) {
                    matrix[i][down] = k++;
                }
                right1 = false;
                left1 = true;
                up1 = false;
                down1 = false;
                down--;

            }

            if (left1) {
                for (int i = down; i >= top; i--) {
                    matrix[left][i] = k++;
                }
                right1 = false;
                left1 = false;
                up1 = true;
                down1 = false;
                left--;
            }

            if (up1) {
                for (int i = left; i >= right; i--) {
                    matrix[i][top] = k++;
                }

                right1 = true;
                left1 = false;
                up1 = false;
                down1 = false;
                top++;
            }

        }

        return matrix;

    }
}
