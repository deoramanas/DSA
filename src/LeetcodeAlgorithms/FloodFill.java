package LeetcodeAlgorithms;

public class FloodFill {
    public static void main(String[] args) {

        int sr = 1;
        int sc = 1;
        int newColor = 1;
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] image = {{0, 0, 0}, {0, 1, 1}, {1, 1, 1}};
        int[][] answer = floodFill(image, sr, sc, newColor);

        printImage(answer);

    }

    private static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int sourceColor = image[sr][sc];
        if (sourceColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, sourceColor, newColor);
        return image;
    }

    public static void dfs(int[][] arr, int sr, int sc, int sourceColor, int newColor) {

        if (sr < 0 || sc >= arr[0].length || sr >= arr.length || sc < 0) {
            return;
        } else if (arr[sr][sc] != sourceColor) {
            return;
        }
        arr[sr][sc] = newColor;

        dfs(arr, sr - 1, sc, sourceColor, newColor); //up
        dfs(arr, sr, sc - 1, sourceColor, newColor); //left
        dfs(arr, sr, sc + 1, sourceColor, newColor); //right
        dfs(arr, sr + 1, sc, sourceColor, newColor); //down
    }
}
