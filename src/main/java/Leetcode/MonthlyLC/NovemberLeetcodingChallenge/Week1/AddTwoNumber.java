package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week1;

import java.util.Stack;

public class AddTwoNumber {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null)
            return null;

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> resStack = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int rem = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int temp = stack1.pop() + stack2.pop() + rem;
            rem = temp / 10;
            // System.out.println(temp +" " +rem);
            resStack.push(temp % 10);
        }

        while (!stack1.isEmpty()) {
            int temp = stack1.pop() + rem;
            rem = temp / 10;
            resStack.push(temp % 10);
        }

        while (!stack2.isEmpty()) {
            int temp = stack2.pop() + rem;
            rem = temp / 10;
            resStack.push(temp % 10);
        }

        if (rem != 0)
            resStack.push(rem);

        ListNode resNode = new ListNode();
        ListNode tempResNode = resNode;

        while (!resStack.isEmpty()) {
            tempResNode.next = new ListNode(resStack.pop(), null);
            tempResNode = tempResNode.next;
        }

        return resNode.next;
    }
}
