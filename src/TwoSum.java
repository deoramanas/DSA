import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        int arr[]={2,7,11,5};
        int target=9;
        HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();

        for (int i=0;i< arr.length;i++){
            if(hmap.containsKey(target-arr[i])){
                System.out.println(i+" "+hmap.get(target-arr[i]));
            }else{
                hmap.put(arr[i],i);
            }
        }

    }
}
