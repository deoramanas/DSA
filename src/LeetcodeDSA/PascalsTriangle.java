package LeetcodeDSA;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 8;
        List<List<Integer>> generate = generate(numRows);
        System.out.println(generate);
    }

    public static List<List<Integer>> generate(int numRows) {

            if (numRows == 1) {
                return new ArrayList<>(List.of(new ArrayList<>(List.of(1))));
            }
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        res.add(List.of(1, 1));

        for (int i = 2; i < numRows; i++) {
            List<Integer> list = res.get(res.size() - 1);
            List<Integer> curr = new ArrayList<>();

            curr.add(list.get(0));
            for (int k = 0; k < list.size() - 1; k++) {
                curr.add(list.get(k) + list.get(k + 1));
            }
            curr.add(list.get(list.size() - 1));

            res.add(curr);

        }
        return res;
    }
}
