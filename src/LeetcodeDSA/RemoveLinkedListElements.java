package LeetcodeDSA;

import Leetcode.ListNode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(6);
        int val = 1;
        ListNode node = removeElements(listNode, val);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static ListNode removeElements(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = head;

        while (head != null && head.val == target) {
            head = head.next;
        }

        while (curr != null) {
            if (curr.val == target) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }

}
