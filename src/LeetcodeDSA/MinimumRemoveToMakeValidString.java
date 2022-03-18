package LeetcodeDSA;

public class MinimumRemoveToMakeValidString {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        String ans = minRemoveToMakeValid(s);
        System.out.println(ans);
    }

    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int flag = 0;

            if (chars[i] == '(') {
                count++;
            } else if (chars[i] == ')') {
                if (count > 0) {
                    count--;
                } else {
                    chars[i] = '0';
                }
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {

            if (chars[i] == ')') {
                count++;
            } else if (chars[i] == '(') {
                if (count > 0) {
                    count--;
                } else {
                    chars[i] = '0';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
