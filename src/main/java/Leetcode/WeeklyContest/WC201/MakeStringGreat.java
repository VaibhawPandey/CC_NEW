package main.java.Leetcode.WeeklyContest.WC201;

import java.lang.invoke.StringConcatException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MakeStringGreat {

    public String makeGood(String s) {

        if (s.length() < 2)
            return s;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {

            if (!stack.isEmpty() && Math.abs(s.charAt(i) - stack.peek()) == 32)
                stack.pop();
            else
                stack.push(s.charAt(i));

        }

        if (stack.size() == 0)
            return "";

        String out = "";
       while (!stack.isEmpty())
            out += stack.pop();

       return out;
    }
}
