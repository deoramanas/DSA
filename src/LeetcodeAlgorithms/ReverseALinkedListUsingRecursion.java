package LeetcodeAlgorithms;

import Leetcode.ListNode;

public class ReverseALinkedListUsingRecursion {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(6);
        System.out.println("Before reversal :");
        printList(listNode);
        ListNode newHead = reverseList(listNode);

        System.out.println("After reversal :");
        printList(newHead);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastNode = reverseList(head.next);

        ListNode next = head.next;
        next.next = head;
        head.next = null;

        return lastNode;
    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
