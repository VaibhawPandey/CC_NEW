package main.java.Leetcode.MonthlyLC.LC2022.MarchLC;

import main.java.Leetcode.MonthlyLC.LC2022.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodes {
    public static void main(String[] args) {

    }

    public ListNode swapNodes(ListNode head, int k) {

        ListNode dummy = new ListNode(-1, head);
        ListNode first = dummy, second = dummy;

        while (k-- > 0) {
           first = first.next;
        }

        ListNode temp = first;
        while (temp != null) {
            second = second.next;
            temp = temp.next;
        }

        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;

        return dummy.next;
    }

    // Alternative
    public ListNode swapNodes1(ListNode head, int k) {
        List<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        if (arr.size() == 0) return null;

        int temp = arr.get(k-1), pos = arr.size() - k;
        arr.set(k - 1, arr.get(pos));
        arr.set(pos, temp);

        head = new ListNode(-1, new ListNode(arr.get(0)));
        ListNode node = head.next;

        for (int i = 1; i < arr.size(); i++) {
            node.next = new ListNode(arr.get(i));
            node = node.next;
        }

        return head.next;
    }
}
