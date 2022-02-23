public class PowerOfTwo {
    public static void main(String[] args) {
        int n=5;
        int ans= calculate(n);
        System.out.println(ans);
    }

    private static int calculate(int n) {
        if(n==0){
            return 1;
        }else{
            int rec=calculate(n-1);
            int val=3* rec;
            return val;
        }
    }
}
