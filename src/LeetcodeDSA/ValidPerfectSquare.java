package LeetcodeDSA;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 808201;
        boolean perfectSquare = isPerfectSquare(num);
        System.out.println(perfectSquare);
        System.out.println(Math.sqrt(num));
    }

    public static boolean isPerfectSquare(int num) {
        int l = 0;
        int h = (int) Math.log10((double) num);

        while (l <= h) {

            int m = l + (h - l) / 2;
            if (m * m == num) {
                System.out.println(m);
                return true;
            } else if ((m * m > 0) && num > (m * m)) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return false;
    }
}
