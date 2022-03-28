package LeetcodeAlgorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KWeakestRows {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;
        int[] weakestRows = kWeakestRows(mat, k);
        for (int i = 0; i < weakestRows.length; i++) {
            System.out.print(weakestRows[i] + " ");
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int c = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    c++;
                }
                map.put(i, c);
            }
        }

        LinkedHashMap<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted((a, b) -> a.getValue().compareTo(b.getValue())).collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(map);
        System.out.println(sortedMap);
        return sortedMap.keySet().stream().limit(3).mapToInt(i -> i).toArray();
    }
}
