package LeetcodeAlgorithms;

public class PermutationsOfAString {
    public static void main(String[] args) {
        String s = "abcd";
        permute(s, 0, s.length());
    }

    private static void permute(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        }

        for (int i = l; i < r; i++) {
            s = swap(s, l, i);
            permute(s, l + 1, r);
            //backtracking
            s = swap(s, l, i);
        }
    }

//                abc
//
//        abc        bac             cba
//
//    abc   acb    bac   bca      cba   cab


    private static String swap(String s, int l, int i) {

        StringBuilder stringBuilder = new StringBuilder(s);
        char c = stringBuilder.charAt(i);
        stringBuilder.setCharAt(i, s.charAt(l));
        stringBuilder.setCharAt(l, c);

        return stringBuilder.toString();
    }

}
