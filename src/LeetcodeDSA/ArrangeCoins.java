package LeetcodeDSA;

public class ArrangeCoins {
    public static void main(String[] args) {
        int n = 12;
        int arrangeCoins = arrangeCoins(n);
        System.out.println(arrangeCoins);
    }

    public static int arrangeCoins(int n) {
        long s = 0;
        long e = n;

        while (s <= e) {
            long m = s + (e - s) / 2;

            long k = m * (m + 1) / 2;

            if (k == n) {
                return (int) m;
            } else if (k < n) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return (int) e;
    }
}
