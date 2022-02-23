package LeetcodeAlgorithms;

import Leetcode.ListNode;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        //printList(listNode1);
        ListNode listNode = removeNthFromEnd(listNode1, 1);
        printList(listNode);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
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