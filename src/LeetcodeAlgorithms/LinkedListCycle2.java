package LeetcodeAlgorithms;

import Leetcode.ListNode;

public class LinkedListCycle2 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = new ListNode(2);

        ListNode node = detectCycle(listNode);
        System.out.println(node);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode current = head;
        ListNode fast = head;

        while (slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (current != slow) {
                    current = current.next;
                    slow = slow.next;
                }
            }
        }

        return null;
    }
}
