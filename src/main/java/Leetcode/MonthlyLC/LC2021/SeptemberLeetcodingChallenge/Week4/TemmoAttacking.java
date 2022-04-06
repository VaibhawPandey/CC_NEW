package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week4;

public class TemmoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if (timeSeries.length == 0)
            return 0;

        int start = timeSeries[0], end = start + duration, res = 0;
        for (int i = 1; i < timeSeries.length; i++) {

            if (end > timeSeries[i]) {
                end = Math.max(end, timeSeries[i] + duration);
            } else {
                res += end - start;
                start = timeSeries[i];
            }
        }

        res += end - start;

        return res;
    }
}
