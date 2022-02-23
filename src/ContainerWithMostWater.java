public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = obj.maxArea(height);
        System.out.println(area);
    }

    public int maxArea(int[] height) {
        int l=0;
        int r= height.length-1;
        int sum=0;

        while(l<r){
            int leftHeight = height[l];
            int rightHeight = height[r];
            int area=Math.min(leftHeight,rightHeight) * (r-l);
             sum = Math.max(sum, area );
            if(leftHeight< rightHeight){
                l++;
            }else {
                r--;
            }
        }

        return sum;
    }

}

