package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week2;

public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
        public ListNode(int x, ListNode next) { val = x; this.next = next;}
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        new SortList().sortList(root);
    }

    public ListNode sortList(ListNode head) {

        if (head == null)
             return head;

        ListNode prev = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);

    }

    private ListNode merge(ListNode head, ListNode slow) {
        ListNode listNode = new ListNode(0), l = listNode;

        while (head != null && slow != null) {
            ListNode p;
            if (head.val < slow.val) {
                p = new ListNode(head.val);
                head = head.next;
            } else {
                p = new ListNode(slow.val);
                slow = slow.next;
            }
            l.next = p;
            l = l.next;
        }

        while (head != null) {
            l.next = new ListNode(head.val);
            head = head.next;
        }

        while (slow != null) {
            l.next = new ListNode(slow.val);
            slow = slow.next;
        }

        return listNode.next;
    }

//    public ListNode sortList(ListNode head) {
//
//        if (head == null || head.next == null)
//            return head;
//
//        ListNode root = head;
//        int depth = 0;
//        while (root != null) {
//            depth++;
//            root = root.next;
//        }
//
//        for (int i = depth; i >= 0; i--) {
//            ListNode currNode = head, nextNode = head.next;
//            head = sortListUtil(currNode, nextNode, depth);
//        }
//
//        return head;
//    }
//
//    private ListNode sortListUtil(ListNode currNode, ListNode nextNode, int depth) {
//
//        if (nextNode == null || depth == 0)
//            return currNode;
//
//        if (currNode.val > nextNode.val) {
//            int temp = currNode.val;
//            currNode.val = nextNode.val;
//            nextNode.val = temp;
//        }
//
//        sortListUtil(currNode.next, nextNode.next, depth--);
//
//        return currNode;
//    }
}
