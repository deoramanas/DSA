package Leetcode;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        String ans = simplifyPath(path);
        System.out.println(ans);
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String word : split) {
            if (word.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else if (word.equals("") || word.equals(".")) {
                continue;
            } else {
                stack.push(word);
            }
        }

        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, "/");
        }

        return sb.toString();
    }
}
