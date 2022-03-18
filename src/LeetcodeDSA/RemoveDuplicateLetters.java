package LeetcodeDSA;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {

        String s = "cbacdcbc";
        String ans = removeDuplicateLetters(s);
        System.out.println(ans);
    }

    private static String removeDuplicateLetters(String s) {

        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (seen[c]) {
                continue;
            }
            while (!stack.empty() && stack.peek() > c && i < lastIndex[stack.peek()]) {
                seen[stack.pop()] = false;
            }
            stack.push(c);
            seen[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append((char) (stack.pop() + 'a'));
        }

        return sb.reverse().toString();

    }

}
