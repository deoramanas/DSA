package LeetcodeDSA;

import java.util.HashMap;

public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target = 8;
        int ans = threeSumMulti(arr, target);
        System.out.println(ans);
    }

    public static int threeSumMulti(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long mod = 1000000007;

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        long res = 0;
        for (int i : map.keySet()) {
            for (int j : map.keySet()) {
                int k = target - i - j;

                if (map.containsKey(k)) {
                    int a = map.get(i);
                    int b = map.get(j);
                    int c = map.get(k);

                    if (i == j && j == k) {
                        res += a * (b - 1) * (c - 2) / 6;
                    } else if (i == j && j != k) {
                        res += ((a * (b - 1)) / 2) * c;
                    } else if (i < j && j < k) {
                        res += a * b * c;
                    }
                    res = res % mod;
                }
            }
        }

        return (int) res;
    }
}
