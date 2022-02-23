import java.util.ArrayList;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {

        PreviousSmallerElement previousSmallerElement = new PreviousSmallerElement();
        int arr[] = {4, 10, 5, 8, 20, 15, 3, 12};
        int arr1[] = {3, 10, 5, 1, 15, 10, 7, 6};

        previousSmallerElement.computePreviousSmallerElement(arr);
        System.out.println();
        previousSmallerElement.computeNextSmallerElement(arr);
    }

    private void computeNextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList arrayList = new ArrayList();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                arrayList.add(-1);
            } else {
                arrayList.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.print(arrayList.get(i)+" ");
        }
    }

    private void computePreviousSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(stack.peek() + " ");
            }
            stack.push(arr[i]);
        }
    }
}
