package Leetcode;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoListsUsingRecursion(listNode1, listNode2);
        printList(listNode);
        System.out.println();
    }

    private static ListNode mergeTwoListsUsingRecursion(ListNode listNode1, ListNode listNode2) {

        if (listNode1 == null) {
            return listNode2;
        }

        if (listNode2 == null) {
            return listNode1;
        }

        if (listNode1.val < listNode2.val) {
            listNode1.next = mergeTwoListsUsingRecursion(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = mergeTwoListsUsingRecursion(listNode1, listNode2.next);
            return listNode2;

        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode(0);
        ListNode listNode = curr;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                listNode.next = list1;
                list1 = list1.next;
            } else {
                listNode.next = list2;
                list2 = list2.next;
            }
            listNode = listNode.next;
        }
        listNode.next = list1 != null ? list1 : list2;
        return curr.next;
    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}

