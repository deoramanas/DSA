package LeetcodeAlgorithms;

public class EditDistance {
    public static void main(String[] args) {

        String word1 = "horse", word2 = "ros";

        int minDistance = minDistance(word1, word2);
        System.out.println(minDistance);
    }

    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m-1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int insert = 1 + dp[i][j + 1];
                    int delete = 1 + dp[i + 1][j];
                    int update = 1 + dp[i][j];
                    dp[i + 1][j + 1] = Math.min(insert, Math.min(delete, update));
                }
            }

        }

        return dp[m][n];
    }

    //recursive
    private static int editDistance(String word1, String word2, int[][] dp, int i, int j) {
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = editDistance(word1, word2, dp, i + 1, j + 1);
            return dp[i][j];
        } else {
            int insert = 1 + editDistance(word1, word2, dp, i, j + 1); //insert
            int remove = 1 + editDistance(word1, word2, dp, i + 1, j);//remove
            int update = 1 + editDistance(word1, word2, dp, i + 1, j + 1); //replace
            dp[i][j] = Math.min(insert, Math.min(remove, update));
            return dp[i][j];
        }

    }
}
