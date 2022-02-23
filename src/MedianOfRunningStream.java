import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningStream {
    public static void main(String[] args) {
        PriorityQueue<Integer> max_heap = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> min_heap = new PriorityQueue();
        insertElement(max_heap, min_heap, 2);
        insertElement(max_heap, min_heap, 3);
       insertElement(max_heap, min_heap, 1);
//        insertElement(max_heap, min_heap, 4);
//        insertElement(max_heap, min_heap, 5);
//        insertElement(max_heap, min_heap, 6);
//        insertElement(max_heap, min_heap, 7);
      double median= computeMedian(max_heap,min_heap);
        System.out.println("Median is : "+median);
    }

    private static double computeMedian(PriorityQueue<Integer> max_heap, PriorityQueue<Integer> min_heap) {
        if(max_heap.size()==min_heap.size())
        {
            return (max_heap.poll()+min_heap.poll())/2.0;

        }else{
            return max_heap.poll();
        }
    }

    private static void insertElement(PriorityQueue max_heap, PriorityQueue min_heap, int i) {

        if (max_heap.isEmpty() || Integer.parseInt(max_heap.peek().toString()) >= i) {
            max_heap.offer(i);
        } else {
            min_heap.offer(i);
        }
        if (max_heap.size() < min_heap.size()) {
            max_heap.offer(min_heap.poll());
        } else if (max_heap.size() > min_heap.size()) {
            min_heap.offer(max_heap.poll());
        }

        System.out.println(max_heap+" "+ min_heap);
    }

}
