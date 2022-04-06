package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week3;

import java.util.Arrays;

public class SmallestRange {
    public int smallestRangeII(int[] A, int K) {

        Arrays.sort(A);
        int minDiff = Integer.MAX_VALUE, pos = 0;

        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i-1];
            if (diff < minDiff) {
                minDiff = diff;
                pos = i;
            }
        }

        int first = A[pos]-K, second = A[pos-1]+K;
        return pos == 0 ? 0: minDiff <= K ? minDiff : Math.abs(first-second);
    }
}
