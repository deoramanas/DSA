package LeetcodeDSA;

import java.math.BigInteger;

public class BrokenCalculator {
    public static void main(String[] args) {

        int startValue = 5, target = 8;
        int brokenCalc = brokenCalc(startValue, target);
        System.out.println(brokenCalc);
    }

    public static int brokenCalc(int startValue, int target) {
        if (startValue >= target) {
            return startValue - target;
        }
        int count = 0;
        while (target > 0) {
            if (target + 1 == startValue) {
                count++;
                break;
            }
            if (target == startValue) {
                break;
            }

            if ((target & 1) != 1) {
                target=target>>1;
            } else {
                target += 1;
            }
            count++;
        }

        return count;
    }
}
