public class ReverseStringRecursion {
    public static void main(String[] args) {

        String s = "i love java";
//        String rev = reverse(s);
//
//        System.out.println(rev);
//        boolean same = isPalindrome(s);
//        System.out.println(same);
//
//        System.out.println();
//        System.out.println(first(s));

        System.out.println(capitalizeWord(s));
    }

    private static String reverse(String s) {
        int n = s.length();

        if (n == 0) {
            return s;
        }

        return s.charAt(n - 1) + reverse(s.substring(0, n - 1));
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();

        if (n == 0 || n == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(n - 1)) {
            return isPalindrome(s.substring(1, n - 1));
        }

        return false;
    }

    public static char first(String s) {

        if (s.isEmpty()) {
            return ' ';
        }
        if (Character.isUpperCase(s.charAt(0))) {
            return s.charAt(0);
        } else {
            return first(s.substring(1));
        }

    }

    public static String capitalizeWord(String str) {

        char chr= str.charAt(str.length()-1);

        if(str.length() ==1){
            return Character.toString(Character.toUpperCase(chr));
        }

        if(str.substring(str.length()-2,str.length()-1).equals(" ")){
            chr=Character.toUpperCase(chr);
        }

        return  capitalizeWord(str.substring(0,str.length()-1)) +Character.toString(chr) ;

    }

}
