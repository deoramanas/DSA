package Leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfLastString {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));

    }

    public static int lengthOfLastWord(String s) {
        String[] strings = s.trim().split(" ");
        List<String> stringList = Arrays.stream(strings).filter(s1 -> !s1.equals(" ")).collect(Collectors.toList());
        String lastWord = stringList.get(stringList.size() - 1);
        return lastWord.length();
    }
}
