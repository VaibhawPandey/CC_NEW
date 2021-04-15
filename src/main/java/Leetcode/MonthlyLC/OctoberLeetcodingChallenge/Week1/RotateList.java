package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week1;

public class RotateList {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;

        ListNode currNode = head;
        int size = 0;
        while (currNode.next != null) {
            size++;
            currNode = currNode.next;
        }

        int diff = size - (k % size);

        if (diff == size)
            return head;

        ListNode rNode = head;
        while (diff > 0) {
            diff--;
            rNode = rNode.next;
        }

        currNode.next = head;
        head = rNode.next;
        rNode.next = null;

        return head;
    }
}
