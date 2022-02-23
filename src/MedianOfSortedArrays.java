import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MedianOfSortedArrays {
    public static void main(String[] args) {

        //int[] nums1 = {1,3};
        //int[] nums2 = {2};

        int[] nums1 = {};
        int[] nums2 = {1};

     //   int arr[]=new int[nums1.length+nums2.length];

        if(nums1.length == 0 && nums2 .length==0){
            return;
        }


        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>();

        if(nums1.length!=0){
            for (int i = 0; i < nums1.length; i++) {
                insertElement(maxHeap,nums1[i]);
            }
        }

    if(nums2.length!=0){
        for (int i = 0; i < nums2.length; i++) {
            insertElement(maxHeap,nums2[i]);
        }
    }


        double median = computeMedian(maxHeap);
        return median;
    }

    private static double computeMedian(PriorityQueue<Integer> maxHeap) {
//        if(maxHeap.size()==minHeap.size()){
//            return (maxHeap.poll()+minHeap.poll())/2.0;
//        }else{
//            return maxHeap.isEmpty()?minHeap.poll():maxHeap.poll();
//        }

       List<Integer> list= new ArrayList<>();
        int n=maxHeap.size();
        for (int i = 0; i < n; i++) {
            list.add(maxHeap.poll());
        }

        System.out.println(list);

       if(list.size()%2==0){
           int mid=(list.size()-1)/2;
           return (list.get(mid)+list.get(mid+1))/2.0;
       }else{
           return list.get(((list.size()-1)/2));
       }
    }

//    public static void insertElement(PriorityQueue maxHeap,PriorityQueue minHeap, int i){
//
//        if(maxHeap.isEmpty() || Integer.parseInt(maxHeap.peek().toString())>=i){
//            maxHeap.add(i);
//        }else{
//            minHeap.add(i);
//        }
//
//
//        if (minHeap.size()>maxHeap.size()){
//            maxHeap.add(minHeap.poll());
//        }else if(maxHeap.size()>minHeap.size() ){
//            minHeap.add(maxHeap.poll());
//        }
//
//        System.out.println(maxHeap+" "+minHeap );
//    }

    private static void insertElement(PriorityQueue max_heap, int i) {

//        if (max_heap.isEmpty() ) {
//            min_heap.offer(i);
//        } else {
//            max_heap.offer(i);
//        }
//        if (max_heap.size() < min_heap.size()) {
//            max_heap.offer(min_heap.poll());
//        } else if (max_heap.size() > min_heap.size()) {
//            min_heap.offer(max_heap.poll());
//        }
        max_heap.offer(i);
        System.out.println(max_heap+" ");
    }
}
