import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

       // int []nums ={1,1,2,2,3,3,3,4,4,4,4,4};
        int []nums ={1,2,3};

        int k = removeDuplicates(nums);
        System.out.println();
        System.out.println(k);
    }

    public static int removeDuplicates(int[] nums){

        int k=1;
        if(nums.length==1){
            return 1;
        }
        int first=nums[0];

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1]){
                nums[k++]=nums[i+1];
            }
        }

        nums[0]=first;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] +" ");
        }
        return k;
    }
}
