package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SequentialDigit {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= 9; i++)
            queue.add(i);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num >= low && num <= high) res.add(num);
            int onesDigit = num % 10;

            if (onesDigit < 9 && num * 10 + onesDigit + 1 <= high) queue.add(num * 10 + onesDigit + 1);
        }

        return res;
    }


}
