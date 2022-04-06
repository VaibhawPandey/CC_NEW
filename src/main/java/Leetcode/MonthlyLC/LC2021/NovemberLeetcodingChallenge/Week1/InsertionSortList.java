package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week1;

public class InsertionSortList {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
        public ListNode(int x, ListNode next) { val = x; this.next = next;}
    }
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode prev = head, next = head.next;

        while (next != null) {
            if (next.val < prev.val) {
                ListNode temp = head, prevTemp = null;
                while (temp.val < next.val) {
                    prevTemp = temp;
                    temp = temp.next;
                }

                prev.next = next.next;
                // nextTemp = next.next;
                if (prevTemp == null)
                    head = next;
                else prevTemp.next = next;
                next.next = temp;

                next = prev.next;
                // prev = prev.next;
            } else {
                prev = prev.next;
                next = next.next;
            }
        }

        return head;
    }
}
