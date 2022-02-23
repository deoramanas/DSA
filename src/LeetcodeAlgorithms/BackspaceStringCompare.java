package LeetcodeAlgorithms;

public class BackspaceStringCompare {
    public static void main(String[] args) {

        String s1 = "ab#c";
        String s2 = "ad#c";

        boolean ans = backspaceCompare(s1, s2);
        System.out.println(ans);
    }

    public static boolean backspaceCompare(String s, String t) {

        if (getString(s).equals(getString(t))) {
            return true;
        }
        return false;
    }

    private static String getString(String s) {

        String res = "";
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                }else {
                    res = res + ch;
                }
            }
        }
        return res;
    }
}
