package LeetcodeAlgorithms;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        boolean powerOfTwo = isPowerOfTwo(n);
        System.out.println(powerOfTwo);
    }

    public static boolean isPowerOfTwo(int n) {

        return ((n > 0) && ((n & (n - 1)) == 0));
    }
}
