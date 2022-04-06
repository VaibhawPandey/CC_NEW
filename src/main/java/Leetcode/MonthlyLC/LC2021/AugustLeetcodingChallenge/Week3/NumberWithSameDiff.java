package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week3;

import java.util.*;

public class NumberWithSameDiff {

    public static void main(String[] args) {

        System.out.println(new NumberWithSameDiff().numsSameConsecDiff(3, 7));
    }

    Set<Integer> res;
    public int[] numsSameConsecDiff(int N, int K) {

        res = new HashSet<Integer>();
        if (N == 1)
            res.add(0);

        for (int i = 1; i <= 9; i++) {
            dfs(N-1, i, K);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int digitLengthLeft, int number, int K) {

        if (digitLengthLeft == 0) {
            res.add(number);
            return;
        }

        int lastNumber = number % 10;
        if (isValid(lastNumber + K, K))
            dfs(digitLengthLeft - 1, number * 10 + lastNumber + K, K);

        if (isValid(lastNumber - K, K))
            dfs(digitLengthLeft - 1, number * 10 + lastNumber - K, K);
    }

    public boolean isValid(int num, int K) {
        if (num >= 0 && num <= 9)
            return true;

        return false;
    }
}
