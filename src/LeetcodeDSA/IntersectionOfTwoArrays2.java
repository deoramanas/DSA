package LeetcodeDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 1};
        int[] nums2 = {2, 2, 3};
        int[] intersect = intersect(nums1, nums2);
        for (int i = 0; i < intersect.length; i++) {
            System.out.print(intersect[i] + " ");
        }
    }

    //using map
    private static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int a : nums1) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        for (int b : nums2) {
            if (map.containsKey(b) && map.get(b) > 0) {
                map.put(b, map.get(b) - 1);
                arrayList.add(b);
            } else {
                continue;
            }
        }
        return arrayList.stream().mapToInt(x -> x).toArray();
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }

}
