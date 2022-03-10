package LeetcodeDSA;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
//        String s = "leetcode";
        String s = "loveleetcode";
        int firstUniqChar = firstUniqChar(s);
        System.out.println(firstUniqChar);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Map<Character, Integer> indexMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            indexMap.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) + 1);
            } else {
                map.put(currentChar, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

//
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            Character key = entry.getKey();
//            Integer value = entry.getValue();
//            if (value == 1) {
//                return indexMap.get(key);
//            }
//        }
        return -1;
    }
}
