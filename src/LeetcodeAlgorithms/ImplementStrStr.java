package LeetcodeAlgorithms;

public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "", needle = "";
        int ans = strStr(haystack, needle);
        System.out.println(ans);
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
