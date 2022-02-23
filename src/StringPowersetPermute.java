import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPowersetPermute {
    public static void main(String[] args) {
        String a = "racecar";
        String b = "abc";

        System.out.println(isPalindrome(a, 0, a.length() - 1));

        System.out.println();
        System.out.println("Print all possible subset \n  \n");

        powerSet(b, 0, "");
        System.out.println("All permutations");

        allPermutations(b, 0, b.length());

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);

        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);

        arr.add(3);
        arr.add(3);

//        Map<Integer, Integer> map = arr.stream()
//                .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));
//
//        System.out.println(map);
    }

    private static void allPermutations(String s, int l, int r) {

        if (l == r) {
            System.out.println(s);
            return;
        }
        for (int i = l; i < r; i++) {
            s = swapping(s, l, i);
            allPermutations(s, l + 1, r);
            s = swapping(s, l, i);
        }
    }

    private static String swapping(String s, int l, int i) {

        char[] charArr = s.toCharArray();
        char c = s.charAt(l);
        charArr[l] = s.charAt(i);
        charArr[i] = c;

        return new String(charArr);
    }

    private static void powerSet(String s, int i, String current) {

        if (i == s.length()) {
            System.out.println(current);
            return;
        }
        powerSet(s, i + 1, current + Character.toString(s.charAt(i)));
        powerSet(s, i + 1, current);

    }

    private static boolean isPalindrome(String s, int l, int r) {
        if (l >= r) {
            return true;
        }

        if (s.charAt(l) == s.charAt(r)) {
            return isPalindrome(s, l + 1, r - 1);
        }

        return false;
    }

}
