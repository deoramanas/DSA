package LeetcodeAlgorithms;

public class ReverseEveryWordInAString {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String ans = reverseWords(s);
        System.out.println(ans);

    }

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < strings.length - 1; i++) {
            newStr.append(reverseStr(strings[i])).append(" ");
        }
        newStr.append(reverseStr(strings[strings.length - 1]));
        return newStr.toString();
    }

    public static String reverseStr(String s) {
        int start = 0;
        char c[] = s.toCharArray();
        int end = c.length - 1;
        while (start <= end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(c);
    }
}
