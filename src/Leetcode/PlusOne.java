package Leetcode;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int digits[] = {9, 9, 9};

        int ans[] = plusOne.calculate(digits);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }

    public int[] calculate(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            int currDigit = digits[i];
            if (currDigit < 9) {
                digits[i] = currDigit + 1;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        }
        return digits;
    }

    private void rightShift(int[] a) {
        int lastElement = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = lastElement;
    }

    private void leftShift(int[] copyDigits) {
        int length = copyDigits.length;

        int lastElement = copyDigits[length - 1];

        for (int i = 0; i < length - 1; i++) {
            int temp = copyDigits[i];
            copyDigits[i] = copyDigits[i + 1];
            copyDigits[i + 1] = temp;
        }

        // copyDigits[0] = lastElement;
    }

    private void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}


