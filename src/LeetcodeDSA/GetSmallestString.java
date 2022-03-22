package LeetcodeDSA;

public class GetSmallestString {
    public static void main(String[] args) {
        int n = 3;
        int k = 27;
        // int n = 5;
        // int k = 73;
        String smallestString = getSmallestString(n, k);
        System.out.println(smallestString);
    }

    public static String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int i = n - 1;
        while (n > 0) {
            int charNum = Math.min(k - i, 26);

            k = k - charNum;
            char c = (char) (97 + charNum - 1) < 'a' ? 'a' : (char) (97 + charNum - 1);
            sb.append(c);
            n--;
            i--;
        }
        return sb.reverse().toString();
    }
}
