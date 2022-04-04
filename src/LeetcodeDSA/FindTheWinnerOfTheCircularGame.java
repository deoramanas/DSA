package LeetcodeDSA;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int theWinner = findTheWinner(n, k);
        System.out.println(theWinner);
    }

    public static int findTheWinner(int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                break;
            }
            int t = k - 1;
            while (t > 0) {
                queue.offer(queue.poll());
                t--;
            }
            queue.poll();
        }
        return queue.poll();
    }
}
