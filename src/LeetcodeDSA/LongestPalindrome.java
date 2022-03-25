package LeetcodeDSA;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "aaabaaaa";
        int longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }

    public static int longestPalindrome(String s) {
        List<Character> chars = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Map<Character, Long> characterLongMap =
                chars.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(characterLongMap);
        int count = 0;
        boolean isOdd = false;
        boolean isEven = false;

        for (Map.Entry<Character, Long> entry : characterLongMap.entrySet()) {
            Character key = entry.getKey();
            Long value = entry.getValue();
            if (value % 2 == 0) {
                count = (int) (count + value);
                isEven = true;
            } else {
                count = (int) (count + (value - 1) );
                isOdd = true;
            }
        }
        if (isOdd) {
            count++;
        } else {
            return s.length();
        }
        return count;

    }
}
