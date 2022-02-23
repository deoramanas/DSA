public class RainwaterTappingProblem {
    public static void main(String[] args) {
        RainwaterTappingProblem obj = new RainwaterTappingProblem();
        int buildings[] = {3, 1, 2, 4, 0, 1, 3, 2};

        int ans = obj.totalWaterTrapped(buildings);
        System.out.println(ans);
    }

    private int totalWaterTrapped(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

//        for (int i = 0; i < height.length; i++) {
//            System.out.print(left[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < height.length; i++) {
//            System.out.print(right[i] + " ");
//        }
//        System.out.println();

        int[] ans=new int[height.length];
        for (int i = 0; i < height.length; i++) {
        ans[i]= Math.min(left[i],right[i])-height[i];
        }
        int sum=0;
//        for (int i = 0; i < height.length; i++) {
//            sum=sum+ans[i];
//        }
        int localsum=0;

        for (int i = 0; i < height.length; i++) {
            localsum=localsum+ans[i];
            if(ans[i]==0 && localsum>sum){
                sum=localsum;
                localsum=0;
            }
        }

        return sum;
    }
}
