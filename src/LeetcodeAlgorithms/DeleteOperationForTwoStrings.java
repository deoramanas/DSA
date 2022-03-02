package LeetcodeAlgorithms;

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        String word1 = "abcde", word2 = "ace";

        int ans = minDistance(word1, word2);
        System.out.println(ans);
    }

    public static int minDistance(String word1, String word2) {

        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();

        int[][] dp = new int[words1.length + 1][words2.length + 1];

        for (int i = 0; i < words1.length; i++) {
            for (int j = 0; j < words2.length; j++) {
                if (words1[i] == words2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        printList(words1, words2, dp);
        return dp[words1.length][words2.length];
    }

    private static void printList(char[] words1, char[] words2, int[][] dp) {
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
