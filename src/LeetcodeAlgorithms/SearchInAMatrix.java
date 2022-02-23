package LeetcodeAlgorithms;

public class SearchInAMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean ans = searchMatrix1(matrix, 42);
        System.out.println(ans);

    }

    //most optimized
    private static boolean searchMatrix1(int[][] matrix, int target) {
        int low = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid / m][mid % m] == target) {
                return true;
            } else {
                if (matrix[mid / m][mid % m] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int low = 0;
            int high = matrix[i].length - 1;
            if (!(target >= matrix[i][low] && target <= matrix[i][high])) {
                System.out.println("inside");
                continue;
            }
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
        return false;
    }
}
