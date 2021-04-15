package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week3;


import java.util.ArrayDeque;
import java.util.Queue;

public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }





    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode h1 = head;
        ListNode h2 = head;

        while (h2.next != null && h2.next.next != null){
            h1 = h1.next;
            h2 = h2.next.next;
        }

        ListNode preMiddle = h1;
        ListNode currentNode = preMiddle.next;

        while (currentNode.next != null) {
            ListNode current = currentNode.next;
            currentNode.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        h1 = head;
        h2 = preMiddle.next;

        while (h1 != preMiddle) {
            preMiddle.next = h2.next;
            h2.next = h1.next;
            h1.next = h2;
            h1 = h2.next;
            h2 = preMiddle.next;
        }

    }


}