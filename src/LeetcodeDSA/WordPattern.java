package LeetcodeDSA;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        // String pattern = "abba", s = "dog cat cat dog";
        String pattern = "abba", s = "dog cat cat dog";

        boolean wordPattern = wordPattern(pattern, s);
        System.out.println(wordPattern);
    }

    public static boolean wordPattern(String pattern, String s) {

        String[] chars = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        Map<String, Boolean> map2 = new HashMap<>();

        if (chars.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i)) && map2.containsKey(chars[i]) == true) {
                return false;
            }
            map.put(pattern.charAt(i), chars[i]);
            map2.put(chars[i], true);
        }

        for (int i = 0; i < chars.length; i++) {
            if (!map.get(pattern.charAt(i)).equals(chars[i])) {
                return false;
            }
        }

        return true;
    }
}
