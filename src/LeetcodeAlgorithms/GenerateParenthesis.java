package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> parenthesis = generateParenthesis(3);
        System.out.println(parenthesis);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = 0;
        int closed = 0;
        generate(ans, new StringBuilder(), n, open, closed);
        return ans;
    }

    private static void generate(List<String> ans, StringBuilder sb, int n, int open, int closed) {
        if (open == closed && open == n) {
            ans.add(sb.toString());
        }

        if (open < n) {
            sb.append('(');
            generate(ans, sb, n, open + 1, closed);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closed < open) {
            sb.append(')');
            generate(ans, sb, n, open, closed + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
