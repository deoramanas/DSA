package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationBetweenStrings {
    public static void main(String[] args) {
//        String s1 = "ab";
//        String s2 = "a";

        String s1 = "abc";
        String s2 = "eidbacooo";

//        System.out.println(checkInclusionUnoptimized(s1, s2));
        System.out.println(checkInclusion(s1, s2));

    }

    private static boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] count1 = new int[26];
        Arrays.fill(count1, 0);

        //populate count1 based on s1
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count1[s2.charAt(i) - 'a']--;
        }

        if (foundPermutation(count1)) {
            return true;
        }

        //slide
        for (int i = len1; i < len2 - len1; i++) {
            count1[s2.charAt(i) - 'a']--;
            count1[s2.charAt(i - len1) - 'a']++;
            if (foundPermutation(count1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean foundPermutation(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusionUnoptimized(String s1, String s2) {

//        if (s1.length() > s2.length()) {
//            List<String> p2 = permute(s2, 0, s2.length(), new ArrayList<>());
//            for (int i = 0; i < p2.size(); i++) {
//                if (s1.contains(p2.get(i))) {
//                    return true;
//                }
//            }
//        } else {
//
//        }

        List<String> p1 = permute(s1, 0, s1.length(), new ArrayList<>());
        for (int i = 0; i < p1.size(); i++) {
            if (s2.contains(p1.get(i))) {
                return true;
            }
        }

        return false;
    }

    private static List<String> permute(String s, int l, int r, List<String> perms) {

        if (l == r) {
            //  System.out.println(s);
            perms.add(s);
        }

        for (int i = l; i < r; i++) {
            s = swap(s, l, i);
            permute(s, l + 1, r, perms);
            //backtracking
            s = swap(s, l, i);
        }
        return perms;
    }

    private static String swap(String s, int l, int i) {

        StringBuilder stringBuilder = new StringBuilder(s);
        char c = stringBuilder.charAt(i);
        stringBuilder.setCharAt(i, s.charAt(l));
        stringBuilder.setCharAt(l, c);

        return stringBuilder.toString();
    }

}
