public class RandomPointersLinkedList {
    public static LinkedListNode head;

    public static void main(String[] args) {
        RandomPointersLinkedList obj = new RandomPointersLinkedList();
        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        head.random = head.next.next;

        // 2's random points to 1
        head.next.random = head;

        // 3's and 4's random points to 5
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random
                = head.next.next.next.next;

        // 5's random points to 2
        head.next.next.next.next.random = head.next;
        System.out.println("Before: ");
        obj.display(head);

        System.out.println("After: ");

      LinkedListNode cloned=   obj.cloneLinkedList(head);
      obj.display(cloned);
    }

    private LinkedListNode cloneLinkedList(LinkedListNode head) {
        LinkedListNode current = head;

        // 1  2  3  4  5
        LinkedListNode temp = null;

        while (current != null) {
            temp = current.next;
            LinkedListNode node = new LinkedListNode(current.data);
            current.next = node;
            node.next = temp;
            current = temp;
        }

        current = head;

        while (current != null) {
            LinkedListNode arb = current.next;

            if (arb != null) {
                arb.random = (current.random != null) ? current.random.next : current.random;
            }
            current = current.next.next;
        }

        // 1 1 2 2 3 3
        current=head;
        LinkedListNode original=current;
        LinkedListNode cloned=current.next;

        LinkedListNode tempo= cloned;
        while (original != null){
            original.next = original.next.next;
            cloned.next= cloned.next!=null ?cloned.next.next:null;

            original= original.next;
            cloned=cloned.next;
        }
        return tempo;
    }

    public void display(LinkedListNode head) {
        LinkedListNode start = head;
        while (start != null) {
            System.out.println(start.data + " "+ start.random.data);
            start = start.next;
        }
        System.out.println();
    }

}

class LinkedListNode {
    int data;
    LinkedListNode next;
    LinkedListNode random;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
