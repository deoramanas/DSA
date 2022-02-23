package Leetcode;

public class BinaryAdd {
    public static void main(String[] args) {
        //   String s1 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        //  String s2 = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        String s1 = "1010";
        String s2 = "1011";
        String ans = addBinary(s1, s2);
        System.out.println(ans);
    }

    public static String addBinary(String s1, String s2) {

        StringBuilder res = new StringBuilder();

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += s1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += s2.charAt(j--) - '0';
            }
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }

        if (carry != 0) {
            res.append(carry);
        }

        return res.reverse().toString();

    }
}
