public class ReverseNumber {
    public static void main(String[] args) {

        int n=1534236469;
        int ans= reverse(n);
        System.out.println(ans);
    }

    private static int reverse(int x) {
        int b=x;
        int flag=0;

        if(b<0){
            b=-b;
            flag=1;
        }

        long sum=0;
        while(b>0){
            int t=b%10;
            sum=(sum*10)+t;
            b=b/10;
        }
        if(flag==1){
            return (int)-sum;
        }else{
            return (int) sum;
        }
    }
}
