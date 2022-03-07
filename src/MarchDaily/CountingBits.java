package MarchDaily;

public class CountingBits {
    public static void main(String[] args) {
        int n = 15;
        int[] countBits = countBits(n);
        for (int i = 0; i < countBits.length; i++) {
            System.out.print(countBits[i] + " ");
        }
    }

    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        int offset = 1;
        int pow = 1;
        for (int i = 1; i < dp.length; i++) {
            if (i == Math.pow(2, pow)) {
                offset = (int) Math.pow(2, pow);
                pow++;
            }
            dp[i] = dp[i - offset] + 1;
        }

        return dp;
    }
}
