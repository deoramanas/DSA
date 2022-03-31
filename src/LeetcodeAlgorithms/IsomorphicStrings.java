package LeetcodeAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String a = "egg";
        String b = "add";
        boolean isomorphic = isIsomorphic(a, b);
        System.out.println(isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    if (t.charAt(i) != (map.get(s.charAt(i)))) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < t.length(); i++) {
                if (!map2.containsKey(t.charAt(i))) {
                    map2.put(t.charAt(i), s.charAt(i));
                } else {
                    if (s.charAt(i) != (map2.get(t.charAt(i)))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
