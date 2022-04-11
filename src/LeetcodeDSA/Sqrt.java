package LeetcodeDSA;

public class Sqrt {
    public static void main(String[] args) {
        int x = 8;
        int i = mySqrt(x);
        System.out.println(i);
    }

    //8
    //2.8888
    public static int mySqrt(int x) {
        double l = 1;
        double h = x;

        while (l <= h) {
            double m = l + (h - l) / 2;
            long m1 = Math.round(m * 100) / 100;

            if (m1 * m1 == x) {
                return (int) Math.floor(m);
            } else if (m * m > x) {
                h = m - m / (x);
            } else {
                l = m + m / (x);
            }
        }

        return (int) Math.floor(l);
    }
}
