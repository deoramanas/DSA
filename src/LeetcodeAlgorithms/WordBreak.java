package LeetcodeAlgorithms;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = List.of("leet", "code");

        String s = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");

        boolean ans = wordBreak(s, wordDict);
        System.out.println("ans = " + ans);

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        HashSet<String> set = new HashSet<>();

        for (String str : wordDict) { //add words of dic to set
            set.add(str);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String newStr = s.substring(j, i + 1);
                if (set.contains(newStr)) {
                    if (j > 0) {
                        dp[i] += dp[j - 1];
                    }else {
                        dp[i] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[dp.length - 1] > 0;
    }
}
