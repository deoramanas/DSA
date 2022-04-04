package LeetcodeDSA;

public class MinimumFlipBitsToConvert {
    public static void main(String[] args) {
        int start = 10;
        int end = 82;

        int minBitFlips = minBitFlips(start, end);
        System.out.println(minBitFlips);
    }

    public static int minBitFlips(int start, int goal) {
        int c = 0;
        int d1 = 0;
        int d2 = 0;
        while (start > 0 && goal > 0) {
            d1 = start % 2;
            d2 = goal % 2;
            if (d1 != d2) {
                c++;
            }
            start = start / 2;
            goal = goal / 2;
        }
        while (start > 0) {
            d1 = start % 2;
            if (d1 != 0) {
                c++;
            }
            start = start / 2;
        }
        while (goal > 0) {
            d2 = goal % 2;
            if (d2 != 0) {
                c++;
            }
            goal = goal / 2;
        }
        return c;
    }
}
