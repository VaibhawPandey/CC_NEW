package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week1;

import java.util.Random;

public class RandomNode {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
        public ListNode(int x, ListNode next) { val = x; this.next = next;}
    }

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    Random random;
    ListNode headNode;
    public void Solution(ListNode head) {

        headNode = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {

        int res = headNode.val;
        for (int i = 1; headNode != null; i++) {
           if(random.nextInt(i+1) == i) res = headNode.val;
           headNode = headNode.next;
        }

        return res;
    }
}
