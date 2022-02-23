package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String strs[] = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i].toLowerCase();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newSortedString = String.valueOf(chars);
            if (!anagramMap.containsKey(newSortedString)) {
                anagramMap.put(newSortedString, new ArrayList<>());
            }
            anagramMap.get(newSortedString).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }

}
