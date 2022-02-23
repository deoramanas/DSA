package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

        System.out.println(triangle);

        int minimumTotal = minimumTotal(triangle);
        System.out.println(minimumTotal);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                Integer element = triangle.get(i).get(j);
                System.out.print(element + " ");
                int sum = 0;
                if (j == 0) {
                    sum = triangle.get(i).get(j) + triangle.get(i - 1).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    sum = triangle.get(i).get(j) + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1);
                } else {
                    sum = triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                }
                triangle.get(i).set(j, sum);
            }
            System.out.println();
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
