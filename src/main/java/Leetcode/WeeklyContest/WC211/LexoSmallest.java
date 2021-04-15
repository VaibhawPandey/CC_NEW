package main.java.Leetcode.WeeklyContest.WC211;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class LexoSmallest {
    public static void main(String[] args) {
        new LexoSmallest().findLexSmallestString("43987654", 7, 3);
    }
    public String findLexSmallestString(String s, int a, int b) {

        long number = Long.parseLong(s);
        // long res = number;
        Queue<Long> queue = new ArrayDeque<>();
        queue.add(number);
        HashSet<Long> hashSet = new HashSet<>();

        while (!queue.isEmpty()) {

            long temp = queue.poll();
            if (hashSet.contains(temp))
                continue;

            long div = (long) Math.pow(10, b);
            long num = (long) Math.pow(10, s.length() - b);
            // long t = temp % div;
            // long r = temp / div;
            long left = (temp % div) * num + (temp / div);
            char tempString[] = String.valueOf(temp).toCharArray();
            long right = 0;
            for (int i = 0; i < tempString.length; i++) {
                if (i % 2 == 1)
                right = right * 10 + ((tempString[i] - '0' + a) % 10);
                else
                    right = right * 10 + (tempString[i] - '0');
            }

            if (left > temp && right > temp)
                return String.valueOf(temp);

            hashSet.add(temp);
            queue.add(left);
            queue.add(right);
        }

        return s;
    }
}
