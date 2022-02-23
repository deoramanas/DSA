public class ReverseInteger {
    public static void main(String[] args) {
        int n = 1534236469;
        System.out.println(reverse(n));
    }

    private static int reverse(int n) {

        boolean isNegative = false;

        if (n < 0) {
            n = n * -1;
            isNegative = true;
        }
        long reversed = 0;
        while (n > 0) {

            reversed = (reversed * 10) + (n % 10);

            n=n/10;
        }
        if (reversed >= Integer.MAX_VALUE){
            return 0;
        }
        return isNegative==true? (int)(reversed *-1 ):(int)reversed;
    }

}
