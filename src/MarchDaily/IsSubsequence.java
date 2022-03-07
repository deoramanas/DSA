package MarchDaily;

public class IsSubsequence {
    public static void main(String[] args) {

        String s = "abc", t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        printDp(dp);
        if (dp[dp.length - 1][dp[0].length - 1] == s.length()) {
            return true;
        }

        return false;
    }

    private static void printDp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
