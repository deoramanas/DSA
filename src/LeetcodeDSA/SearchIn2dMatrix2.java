package LeetcodeDSA;

public class SearchIn2dMatrix2 {
    public static void main(String[] args) {
        int matrix[][] = {{-1}, {-1}};
        boolean ans = searchMatrix(matrix, -2);
        System.out.println(ans);

    }

    // most optimized
    private static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int low = 0;
            int high = matrix[i].length - 1;



            if ((target >= matrix[i][low] && target <= matrix[i][high])) {
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else {
                        if (target > matrix[i][mid]) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                }
            }
        }


        int l = 0;
        int h = matrix.length - 1;

        for (int i = 0; i < matrix[0].length; i++) {
            if (target >= matrix[l][i] && target <= matrix[h][i]) {
                while (l <= h) {
                    int mid = l + (h - l) / 2;
                    if (matrix[mid][i] == target) {
                        return true;
                    } else {
                        if (target > matrix[mid][i]) {
                            l = mid + 1;
                        } else {
                            h = mid - 1;
                        }
                    }
                }
            }
        }
        return false;
    }



}
