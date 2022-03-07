package LeetcodeDSA;

public class ReshapeTheMatrix {
    public static void main(String[] args) {

        int[][] mat = {{1, 2}, {3, 4}};
        int r = 2;
        int c = 4;

        int[][] matrixReshape = matrixReshape(mat, r, c);
        print(matrixReshape);
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        int[][] res = new int[r][c];
        int n = mat[0].length;
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        return res;
    }

    private static void print(int[][] matrixReshape) {
        System.out.println("Printing: ");
        for (int i = 0; i < matrixReshape.length; i++) {
            for (int j = 0; j < matrixReshape[0].length; j++) {
                System.out.print(matrixReshape[i][j] + " ");
            }
            System.out.println();
        }
    }
}
