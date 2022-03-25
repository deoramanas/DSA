package LeetcodeDSA;

import java.util.Arrays;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] costs = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        int twoCitySchedCost = twoCitySchedCost(costs);
        System.out.println(twoCitySchedCost);
    }

    public static int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, (a, b) -> {
            return Integer.compare(a[1] - a[0], b[1] - b[0]);
        });

        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                sum += costs[i][1];
            } else {
                sum += costs[i][0];
            }
        }


        return sum;
    }
}
