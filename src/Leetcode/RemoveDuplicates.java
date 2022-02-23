package Leetcode;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(3);
        ListNode head = deleteDuplicates(listNode);
        printList(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = current;
        ListNode next = null;

        while (current != null) {

            next = current.next;
            current = next;

            if (current != null && prev.val == next.val) {
                continue;
            }

            prev.next = next;
            current = next;
            prev = current;
        }

        return head;
    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
