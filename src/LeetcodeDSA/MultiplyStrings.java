package LeetcodeDSA;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "140", num2 = "721";

        String s = multiplyStrings(num1, num2);
        System.out.println(s);
    }

    private static String multiplyStrings(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<StringBuilder> ans = new ArrayList<>();
        int i = num2.length() - 1;
        while (i >= 0) {
            int d2 = num2.charAt(i) - '0';
            int sum = 0;
            int j = num1.length() - 1;
            StringBuilder sbSum = new StringBuilder();
            int carry = 0;
            while (j >= 0) {
                int d1 = num1.charAt(j) - '0';
                int val = d1 * d2 + carry;
                sum = val % 10;
                sbSum.insert(0, sum);
                carry = val / 10;
                j--;
            }
            if (carry != 0) {
                sbSum.insert(0, carry);
            }
            ans.add(sbSum);
            i--;
        }
        int k = ans.size() - 1;
        for (int j = ans.size() - 1; j >= 0; j--) {
            StringBuilder curr = ans.get(j);
            int t = k;
            while (t > 0) {
                curr = curr.append("0");
                t--;
            }
            k--;
        }
        StringBuilder result = new StringBuilder();
        for (int j = ans.size() - 1; j >= 0; j--) {
            result = addStrings(result.toString(), ans.get(j).toString());

        }
        // res.append();
        return result.toString();
    }

    public static StringBuilder addStrings(String num1, String num2) {
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
        if (carry == 1) {
            res = res.insert(0, 1);
        }
        return res;
    }
}
