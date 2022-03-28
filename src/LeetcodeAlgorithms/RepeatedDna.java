package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDna {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> repeatedDnaSequences = findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);
    }

    public static List<String> findRepeatedDnaSequences(String s) {

        Set<String> set = new HashSet<>();
        Set<String> resultset = new HashSet<>();

        int i = 0;
        int j = 9;
        for (int k = 0; k < s.length() - 9; k++) {
            String currentString = s.substring(k, j + 1);
            if (set.contains(currentString)) {
                resultset.add(currentString);
            } else {
                set.add(currentString);
            }
            j++;
        }

        return new ArrayList<>(resultset);
    }
}
