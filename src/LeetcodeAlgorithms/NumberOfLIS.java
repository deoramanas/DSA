package LeetcodeAlgorithms;

import java.util.Arrays;

public class NumberOfLIS {
    public static void main(String[] args) {
        //        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
//        int nums[] = {0, 1, 0, 3, 2, 3};
//        int nums[] = {7, 7, 7, 7, 7};
//        int nums[] = {4, 10, 4, 3, 8, 9};

//        int nums[] = {1, 2, 4, 3, 5, 4, 7, 2};

        int nums[] = {1, 2, 4, 3, 5, 4, 7, 2};
        //    int nums[] = {0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15, 18, 17, 20, 19, 22, 21, 24, 23, 26, 25, 28, 27, 30, 29, 32, 31, 34, 33, 36, 35, 38, 37, 40, 39, 42, 41, 44, 43, 46, 45, 48, 47, 50, 49, 52, 51, 54, 53, 56, 55, 58, 57, 60, 59, 61};
        int lengthOfLIS = lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }

    public static int lengthOfLIS(int[] nums) {

        int max = 0;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {
            int maxVal = 0;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > maxVal) {
                        maxVal = dp[j];
                        count[i] = count[j];

                    }
                    if (dp[j]+1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
                dp[i] = maxVal + 1;

            }

        }

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println("max = " + max);
        int res = 0;
        System.out.println("dp = " + Arrays.toString(dp));

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                res = res + count[i];
            }
        }
        System.out.println("count = " + Arrays.toString(count));

        return res;
    }

    //TLE

//    public static int findNumberOfLIS(int[] nums, int[] dp, int max) {
//        ArrayDeque<Pair> queue = new ArrayDeque<>();
//        for (int i = 0; i < dp.length; i++) {
//            if (dp[i] == max) {
//                queue.add(new Pair(nums[i], i, +nums[i] + "-> ", max));
//            }
//        }
//
//        int count = 0;
//        while (!queue.isEmpty()) {
//            Pair pair = queue.removeFirst();
//            if (pair.length == 1) {
//                count++;
//            }
//            for (int i = 0; i < pair.index; i++) {
//                if (dp[i] == pair.length - 1 && nums[i] < pair.value) {
//                    queue.add(new Pair(nums[i], i, nums[i] + "->" + pair.path, dp[i]));
//                }
//            }
//        }
//
//        System.out.println(queue.toString());
//        return count;
//    }
//
//}
//
//class Pair {
//    int value;
//    int index;
//    String path;
//    int length;
//
//    @Override
//    public String toString() {
//        return "Pair{" +
//                "value=" + value +
//                ", index=" + index +
//                ", path='" + path + '\'' +
//                ", length=" + length +
//                '}';
//    }
//
//    public Pair(int value, int index, String path, int length) {
//        this.value = value;
//        this.index = index;
//        this.path = path;
//        this.length = length;
//    }
}
