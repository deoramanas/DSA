package LeetcodeAlgorithms;

public class IntegerBreak {
    public static void main(String[] args) {
        int n = 2;
        int integerBreak = integerBreak(n);
        System.out.println("integerBreak = " + integerBreak);
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                int curr = j;
                int backward = i - j;

                dp[i] = Math.max(dp[i], Math.max(curr, dp[curr]) * Math.max(backward, dp[backward]));
            }
        }

        printDpArray(dp);
        return dp[dp.length - 1];
    }

    private static void printDpArray(int[] dp) {
        System.out.println("Printing dp array ");
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
