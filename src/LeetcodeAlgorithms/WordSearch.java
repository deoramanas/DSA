package LeetcodeAlgorithms;

public class WordSearch {
    public static boolean visited[][];

    public static void main(String[] args) {
        char[][] board = {{'a'}};
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String target = "ABCCED";
        String target = "a";
        boolean exist = exist(board, target);
        System.out.println(exist);
    }

    public static boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int count) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (count == word.length()) {
            return true;
        }
        if (board[i][j] != word.charAt(count)) {
            return false;
        }

        visited[i][j] = true;
        boolean ans = dfs(board, word, i - 1, j, count + 1) //up
                || dfs(board, word, i, j + 1, count + 1) //right
                || dfs(board, word, i, j - 1, count + 1) //left
                || dfs(board, word, i + 1, j, count + 1); //down
        visited[i][j] = false;

        return true;
    }
}
