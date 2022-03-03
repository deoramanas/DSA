package LeetcodeAlgorithms;

import java.util.Arrays;

public class CoinChangeProblem {
    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;
//        int[] coins = {2};
//        int amount = 3;
        int coinChange = coinChange(coins, amount);
        System.out.println(coinChange);
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int currCoin = coins[i];
            for (int j = currCoin; j < dp.length; j++) {
                if (dp[j - currCoin] != -Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - currCoin] + 1);
                }
            }
            printDpArray(dp);

        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

    private static void printDpArray(int[] dp) {
        System.out.println("Printing dp array: ");
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
