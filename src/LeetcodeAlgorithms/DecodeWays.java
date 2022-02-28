package LeetcodeAlgorithms;

public class DecodeWays {
    public static void main(String[] args) {

        String s = "10";
        int ans = numDecodings(s);
        System.out.println(ans);
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0') {  //00
                dp[i] = 0;
            } else if (s.charAt(i - 1) != '0' && s.charAt(i) == '0') { //50
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else if (s.charAt(i - 1) == '0' && s.charAt(i) != '0') { //05
                dp[i] = dp[i - 1];
            } else {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) { //15
                    dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[dp.length - 1];
    }
}
