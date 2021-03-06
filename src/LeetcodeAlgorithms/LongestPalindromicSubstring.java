package LeetcodeAlgorithms;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aaaaa";
        String ans = longestPalindrome2(s);
        System.out.println(ans);
    }

    private static String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1 && s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] && (j - i + 1 > max)) {
                    start = i;
                    end = j;
                    max = Math.max(max, end - start + 1);
                }
            }
        }
        System.out.println(start);
        System.out.println(end);
        System.out.println(max);
        return s.substring(start - 1, end);

    }

    // Using DP
    private static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int start = 0;
        int end = 0;
        int maxSoFar = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = 1; j < s.length(); j++) {

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j]) {
                    if (j - i + 1 > maxSoFar) {
                        start = i;
                        end = j;
                        maxSoFar = Math.max(maxSoFar, end - start + 1);
                    }
                }
            }
        }

        printDpArray(s, dp);

        // for (int i = 0; i < s.length() - 1; i++) {
        // for (int j = 1; j < s.length(); j++) {
        // if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
        // dp[i][j] = true;
        // start = i;
        // end = j;
        // maxSoFar = Math.max(maxSoFar, end - start + 1);
        // }
        // }
        // }

        printDpArray(s, dp);
        return s.substring(start, end + 1);
    }

    private static void printDpArray(String s, boolean[][] dp) {
        System.out.println("Print DP array \n");
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                System.out.print(dp[i][j] + "     ");
            }
            System.out.println();
            System.out.println();
        }
    }

    // expand from centre - time- O(n^2) -sc )(1)
    public static String longestPalindrome1(String s) {

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCentre(s, i, i + 1);
            int len2 = expandFromCentre(s, i, i);
            int len = Math.max(len1, len2);
            if (end - start < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandFromCentre(String s, int i, int j) {

        while (i >= 0 && i < s.length() && j >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

}
