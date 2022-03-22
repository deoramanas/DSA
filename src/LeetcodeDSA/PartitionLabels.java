package LeetcodeDSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        System.out.println(list);
    }

    public static List<Integer> partitionLabels(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> answer = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int j = map.get(s.charAt(i));
            int begin = i;
            while (begin < j) {
                j = Math.max(j, map.get(s.charAt(begin)));
                begin++;
            }
            answer.add(j - i + 1);
            i = begin + 1;
        }

        return answer;
    }
}
