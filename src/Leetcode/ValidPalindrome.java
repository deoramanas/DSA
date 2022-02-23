package Leetcode;

public class ValidPalindrome {
    public static void main(String[] args) {

        String s = "manas";

        s = s.trim();
        if (s.isEmpty()) {
            return;
        }

        s = s.toLowerCase();
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {

            if (Character.isLetterOrDigit(s.charAt(i))) {
                newStr += s.charAt(i);

            }
        }
        if (newStr.isEmpty()) {
            return;
        }
        // System.out.println(newStr);
        boolean palindrome = isPalindrome(newStr, 0, newStr.length() - 1);
        // System.out.println(palindrome);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s, int l, int r) {
        if (s.charAt(l) != s.charAt(r)) {
            return false;
        }

        if (l >= r) {
            return true;
        }

        return isPalindrome(s, l + 1, r - 1);

    }
}