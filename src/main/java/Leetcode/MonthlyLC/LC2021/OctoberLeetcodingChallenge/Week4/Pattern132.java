package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week4;

import java.util.*;

public class Pattern132 {

    public static void main(String[] args) {
        System.out.println(new Pattern132().find132pattern(new int[]{-1,3,2,0}));
    }

    class Pair {
        int min;
        int max;

        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public boolean find132pattern(int[] nums) {

        Stack<Pair> stack = new Stack<>();

        for (int num: nums) {
            if (stack.isEmpty() || stack.peek().min > num) stack.push(new Pair(num, num));
            else {
                Pair last = stack.pop();
                if (num < last.max && num > last.min) return true;
                last.max = num;
                while (!stack.isEmpty() && num >= stack.peek().max) stack.pop();

                if (!stack.isEmpty() && num < stack.peek().max && num > stack.peek().max) return true;
                stack.push(last);
            }
        }

        return false;
    }
}
