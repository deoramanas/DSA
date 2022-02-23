package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }

        int len = s.length();
        List<Character> set = new ArrayList<>();
        int maxLengthSoFar = 0;

        //a  b   c   a b c b b

        int l = 0;
        int r = 0;
        while (r < len) {

            if (set.contains(s.charAt(r))) {
                set.remove(0);
                l++;
                continue;

            } else {
                set.add(s.charAt(r));
                r++;
            }

            if (set.size() > maxLengthSoFar) {
                maxLengthSoFar = set.size();
            }
        }
        return maxLengthSoFar;
    }
}
