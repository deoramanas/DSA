package LeetcodeAlgorithms;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        boolean happy = isHappy(n);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {

        int b = n;
        int sum = 0;
        sum = getSumOfDigits(b, sum);
        while (sum > 0) {
            sum = getSumOfDigits(sum, 0);
            int w = sum;
            int numberOfDigits = numberOfDigits(w, 0);
            if (numberOfDigits == 1) {
                break;
            }
        }
        if (sum == 1) {
            return true;
        }
        System.out.println(sum);
        return false;
    }

    private static int getSumOfDigits(int b, int sum) {
        while (b > 0) {
            int x = b % 10;
            sum += x * x;
            b = b / 10;
        }
        return sum;
    }

    private static int numberOfDigits(int b, int count) {
        while (b > 0) {
            int x = b % 10;
            count++;
            b = b / 10;
        }
        return count;
    }
}
