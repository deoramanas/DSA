package LeetcodeDSA;

public class AddStrings {
    public static void main(String[] args) {
        String num1 = "6", num2 = "501";

        String s = addStrings(num1, num2);
        System.out.println(s);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int l1 = num1.length();
        int i = l1 - 1;
        int l2 = num2.length();
        int j = l2 - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int d1 = num1.charAt(i) - '0';
            int d2 = num2.charAt(j) - '0';
            int val = d1 + d2 + carry;
            res.insert(0, val % 10);
            carry = val / 10;
            i--;
            j--;
        }

        while (i >= 0) {
            int d1 = num1.charAt(i) - '0';
            int val = d1 + carry;
            res.insert(0, val % 10);
            carry = val / 10;
            i--;
        }

        while (j >= 0) {
            int d1 = num2.charAt(j) - '0';
            int val = d1 + carry;
            res.insert(0, val % 10);
            carry = val / 10;
            j--;
        }

        return res.toString();
    }
}
