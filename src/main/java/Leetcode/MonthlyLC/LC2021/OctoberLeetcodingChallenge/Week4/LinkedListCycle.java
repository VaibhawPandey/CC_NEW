package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week4;

public class LinkedListCycle {

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
      }
   }
    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null)
            return null;

        ListNode head1 = head;
        ListNode head2 = head;
        boolean isCycle = false;

        while (head1.next != null && head2.next.next != null) {

            head1 = head1.next;
            head2 = head2.next.next;

            if (head2.next == null) return null;

            if (head1 == head2) {
                isCycle = true;
                break;
            }

        }

        if (!isCycle) return null;
        head1 = head;

        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;
    }
}
