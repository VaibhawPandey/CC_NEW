package main.java.Leetcode.WeeklyContest.WC210;

import java.util.Stack;

public class MaxDepth {
    public int maxDepth(String s) {

        char sList[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int maxLength = 0;

        for (int i = 0; i < sList.length; i++) {

            if (sList[i] == '(') {
                stack.push('(');
                maxLength = Math.max(maxLength, stack.size());
            } else if (sList[i] == ')') {
                stack.pop();
            }
        }

        return maxLength;
    }
}
