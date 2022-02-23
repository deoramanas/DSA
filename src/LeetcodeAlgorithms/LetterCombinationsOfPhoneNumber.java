package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {

        List<String> strings = letterCombinations("32");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String input) {
        if (input.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("2", "abc");
        hashMap.put("3", "def");
        hashMap.put("4", "ghi");
        hashMap.put("5", "jkl");
        hashMap.put("6", "mno");
        hashMap.put("7", "pqrs");
        hashMap.put("8", "tuv");
        hashMap.put("9", "wxyz");

        backtracking(hashMap, input, 0, res, new StringBuilder());

        return res;
    }

    private static void backtracking(HashMap<String, String> hashMap, String input, int i, List<String> res, StringBuilder stringBuilder) {
        if (i == input.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        String current = hashMap.get(String.valueOf(input.charAt(i)));
        for (int j = 0; j < current.length(); j++) {
            stringBuilder.append(current.charAt(j));
            backtracking(hashMap, input, i + 1, res, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
