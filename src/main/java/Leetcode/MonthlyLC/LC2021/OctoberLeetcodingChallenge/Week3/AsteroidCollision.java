package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week3;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        new AsteroidCollision().asteroidCollision(new int[]{1,-2,-2,-2});
    }
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }

            if (asteroids[i] < 0) {
                int res = asteroids[i];
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(asteroids[i])) {
                    if (stack.pop() == Math.abs(asteroids[i])) {
                        res = Integer.MAX_VALUE;
                        break;
                    }
                }

                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {}
                else
                if (res != Integer.MAX_VALUE)
                    stack.push(asteroids[i]);
            } else
                stack.push(asteroids[i]);
        }

        int res[] = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i--;
        }

        return res;
    }
}
