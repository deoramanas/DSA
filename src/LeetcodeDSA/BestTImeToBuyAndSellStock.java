package LeetcodeDSA;

public class BestTImeToBuyAndSellStock {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {3, 2, 6, 5, 0, 3};
//        int[] prices = {2, 1, 2, 1, 0, 0, 1};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }

    public static int maxProfit(int[] prices) {

        if (prices.length == 1) {
            return 0;
        }
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
        }
        return maxProfit;
    }
}
