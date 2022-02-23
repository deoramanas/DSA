import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TestPQ {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.reverseOrder());
        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // pq.add(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        pq.offer(100);
        pq.offer(1);

        while(pq.size()!=0) {
            System.out.println(pq.poll());
        }

        System.out.println("manas");
    }
}
