package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week4;

public class SwapPairs {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        swapPairs(head);
    }
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode curr = start;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next, second = curr.next.next;
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }

        return start.next;
    }
}
