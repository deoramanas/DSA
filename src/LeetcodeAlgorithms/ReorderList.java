package LeetcodeAlgorithms;

import Leetcode.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        reorderList(listNode);
        print(listNode);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode curr = head;
        ListNode slow = head;
        ListNode fast = head;


        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode reversed = reverse(second);

        while (curr != null && reversed != null) {
            ListNode temp1 = curr.next;
            curr.next = reversed;
            ListNode temp2 = reversed.next;
            reversed.next = temp1;
            curr = temp1;
            reversed = temp2;
        }

    }

    private static ListNode reverse(ListNode second) {
        ListNode curr = second;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void print(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
        System.out.println();
    }
}
