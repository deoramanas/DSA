package LeetcodeAlgorithms;

public class BitwiseAndOfNumberRange {
    public static void main(String[] args) {
        int left = 5, right = 7;
        int bitwiseAnd = rangeBitwiseAnd(left, right);
        System.out.println(bitwiseAnd);
    }

    private static int rangeBitwiseAnd(int left, int right) {
        int count = 0;

        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            count++;
        }

        return left << count;
    }

    //unoptimized
    public static int rangeBitwiseAnd1(int left, int right) {
        int result = left;
        for (int i = left; i <= right; i++) {
            result = result & i;
        }
        return result;
    }
}
