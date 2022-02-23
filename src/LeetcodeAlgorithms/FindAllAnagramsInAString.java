package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramsIndexs = new ArrayList<>();
        int plen = p.length();
        int slen = s.length();
        int[] count = new int[26];
        for (int i = 0; i < plen; i++) {
            count[p.charAt(i) - 97]++;
            count[s.charAt(i) - 97]--;
        }

        if (isMatching(count)) {
            anagramsIndexs.add(0);
        }

        for (int i = plen; i < slen; i++) {
            count[s.charAt(i - plen) - 97]++;
            count[s.charAt(i) - 97]--;
            if (isMatching(count)) {
                anagramsIndexs.add(i - plen + 1);
            }
        }
        return anagramsIndexs;
    }

    private static boolean isMatching(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}