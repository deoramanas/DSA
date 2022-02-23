package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutations {
    public static void main(String[] args) {
//        String s = "a1b2";
//        String s = "3z4";
        String s = "abc";
        List<String> ans = letterCasePermutation(s);
        System.out.println(ans);
    }

    public static List<String> letterCasePermutation(String s) {
        Set<String> strings = new HashSet<>();

        permute(s.toLowerCase().toCharArray(), 0, s.length(), strings);

        return new ArrayList<>(strings);
    }

    private static void permute(char[] s, int l, int r, Set<String> strings) {
        if (l == r) {
            strings.add(String.valueOf(s));
        } else {
            if (Character.isLetter(s[l])) {
                s[l] = Character.toUpperCase(s[l]);
                permute(s, l + 1, r, strings);
                s[l] = Character.toLowerCase(s[l]);
            }
            permute(s, l + 1, r, strings);
        }
    }

}
