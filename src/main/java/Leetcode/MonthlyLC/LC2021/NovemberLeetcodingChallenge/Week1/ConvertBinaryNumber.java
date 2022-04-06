package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week1;


public class ConvertBinaryNumber {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int getDecimalValue(ListNode head) {

        int res = 0;
        while (head != null) {
            res = res << 1;
            res |= head.val;
            head = head.next;
        }

        return res;
    }

    // Alternative solution
//    public int getDecimalValue(ListNode head) {
//
//        Stack<Integer> stack = new Stack<>();
//
//        while (head != null) {
//            stack.push(head.val);
//            head = head.next;
//        }
//
//        int index = 0, res = 0;
//        while (!stack.isEmpty()) {
//            res += stack.pop() * Math.pow(2, index);
//            index++;
//        }
//
//        return res;
//    }
}
