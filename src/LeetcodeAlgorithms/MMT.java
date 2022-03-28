package LeetcodeAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MMT {
    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();

        map.put("A", Arrays.asList("B", "C"));
        map.put("B", Arrays.asList("E", "F"));
        map.put("E", Arrays.asList("D", "R"));
        map.put("D", Arrays.asList("B"));
        map.put("C", Arrays.asList("P"));

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int n = map.size();
        Map.Entry<String, List<String>> entry = map.entrySet().iterator().next();

        List<String> first = Collections.singletonList(entry.getKey());
        for (int i = 0; i < first.size(); i++) {
            queue.add(first.get(i));
            set.add(first.get(i));
        }

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            List<String> strings = map.get(poll);
            if (strings == null) {
                continue;
            }
            for (int i = 0; i < strings.size(); i++) {
                if (set.contains(strings.get(i))) {
                    System.out.println("\n \n \n Cycle exist\n \n \n");
                    break;
                } else {
                    queue.add(strings.get(i));
                    set.add(strings.get(i));
                }
            }
        }
    }

    //         1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 20 21
    // a [] = Z AU Z Z Z Z RD AI Z RD B G G Z Z H AU AI YY YY -n

    //
    // A B C D A A A A A A A A A A  A A D E F... D E F ....B C A
    //
    // X X C C A Z X X X X C V V V V V V V V V X X X C C C A A A Z X C V
    //
    // X C A Z V V V V V
    //
    // Complexity - O(mn)
    // I = 1, j = 17
    // Z AU Z Z Z Z Z Z Z Z Z Z
    // Z Z Z Z Z Z Z Z Z AU Z Z YY Z Z Z Z




}

/**
 * * *
 */
