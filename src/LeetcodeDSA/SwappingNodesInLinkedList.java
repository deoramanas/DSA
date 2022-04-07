package LeetcodeDSA;

import Leetcode.ListNode;

public class SwappingNodesInLinkedList {
    public static void main(String[] args) {

        // ListNode listNode = new ListNode(1);
        // listNode.next = new ListNode(2);
        // listNode.next.next = new ListNode(3);
        // listNode.next.next.next = new ListNode(4);
        // listNode.next.next.next.next = new ListNode(5);
        // listNode.next.next.next.next.next = new ListNode(6);


        // ListNode listNode = new ListNode(7);
        // listNode.next = new ListNode(9);
        // listNode.next.next = new ListNode(6);
        // listNode.next.next.next = new ListNode(6);
        // listNode.next.next.next.next = new ListNode(7);
        // listNode.next.next.next.next.next = new ListNode(8);
        // listNode.next.next.next.next.next.next = new ListNode(3);
        // listNode.next.next.next.next.next.next.next = new ListNode(0);
        // listNode.next.next.next.next.next.next.next.next = new ListNode(9);
        // listNode.next.next.next.next.next.next.next.next.next = new ListNode(5);
        ListNode listNode = new ListNode(80);
        listNode.next = new ListNode(46);
        listNode.next.next = new ListNode(66);
        listNode.next.next.next = new ListNode(35);
//        listNode.next.next.next.next = new ListNode(64);
        int k = 1;
        ListNode node = swapNodes(listNode, k);
        print(node);

    }

    public static ListNode swapNodes(ListNode head, int k) {
        int start = k;
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        if (length / 2 < k) {
            k = length - k + 1;
            start = k;
        }

        int last = length - k;
        if (length % 2 == 0) {
            if (length == 2) {
                ListNode second = head.next;
                ListNode first = head;
                head = second;
                second.next = first;
                first.next = null;
                return head;
            }

        } else {
            if (k == length / 2 + 1) {
                return head;
            }
        }

        ListNode first = head;
        ListNode prevFirst = null;

        while (start-- > 1) {
            prevFirst = first;
            first = first.next;
        }

        ListNode second = head;
        ListNode prevSecond = null;

        while (last-- > 0) {
            prevSecond = second;
            second = second.next;
        }

        ListNode firstNext = first.next;
        ListNode secondNext = second.next;

        if (length % 2 == 0) {
            if (first.next == second) {
                prevFirst.next = second;
                second.next = first;
                first.next = secondNext;
                return head;
            } else if (second.next == first) {
                prevSecond.next = first;
                first.next = second;
                second.next = firstNext;
                return head;
            }
        } else {

        }
        if (prevFirst != null) {
            prevFirst.next = second;
        } else {
            head = second;
        }
        second.next = firstNext;

        if (prevSecond != null) {
            prevSecond.next = first;
        } else {
            prevSecond = first;
        }
        if (secondNext != null) {
            first.next = secondNext;
        } else {

            first.next = null;
        }

        return head;
    }

    private static void print(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
        System.out.println();
    }
}
