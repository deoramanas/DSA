package LeetcodeAlgorithms;

import java.util.ArrayList;

//Leetcode -34
public class FirstAndLastPosition {
    public static void main(String[] args) {
//        int nums[] = {5, 7, 7, 8, 8, 10};
//        int[] ans = searchRange(nums, 8);
        int nums[] = {2, 2, 2};
        int[] ans = searchRange(nums, 2);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + " ");
        }
        System.out.println();
    }

    public static int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
//        if (nums[0] == target) {
//            arrayList.add(0);
//        }
        while (low <= high) {
            int mid = low;

            if (nums[mid] == target) {
                arrayList.add(mid);
                low++;
            } else {

                // 1 2 3 4 5 6 7 8 9 10
                if (nums[mid] > target) {
                    high = mid - 1;
                    mid = low + (high - low) / 2;
                } else {
                    low = mid + 1;
                    mid = low + (high - low) / 2;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return new int[]{-1, -1};
        }

        return new int[]{arrayList.get(0), arrayList.get(arrayList.size() - 1)
        };
    }
}
