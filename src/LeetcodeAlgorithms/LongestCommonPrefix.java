package LeetcodeAlgorithms;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"aaa", "aa", "aaa"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char first = strs[0].charAt(i);
            boolean flag = false;
            for (int j = 1; j < strs.length; j++) {

                String currentString = strs[j];
                if (i < currentString.length()) {
                    char currentChar = currentString.charAt(i);
                    if (first == currentChar) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                sb.append(first);
            } else {
                break;
            }
        }


        return sb.toString();
    }
}
