import java.util.HashMap;

public class SlidingWindowEg {
    public static void main(String[] args) {
        int[] arr= {1,2,2,1,3,1,1,3};
        int k=4;

        HashMap<Integer,Integer> hmap=new HashMap<>();
        int n=arr.length;
        for (int i = 0; i < k; i++) {
            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
        }
        System.out.println(hmap.size());
       // System.out.println(hmap);
        for (int i = k; i < n; i++) {
            if(hmap.get(arr[i-k])==1){
                hmap.remove(arr[i-k]);
            }else{
                hmap.put(arr[i-k],hmap.get(arr[i-k])-1);
            }

            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
            System.out.println(hmap.size());
        }
    }
}
